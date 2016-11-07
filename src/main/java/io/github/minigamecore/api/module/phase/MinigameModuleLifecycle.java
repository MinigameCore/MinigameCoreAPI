/*
 * This file is part of MinigameCoreAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2016 - 2016 MinigameCore <http://minigamecore.github.io>
 * Copyright (c) Contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package io.github.minigamecore.api.module.phase;

import org.spongepowered.api.GameState;

/**
 * The top to bottom minigame module lifecycle phases.
 */
@SuppressWarnings("WeakerAccess")
public enum MinigameModuleLifecycle {

    /**
     * Minigame modules are able to access a default logger instance and access
     * configuration files.
     *
     * <p>
     *     Corresponds to {@link GameState#PRE_INITIALIZATION}.
     * </p>
     */
    PRE_INITIALIZATION,

    /**
     * Minigame modules should finish any work needed to become functional.
     *
     * <p>
     *     Commands should be registered at this stage.
     * </p>
     *
     * <p>
     *     Corresponds to {@link GameState#INITIALIZATION}.
     * </p>
     */
    INITIALIZATION,

    /**
     * Plugins have been initialized and should be ready for action. Loggers,
     * configurations, and third party minigame module API's should be prepared
     * for interaction.
     *
     * <p>
     *     Corresponds to {@link GameState#POST_INITIALIZATION}.
     * </p>
     */
    POST_INITIALIZATION,

    /**
     * The platform instance exists, but worlds have not yet loaded.
     *
     * <p>
     *     Corresponds to {@link GameState#SERVER_ABOUT_TO_START}.
     * </p>
     */
    PLATFORM_ABOUT_TO_START,

    /**
     * The platform instance exists and worlds are loaded.
     *
     * <p>
     *     Corresponds to {@link GameState#SERVER_STARTING}.
     * </p>
     */
    PLATFORM_STARTING,

    /**
     * The platform is fully loaded and ready to accept clients.
     *
     * <p>
     *     All worlds are loaded and all minigame modules have been loaded.
     * </p>
     *
     * <p>
     *     Corresponds to {@link GameState#SERVER_STARTED}.
     * </p>
     */
    PLATFORM_STARTED,

    /**
     * The platform is stopping for any reason.
     *
     * <p>
     *     This occurs prior to world saving.
     * </p>
     *
     * <p>
     *     Corresponds to {@link GameState#SERVER_STOPPING}.
     * </p>
     */
    PLATFORM_PREPARE_STOPPING,

    /**
     * The platform has stopped saving and no players are connected.
     *
     * <p>
     *     Any changes to the worlds are not saved.
     * </p>
     *
     * <p>
     *     Corresponds to {@link GameState#SERVER_STOPPED}.
     * </p>
     */
    PLATFORM_PRE_STOPPING,

    /**
     * The platform is stopping, all network connections should be closed, all
     * minigame modules should prepare for shutdown, closing all files.
     *
     * <p>
     *     Note: In the case that the JVM is terminated, this state may never
     *     be reached.
     * </p>
     *
     * <p>
     *     Corresponds to {@link GameState#GAME_STOPPING}.
     * </p>
     */
    PLATFORM_STOPPING

}
