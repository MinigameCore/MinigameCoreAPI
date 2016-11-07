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

import io.github.minigamecore.api.module.MinigameModule;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Used to annotate a method as an {@link MinigameModule} method, triggering
 * at each {@link MinigameModuleLifecycle}.
 *
 * <p>
 *     The method being targeted must be public, have a void return type and
 *     must be in a class that is also public and annotated with
 *     {@link MinigameModule}.
 * </p>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Lifecycle {

    /**
     * The order for execution.
     *
     * <p>
     *     Defaults to {@link PhaseOrder#NORMAL}.
     * </p>
     *
     * @return The order.
     */
    PhaseOrder order() default PhaseOrder.NORMAL;

    /**
     * Used to annotate a method as an {@link MinigameModule} method,
     * triggering at {@link MinigameModuleLifecycle#PRE_INITIALIZATION}.
     *
     * <p>
     *     The method being targeted must be public, have a void return type and
     *     must be in a class that is also public and annotated with
     *     {@link MinigameModule}.
     * </p>
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface PreInit {

        /**
         * The order for execution.
         *
         * <p>
         *     Defaults to {@link PhaseOrder#NORMAL}.
         * </p>
         *
         * @return The order.
         */
        PhaseOrder order() default PhaseOrder.NORMAL;

    }

    /**
     * Used to annotate a method as an {@link MinigameModule} method,
     * triggering at {@link MinigameModuleLifecycle#INITIALIZATION}.
     *
     * <p>
     *     The method being targeted must be public, have a void return type and
     *     must be in a class that is also public and annotated with
     *     {@link MinigameModule}.
     * </p>
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface Init {

        /**
         * The order for execution.
         *
         * <p>
         *     Defaults to {@link PhaseOrder#NORMAL}.
         * </p>
         *
         * @return The order.
         */
        PhaseOrder order() default PhaseOrder.NORMAL;

    }

    /**
     * Used to annotate a method as an {@link MinigameModule} method,
     * triggering at {@link MinigameModuleLifecycle#POST_INITIALIZATION}.
     *
     * <p>
     *     The method being targeted must be public, have a void return type and
     *     must be in a class that is also public and annotated with
     *     {@link MinigameModule}.
     * </p>
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface PostInit {

        /**
         * The order for execution.
         *
         * <p>
         *     Defaults to {@link PhaseOrder#NORMAL}.
         * </p>
         *
         * @return The order.
         */
        PhaseOrder order() default PhaseOrder.NORMAL;

    }

    /**
     * Used to annotate a method as an {@link MinigameModule} method,
     * triggering at {@link MinigameModuleLifecycle#PLATFORM_ABOUT_TO_START}.
     *
     * <p>
     *     The method being targeted must be public, have a void return type and
     *     must be in a class that is also public and annotated with
     *     {@link MinigameModule}.
     * </p>
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface AboutToStart {

        /**
         * The order for execution.
         *
         * <p>
         *     Defaults to {@link PhaseOrder#NORMAL}.
         * </p>
         *
         * @return The order.
         */
        PhaseOrder order() default PhaseOrder.NORMAL;

    }

    /**
     * Used to annotate a method as an {@link MinigameModule} method,
     * triggering at {@link MinigameModuleLifecycle#PLATFORM_STARTING}.
     *
     * <p>
     *     The method being targeted must be public, have a void return type and
     *     must be in a class that is also public and annotated with
     *     {@link MinigameModule}.
     * </p>
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface Starting {

        /**
         * The order for execution.
         *
         * <p>
         *     Defaults to {@link PhaseOrder#NORMAL}.
         * </p>
         *
         * @return The order.
         */
        PhaseOrder order() default PhaseOrder.NORMAL;

    }

    /**
     * Used to annotate a method as an {@link MinigameModule} method,
     * triggering at {@link MinigameModuleLifecycle#PLATFORM_STARTED}.
     *
     * <p>
     *     The method being targeted must be public, have a void return type and
     *     must be in a class that is also public and annotated with
     *     {@link MinigameModule}.
     * </p>
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface Started {

        /**
         * The order for execution.
         *
         * <p>
         *     Defaults to {@link PhaseOrder#NORMAL}.
         * </p>
         *
         * @return The order.
         */
        PhaseOrder order() default PhaseOrder.NORMAL;

    }

    /**
     * Used to annotate a method as an {@link MinigameModule} method,
     * triggering at {@link MinigameModuleLifecycle#PLATFORM_PREPARE_STOPPING}.
     *
     * <p>
     *     The method being targeted must be public, have a void return type and
     *     must be in a class that is also public and annotated with
     *     {@link MinigameModule}.
     * </p>
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface PrepareStopping {

        /**
         * The order for execution.
         *
         * <p>
         *     Defaults to {@link PhaseOrder#NORMAL}.
         * </p>
         *
         * @return The order.
         */
        PhaseOrder order() default PhaseOrder.NORMAL;

    }

    /**
     * Used to annotate a method as an {@link MinigameModule} method,
     * triggering at {@link MinigameModuleLifecycle#PLATFORM_PRE_STOPPING}.
     *
     * <p>
     *     The method being targeted must be public, have a void return type and
     *     must be in a class that is also public and annotated with
     *     {@link MinigameModule}.
     * </p>
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface PreStopping {

        /**
         * The order for execution.
         *
         * <p>
         *     Defaults to {@link PhaseOrder#NORMAL}.
         * </p>
         *
         * @return The order.
         */
        PhaseOrder order() default PhaseOrder.NORMAL;

    }

    /**
     * Used to annotate a method as an {@link MinigameModule} method,
     * triggering at {@link MinigameModuleLifecycle#PLATFORM_STOPPING}.
     *
     * <p>
     *     The method being targeted must be public, have a void return type and
     *     must be in a class that is also public and annotated with
     *     {@link MinigameModule}.
     * </p>
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface Stopping {

        /**
         * The order for execution.
         *
         * <p>
         *     Defaults to {@link PhaseOrder#NORMAL}.
         * </p>
         *
         * @return The order.
         */
        PhaseOrder order() default PhaseOrder.NORMAL;

    }

}
