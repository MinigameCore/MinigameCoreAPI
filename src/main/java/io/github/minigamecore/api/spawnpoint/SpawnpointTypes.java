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

import static org.spongepowered.api.util.generator.dummy.DummyObjectProvider.createFor;

public final class SpawnpointTypes {

    // SORTFIELDS:ON

    public static final SpawnpointType DEATH = createFor(SpawnpointType.class, "DEATH");

    public static final SpawnpointType GAME_SPAWN = createFor(SpawnpointType.class, "GAME_SPAWN");

    public static final SpawnpointType LOBBY = createFor(SpawnpointType.class, "LOBBY");

    public static final SpawnpointType RESPAWN = createFor(SpawnpointType.class, "RESPAWN");

    public static final SpawnpointType SPECTATOR = createFor(SpawnpointType.class, "SPECTATOR");

    // SORTFIELDS:OFF


    private SpawnpointTypes() {
    }

}
