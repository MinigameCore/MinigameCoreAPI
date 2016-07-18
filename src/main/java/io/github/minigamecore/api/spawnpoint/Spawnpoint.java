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

import io.github.minigamecore.api.spawnpoint.immutable.ImmutableSpawnpoint;
import io.github.minigamecore.api.util.manipulation.Mutable;
import org.spongepowered.api.entity.Transform;
import org.spongepowered.api.scoreboard.Team;
import org.spongepowered.api.util.Identifiable;
import org.spongepowered.api.world.extent.Extent;

import java.util.Collection;

import javax.annotation.Nonnull;

/**
 * .
 * @param <E> .
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
     * .
     *
     * @return "
     */
    @Nonnull
    Collection<Team> getTeams();

    @Nonnull
    Transform<E> getTransform();

    boolean isActive();

    void setActive(boolean active);

    void setSpawnpointType(@Nonnull SpawnpointType spawnpointType);

    void setTeams(@Nonnull Collection<Team> teams);

    void setTransform(Transform<E> transform);

}
