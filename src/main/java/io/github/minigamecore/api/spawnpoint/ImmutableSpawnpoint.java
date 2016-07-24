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

package io.github.minigamecore.api.spawnpoint;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.util.Arrays.asList;
import static org.spongepowered.api.Sponge.getRegistry;

import io.github.minigamecore.api.spawnpoint.spawnpointtype.SpawnpointType;
import io.github.minigamecore.api.util.manipulation.Immutable;
import io.github.minigamecore.api.util.manipulation.Mutable;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.Transform;
import org.spongepowered.api.scoreboard.Team;
import org.spongepowered.api.util.Identifiable;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.world.extent.Extent;

import java.util.Collection;

import javax.annotation.Nonnull;

/**
 * A location where a player can spawn for various stages of a game.
 *
 * <p>
 *     This provides an {@link Immutable} instance. If you want to manipulate, use the {@link #asMutable()} to get the {@link Mutable} variant.
 * </p>
 */
public interface ImmutableSpawnpoint extends Identifiable, Immutable<Spawnpoint> {

    /**
     * Creates a new {@link Builder} to build a {@link ImmutableSpawnpoint}.
     *
     * @return The new builder.
     */
    static Builder builder() {
        return getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the {@link Transform} applicable to the entity that spawns at the spawnpoint.
     *
     * @return The transform.
     */
    @Nonnull
    Transform<? extends Extent> getTransform();

    /**
     * Gets the {@link SpawnpointType} for the spawnpoint.
     *
     * @return The spawnpoint type.
     */
    @Nonnull
    SpawnpointType getSpawnpointType();

    /**
     * Gets an unmodifiable collection of {@link Team}s that can spawn at this spawnpoint.
     *
     * <p>
     *     Any attempts to modify it will throw {@link UnsupportedOperationException}.
     * </p>
     *
     * @return The teams.
     */
    @Nonnull
    Collection<Team> getTeams();

    /**
     * Checks whether the spawnpoint is active or not.
     *
     * <p>
     *     This can be used to have controlled spawning.
     * </p>
     *
     * @return true if active; false otherwise
     */
    boolean isActive();

    /**
     * Represents a builder tp create {@link ImmutableSpawnpoint} instances.
     */
    interface Builder extends ResettableBuilder<ImmutableSpawnpoint,Builder> {

        /**
         * If the spawnpoint is active or not.
         *
         * @param active true if active; false otherwise.
         * @return This builder.
         */
        Builder active(boolean active);

        /**
         * Builds an instance of a {@link ImmutableSpawnpoint}.
         *
         * @return A new instance of a {@link ImmutableSpawnpoint}
         * @throws IllegalStateException if the {@link ImmutableSpawnpoint} is not complete
         */
        ImmutableSpawnpoint build() throws IllegalArgumentException;

        /**
         * The {@link SpawnpointType} for this spawnpoint.
         *
         * @param spawnpointType The spawnpoint type.
         * @return This builder.
         */
        Builder spawnpointType(@Nonnull SpawnpointType spawnpointType);

        default Builder teams(@Nonnull Team[] teams) {
            checkNotNull(teams, "teams");

            return teams(asList(teams));
        }

        Builder teams(@Nonnull Collection<Team> teams);

        /**
         * The {@link Transform} for the spawning {@link Entity}.
         *
         * @param transform The {@link Transform}.
         * @param <E> The {@link Extent} type.
         * @return This builder.
         */
        <E extends Extent> Builder transform(@Nonnull Transform<E> transform);

    }

}
