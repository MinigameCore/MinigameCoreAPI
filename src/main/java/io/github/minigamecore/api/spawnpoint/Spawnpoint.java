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

import io.github.minigamecore.api.spawnpoint.spawnpointtype.SpawnpointType;
import io.github.minigamecore.api.util.manipulation.Mutable;
import org.spongepowered.api.entity.Transform;
import org.spongepowered.api.scoreboard.Team;
import org.spongepowered.api.util.Identifiable;
import org.spongepowered.api.world.extent.Extent;

import java.util.Collection;

import javax.annotation.Nonnull;

/**
 * A location where a player can spawn for various stages of a game.
 *
 * <p>
 *     This provides an {@link Mutable} instance.
 * </p>
 */
public interface Spawnpoint<E extends Extent> extends Identifiable, Mutable<ImmutableSpawnpoint> {

    /**
     * Gets the {@link SpawnpointType} for the spawnpoint.
     *
     * @return The spawnpoint type.
     */
    @Nonnull
    SpawnpointType getSpawnpointType();

    /**
     * Gets the {@link Team}s that can spawn at this spawnpoint.
     *
     * @return The teams.
     */
    @Nonnull
    Collection<Team> getTeams();

    /**
     * Gets the {@link Transform} applicable to the entity that spawns at the spawnpoint.
     *
     * @return The transform.
     */
    @Nonnull
    Transform<E> getTransform();

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
     * Sets the status of the spawnpoint.
     *
     * @param active true if active; false otherwise.
     */
    void setActive(boolean active);

    /**
     * Sets the {@link SpawnpointType} for the spawnpoint.
     *
     * @param spawnpointType The spawnpoint type.
     */
    void setSpawnpointType(@Nonnull SpawnpointType spawnpointType);

    /**
     * Sets the {@link Team}s that can spawn at the spawnpoint.
     *
     * @param teams The teams.
     */
    void setTeams(@Nonnull Collection<Team> teams);

    /**
     * Sets the {@link Transform} for the entity that spawns at the spawnpoint.
     *
     * @param transform The transform.
     */
    void setTransform(Transform<E> transform);

}
