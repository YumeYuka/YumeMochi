/*
 * Copyright (c) 2026 YumeYuka
 *
 * SPDX-License-Identifier: BSD 3-Clause License
 */

package moe.yumeyuka.yumemochi.build.config

public object YumeMochiBuild {
    public const val group: String = "moe.yumeyuka.yumemochi"
    public const val version: String = "0.1.0"
    public const val githubRepository: String = "YumeYucca/YumeMochi"
    public const val compileSdk: Int = 37
    public const val minSdk: Int = 33
    public const val targetSdk: Int = 37

    public fun namespace(projectPath: String): String = group + projectPath.replace(':', '.')
}
