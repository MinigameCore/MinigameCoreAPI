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

package io.github.minigamecore.api.arena.data;

import org.spongepowered.api.CatalogType;

/**
 * Used to save objects to files and databases.
 * 
 * @param <T> The type of the object.
 */
//TODO Create a register module for DataType
public interface DataType<T> extends CatalogType {

    /**
     * Converts the input string to an object.
     * 
     * @param input The string to convert.
     * @return A object containing the data of the string.
     * @throws InvalidDataException If the string could not be deserialized.
     */
            T deserialize(String input);

    /**
     * Converts the input object to a string.
     * 
     * @param input The object to convert.
     * @return A string representative of the input object.
     */
            String serialize(T input);
}
