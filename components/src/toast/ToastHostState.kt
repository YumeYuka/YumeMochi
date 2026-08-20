/*
 * Copyright (c) 2026 YumeYuka
 *
 * SPDX-License-Identifier: BSD 3-Clause License
 */

package moe.yumeyuka.yumemochi.components.toast

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember

@Stable
class ToastHostState internal constructor() {
    private var nextId: Long = 0
    internal val toasts = mutableStateListOf<ToastEntry>()
    internal val exitingToasts = mutableStateListOf<ToastEntry>()

    fun show(
        title: String,
        description: String? = null,
        style: ToastStyle? = null,
    ): Long {
        val id = nextId++
        toasts.add(0, ToastEntry(id, title, description, style))
        return id
    }

    fun dismiss(id: Long) {
        val toast = toasts.firstOrNull { it.id == id } ?: return
        toasts.remove(toast)
        exitingToasts.add(toast)
    }

    fun dismissAll() {
        if (toasts.isEmpty()) return
        exitingToasts.addAll(toasts)
        toasts.clear()
    }

    internal fun completeExit(id: Long) {
        exitingToasts.removeAll { it.id == id }
    }
}

@Composable fun rememberToastHostState(): ToastHostState = remember { ToastHostState() }

internal data class ToastEntry(
    val id: Long,
    val title: String,
    val description: String?,
    val style: ToastStyle?,
)
