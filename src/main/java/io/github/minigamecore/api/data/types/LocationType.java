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

package io.github.minigamecore.api.data.types;

import io.github.minigamecore.api.data.DataType;
import io.github.minigamecore.api.data.InvalidDataException;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.util.Optional;
import java.util.UUID;

public class LocationType implements DataType<Location<World>> {

    @Override
    public String getId() {
        return "minigamecore:location";
    }

    @Override
    public String getName() {
        return "Location";
    }

    @Override
    public Location<World> deserialize(String input) {
        String[] split = input.split(":", 4);
        if (split.length == 4) {
            Double x = Double.valueOf(split[0]);
            Double y = Double.valueOf(split[1]);
            Double z = Double.valueOf(split[2]);
            UUID worldUuid = UUID.fromString(split[3]);

            Optional<World> wOpt = Sponge.getServer().getWorld(worldUuid);
            if (wOpt.isPresent()) {
                return new Location<World>(wOpt.get(), x, y, z);
            }
        }
        throw new InvalidDataException(input + " could not be parsed to a location!");
    }

    @Override
    public String serialize(Location<World> input) {
        return input.getX() + ":" + input.getY() + ":" + input.getZ() + ":" + input.getExtent().getUniqueId();
    }

}
