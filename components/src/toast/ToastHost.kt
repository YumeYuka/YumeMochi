/*
 * Copyright (c) 2026 YumeYuka
 *
 * SPDX-License-Identifier: BSD 3-Clause License
 */

package moe.yumeyuka.yumemochi.components.toast

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.*
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

@Composable
fun ToastHost(
    state: ToastHostState,
    modifier: Modifier = Modifier,
    placement: ToastPlacement = ToastPlacement.Top,
) {
    val activeToasts = state.toasts.toList()
    val visibleToasts = activeToasts.take(MAX_VISIBLE_TOASTS)
    val visibleIndices = visibleToasts.mapIndexed { index, toast -> toast.id to index }.toMap()
    val exitingToasts = state.exitingToasts.toList()
    val exitingIds = exitingToasts.mapTo(mutableSetOf(), ToastEntry::id)
    val renderedToasts = visibleToasts + exitingToasts
    var topToastHeightPx by remember { mutableIntStateOf(0) }
    val density = LocalDensity.current
    val topToastHeight = with(density) { topToastHeightPx.toDp() }
    val windowHeightPx = LocalWindowInfo.current.containerSize.height
    val stackedToastHeight by
        animateDpAsState(
            targetValue = topToastHeight,
            animationSpec = tween(STACK_ANIMATION_MILLIS, easing = ToastMotionEasing),
            label = "toastStackHeight",
        )

    LaunchedEffect(activeToasts.firstOrNull()?.id) {
        if (activeToasts.isNotEmpty()) {
            delay(TOAST_DURATION_MILLIS.milliseconds)
            state.dismissAll()
        }
    }

    Box(
        modifier =
            modifier
                .fillMaxWidth()
                .windowInsetsPadding(
                    if (placement == ToastPlacement.Top) WindowInsets.statusBars
                    else WindowInsets.navigationBars,
                )
                .wrapContentHeight()
    ) {
        renderedToasts
            .sortedByDescending { visibleIndices[it.id] ?: Int.MAX_VALUE }
            .forEach { toast ->
                key(toast.id) {
                    val visibleStackIndex = visibleIndices[toast.id]
                    val isVisible = visibleStackIndex != null && toast.id !in exitingIds
                    var lastVisibleStackIndex by remember { mutableIntStateOf(0) }
                    val stackIndex = visibleStackIndex ?: lastVisibleStackIndex
                    val stackDirection = if (placement == ToastPlacement.Top) 1 else -1
                    val motionDirection = if (placement == ToastPlacement.Top) -1 else 1
                    val visibility = remember { MutableTransitionState(false) }
                    val offset by
                        animateDpAsState(
                            targetValue = STACK_OFFSET * stackIndex * stackDirection,
                            animationSpec =
                                tween(STACK_ANIMATION_MILLIS, easing = ToastMotionEasing),
                            label = "toastStackOffset",
                        )
                    val scale by
                        animateFloatAsState(
                            targetValue =
                                (1f - stackIndex * STACK_SCALE_STEP).coerceAtLeast(MIN_STACK_SCALE),
                            animationSpec =
                                tween(STACK_ANIMATION_MILLIS, easing = ToastMotionEasing),
                            label = "toastStackScale",
                        )

                    LaunchedEffect(visibleStackIndex) {
                        if (visibleStackIndex != null) lastVisibleStackIndex = visibleStackIndex
                        visibility.targetState = isVisible
                    }
                    LaunchedEffect(isVisible, visibility.isIdle, visibility.currentState) {
                        if (!isVisible && visibility.isIdle && !visibility.currentState) {
                            state.completeExit(toast.id)
                        }
                    }

                    AnimatedVisibility(
                        visibleState = visibility,
                        enter =
                            slideInVertically(
                                spring(Spring.DampingRatioNoBouncy, Spring.StiffnessMediumLow)
                            ) {
                                motionDirection * maxOf(windowHeightPx, it)
                            },
                        exit =
                            slideOutVertically(tween(150, easing = ToastExitEasing)) {
                                motionDirection * 100
                            },
                        modifier =
                            Modifier.graphicsLayer {
                                translationY = offset.toPx()
                                scaleX = scale
                                scaleY = scale
                                transformOrigin =
                                    TransformOrigin(
                                        pivotFractionX = 0.5f,
                                        pivotFractionY =
                                            if (placement == ToastPlacement.Top) 0f else 1f,
                                    )
                            },
                    ) {
                        Box(
                            modifier =
                                if (stackIndex > 0 && stackedToastHeight != 0.dp) {
                                    Modifier.height(stackedToastHeight).clipToBounds()
                                } else {
                                    Modifier
                                }
                        ) {
                            Toast(
                                title = toast.title,
                                description = toast.description,
                                modifier =
                                    if (stackIndex == 0) {
                                        Modifier.onSizeChanged { topToastHeightPx = it.height }
                                    } else {
                                        Modifier
                                    },
                                style = toast.style ?: ToastDefaults.default(),
                            )
                        }
                    }
                }
            }
    }
}

private const val MAX_VISIBLE_TOASTS = 3
private const val TOAST_DURATION_MILLIS = 3_000L
private const val STACK_ANIMATION_MILLIS = 220
private val STACK_OFFSET = 10.dp
private const val STACK_SCALE_STEP = 0.04f
private const val MIN_STACK_SCALE = 0.88f
private val ToastMotionEasing = CubicBezierEasing(0.23f, 1f, 0.32f, 1f)
private val ToastExitEasing = CubicBezierEasing(0.4f, 0f, 1f, 1f)
