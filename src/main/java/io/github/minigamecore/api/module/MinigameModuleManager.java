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

package io.github.minigamecore.api.module;

import com.sun.webkit.plugin.Plugin;
import org.slf4j.Logger;
import org.spongepowered.api.plugin.PluginContainer;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

/**
 * The manager that manages plugins. This manager can retrieve
 * {@link MinigameModuleContainer}s from {@link MinigameModule} instances,
 * getting {@link Logger}s, etc.
 */
public interface MinigameModuleManager {

    /**
     * Get the minigame module container from an instance.
     *
     * @param instance The instance.
     * @return The container.
     */
    Optional<MinigameModuleContainer> fromInstance(Object instance);

    /**
     * Retrieves a {@link MinigameModuleContainer} based on its ID.
     *
     * @param id The plugin ID.
     * @return The plugin, if available, {@link Optional#empty()} otherwise.
     */
    Optional<MinigameModuleContainer> getMinigameModule(String id);

    /**
     * Gets a {@link Collection} of all {@link MinigameModule} by the
     * {@link Plugin} ID.
     *
     * @param id The plugin ID.
     * @return The minigame modules for the plugin.
     */
    Collection<MinigameModuleContainer> getMinigameModules(String id);

    /**
     * Gets a {@link Collection} of all {@link MinigameModule} by the
     * {@link PluginContainer}.
     *
     * @param container The plugin container.
     * @return The minigame modules for the plugin.
     */
    Collection<MinigameModuleContainer> getMinigameModules(PluginContainer container);

    /**
     * Gets a {@link Collection} of all {@link MinigameModule}s.
     *
     * @return The minigame modules.
     */
    Collection<MinigameModuleContainer> getMinigameModules();

    /**
     * Gets a {@link Map} of all {@link MinigameModule}s by the
     * {@link PluginContainer}s.
     *
     * @return The minigame modules.
     */
    Map<PluginContainer, Collection<MinigameModuleContainer>> getMinigameModulesMap();

    /**
     * Checks if a minigame module is loaded based on its ID.
     *
     * @param id the id of the {@link MinigameModule}.
     * @return {@code true} if loaded, {@code false} if not loaded.
     */
    boolean isLoaded(String id);

}
