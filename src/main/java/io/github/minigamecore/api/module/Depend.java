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

import static org.spongepowered.api.plugin.Plugin.ID_PATTERN;

import io.github.minigamecore.ap.api.util.Patterns;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.regex.Pattern;

/**
 * Dependency types for {@link io.github.minigamecore.api.module.MinigameModule
 * #minigameDependencies()} and
 * {@link io.github.minigamecore.api.module.MinigameModule#pluginDependencies()}.
 */
@SuppressWarnings("WeakerAccess")
public final class Depend {

    /**
     * Minigame module dependencies for a
     * {@link io.github.minigamecore.api.module.MinigameModule}.
     */
    @SuppressWarnings("unused")
    @Retention(RetentionPolicy.RUNTIME)
    @Target({})
    public @interface MinigameModule {

    Pattern MINIGAME_MODULE_ID_PATTERN = Patterns.MINIGAME_MODULE_ID;
    Pattern MINIGAME_MODULE_VERSION_PATTERN = Patterns.MINIGAME_MODULE_VERSION;
    Pattern MINIGAME_MODULE_VERSION_RANGE_PATTERN = Patterns.MINIGAME_MODULE_VERSION_RANGE;
    Pattern PLUGIN_ID_PATTERN = ID_PATTERN;

        /**
         * The id of the minigame module.
         *
         * @return The identifier.
         * @see io.github.minigamecore.api.module.MinigameModule#id()
         */
        String id();

        /**
         * If the minigame module is optional.
         *
         * <p>
         *     Defaults to {@code false}.
         * </p>
         *
         * @return True if optional, false otherwise.
         */
        boolean optional() default false;

        /**
         * The required version range of the minigame module dependency.
         *
         * <table>
         *     <tr>
         *         <th>Range</th>
         *         <th>Meaning</th>
         *     </tr>
         *     <tr>
         *         <td>0.1.0</td>
         *         <td>x = 0.1.0</td>
         *     </tr>
         *     <tr>
         *         <td>(0.1.0,0.2.0)</td>
         *         <td>0.1.0 &lt; x &lt; 0.2.0</td>
         *     </tr>
         *     <tr>
         *         <td>[0.1.0,0.2.0]</td>
         *         <td>0.1.0 &lt;= x &lt;= 0.2.0</td>
         *     </tr>
         *     <tr>
         *         <td>(,0.2.0)</td>
         *         <td>0.0.0 &lt; x &lt; 0.2.0</td>
         *     </tr>
         *     <tr>
         *         <td>(0.1.0,)</td>
         *         <td>0.1.0 &lt; x &lt; 9999.9999.9999</td>
         *     </tr>
         *     <tr>
         *         <td>[,0.2.0)</td>
         *         <td>0.0.0 &lt;= x &lt; 0.2.0</td>
         *     </tr>
         *     <tr>
         *         <td>(0.1.0,]</td>
         *         <td>0.1.0 &lt; x &lt;= 9999.9999.9999</td>
         *     </tr>
         * </table>
         *
         * @return The required version range, or {@code 0.0.0} if unspecified.
         */
        String version() default "0.0.0";

    }

    @SuppressWarnings("unused")
    @Retention(RetentionPolicy.RUNTIME)
    @Target({})
    public @interface Plugin {

    Pattern PLUGIN_ID_PATTERN = ID_PATTERN;

        /**
         * The id of the minigame module.
         *
         * @return The identifier.
         * @see org.spongepowered.api.plugin.Plugin#id()
         */
        String id();

        /**
         * If the plugin is optional.
         *
         * <p>
         *     Defaults to {@code false}.
         * </p>
         *
         * @return True if optional, false otherwise.
         */
        boolean optional() default false;

    }

    private Depend() {
    }

}
