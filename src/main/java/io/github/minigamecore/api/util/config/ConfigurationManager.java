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

package io.github.minigamecore.api.util.config;

/**
 * The configuration manager.
 *
 * <p>
 *     This can be used register {@link Configuration}s that you may want Minigame Core to load and save appropriately as needed.
 * </p>
 *
 * <p>
 *     Any {@link Configuration}s registered here will be reloaded if Minigame Core is reloaded, aswell as saved automatically when server is
 *     shutting down.
 * </p>
 */
public interface ConfigurationManager {

    /**
     * Registers a {@link Configuration}.
     *
     * @param plugin The plugin instance.
     * @param config The {@link Configuration}.
     */
    void register(Object plugin, Configuration config);

    /**
     * Loads all the {@link Configuration}s registered under the {@code plugin}.
     *
     * @param plugin The plugin instance.
     */
    void load(Object plugin);

    /**
     * Saves all the {@link Configuration}s registered under the {@code plugin}.
     *
     * @param plugin The plugin instance.
     */
    void save(Object plugin);

}
