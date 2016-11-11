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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.api.asset.Asset;
import org.spongepowered.api.asset.AssetManager;
import org.spongepowered.api.plugin.PluginContainer;

import java.util.Optional;

import javax.annotation.Nonnull;

/**
 * A wrapper around a class marked with an {@link MinigameModule} annotation to retrieve
 * information from the annotation for easier use.
 */
@SuppressWarnings("WeakerAccess")
public interface MinigameModuleContainer {

    /**
     * Retrieves the {@link Asset} of the specified name from the
     * {@link AssetManager} for this {@link MinigameModule}.
     *
     * <p>
     *     The asset should be located at
     *     {@code assets/<b>pluginId</b>/<b>minigameModuleId</b>/}.
     * </p>
     *
     * @param name Name of asset.
     * @return Asset if present, {@link Optional#empty()} otherwise.
     */
    @Nonnull
    default Optional<Asset> getAsset(String name) {
        return Optional.empty();
    }

    /**
     * Gets the description of the {@link MinigameModule} within this container.
     *
     * @return The plugin description, or {@link Optional#empty()} if unknown.
     * @see MinigameModule#description()
     */
    @Nonnull
    default Optional<String> getDescription() {
        return Optional.empty();
    }

    /**
     * Gets the qualified ID of the {@link MinigameModule} within this container.
     *
     * @return The minigame module ID.
     * @see MinigameModule#id()
     */
    @Nonnull
    String getId();

    /**
     * Returns the created instance of {@link MinigameModule} if it is available.
     *
     * @return The instance if available, {@link Optional#empty()} otherwise.
     */
    @Nonnull
    default Optional<?> getInstance() {
        return Optional.empty();
    }

    /**
     * Returns the assigned logger to this {@link MinigameModule}.
     *
     * @return The assigned logger.
     */
    @Nonnull
    default Logger getLogger() {
        return LoggerFactory.getLogger(getPluginOwner().getId() + "|" + getId());
    }

    /**
     * Gets the name of the {@link MinigameModule} within this container.
     *
     * @return The minigame module name, or {@link #getId()} if unknown.
     * @see MinigameModule#name()
     */
    @Nonnull
    default String getName() {
        return getId();
    }

    /**
     * The {@link PluginContainer} for the owning plugin.
     *
     * @return The plugin container.
     */
    @Nonnull
    PluginContainer getPluginOwner();

    /**
     * Gets the version of the {@link MinigameModule} within this container.
     *
     * @return The minigame module version, or {@link Optional#empty()} if
     *         unknown.
     * @see MinigameModule#version()
     */
    @Nonnull
    String getVersion();

}
