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

import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector3i;
import io.github.minigamecore.api.spawnpoint.immutable.ImmutableSpawnpoint;
import io.github.minigamecore.api.util.manipulation.Mutable;
import org.spongepowered.api.scoreboard.Team;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.extent.Extent;

import java.util.Collection;

import javax.annotation.Nonnull;

/**
 * .
 * @param <E> .
 */
public interface Spawnpoint<E extends Extent> extends Mutable<ImmutableSpawnpoint> {

    @Nonnull
    Location<E> getLocation();

    @Nonnull
    SpawnpointType getSpawnpointType();

    /**
     * .
     *
     * @return "
     */
    @Nonnull
    Collection<Team> getTeams();

    boolean isActive();

    void setActive(boolean active);

    void setLocation(E extent, Vector3d position);

    void setLocation(E extent, Vector3i position);

    default void setLocation(E extent, double x, double y, double z) {
        checkNotNull(extent, "extent");
        checkNotNull(x, "x");
        checkNotNull(y, "y");
        checkNotNull(z, "z");

        setLocation(extent, new Vector3d(x, y, z));
    }

    default void setLocation(E extent, int x, int y, int z) {
        checkNotNull(extent, "extent");
        checkNotNull(x, "x");
        checkNotNull(y, "y");
        checkNotNull(z, "z");

        setLocation(extent, new Vector3i(x, y, z));
    }

    void setSpawnpointType(SpawnpointType spawnpointType);

}
