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

import io.github.minigamecore.ap.api.util.Patterns;
import org.spongepowered.api.plugin.Plugin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.regex.Pattern;

/**
 * An annotation used to describe and mark a MinigameCore minigame module.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MinigameModule {

    Pattern MINIGAME_MODULE_ID_PATTERN = Patterns.MINIGAME_MODULE_ID;
    Pattern VERSION_PATTERN = Patterns.MINIGAME_MODULE_VERSION;
    Pattern PLUGIN_ID_PATTERN = Plugin.ID_PATTERN;

    /**
     * The description of the minigame module, explaining what it is.
     *
     * @return The minigame module description, or an empty string if unknown.
     */
    String description() default "";

    /**
     * An ID for the minigame module to be used internally. The ID should be
     * unique as to not conflict with other minigame module.
     *
     * <p>
     *     The minigame module ID must be lowercase and start with a alphabetic
     *     character. t may only contain alphanumeric characters, or
     *     underscores.
     * </p>
     *
     * @return The plugin identifier.
     */
    String id();

    /**
     * The minigame modules that this minigame module depends on.
     *
     * @return The depending minigame modules.
     */
    Depend.MinigameModule[] minigameDependencies() default {};

    /**
     * The human readable name of the minigame module as to be used in
     * descriptions and similar things.
     *
     * @return The minigame module name, or an empty string if unknown.
     */
    String name() default "";

    /**
     * The plugin ID under which this minigame module is registered.
     *
     * @return The plugin identifier.
     * @see Plugin#id()
     */
    String plugin();

    /**
     * The plugins that this minigame module depends on.
     *
     * @return The depending plugins.
     */
    Depend.Plugin[] pluginDependencies() default {};

    /**
     * The version of the plugin.
     *
     * <p>
     *     We follow a strict format for versioning, following the
     *     {@code MAJOR.MINOR.PATCH} format.
     * </p>
     *
     * <p>
     *     The lowest value is {@code 0.0.0} and the highest value is
     *     {@code 9999.9999.9999}.
     * </p>
     *
     * @return The plugin version, or {@code 0.0.0} if unknown.
     */
    String version() default "0.0.0";

}
