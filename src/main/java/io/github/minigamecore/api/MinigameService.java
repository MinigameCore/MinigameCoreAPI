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

package io.github.minigamecore.api;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.inject.Injector;
import com.google.inject.Module;
import io.github.minigamecore.api.util.config.ConfigurationManager;
import org.spongepowered.api.service.ServiceManager;

import javax.annotation.Nonnull;

/**
 * The main service provided by MinigameCore.
 *
 * <p>
 *     This service is guaranteed to be present if the MinigameCore plugin is active. Therefore {@link ServiceManager#provideUnchecked(Class)} can be
 *     safely used. {@link MinigameService} can also be injected.
 * </p>
 */
public interface MinigameService {

    /**
     * Gets the {@link Injector} with extra mappings for MinigameCore
     *
     * @return The injector.
     */
    @Nonnull
    Injector getInjector();

    /**
     * Registers the guice {@link Module} for the MinigameCore injector
     *
     * @param module The guice {@link Module}.
     */
    void registerChildInjector(@Nonnull Module module);

    /**
     * Registers the guice {@link Module}s for the MinigameCore injector.
     *
     * @param modules The guice modules to register.
     * @see #registerChildInjector(Module)
     */
    default void registerChildInjector(Module[] modules) {
        checkNotNull(modules, "modules");

        for (Module module: modules) {
            registerChildInjector(module);
        }
    }

    /**
     * Gets the {@link ConfigurationManager}.
     *
     * @return The ConfigurationManager.
     */
    @Nonnull
    ConfigurationManager getConfigurationManager();

}
