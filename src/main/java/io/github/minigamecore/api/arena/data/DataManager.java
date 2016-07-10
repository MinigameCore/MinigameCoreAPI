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

import java.util.Optional;

/**
 * Saves and reads data to the disk.
 */
public interface DataManager {

    /**
     * Checks if the key exists in the data file.
     * 
     * @param key The key to check for.
     * @return If the key exists.
     */
            boolean keyExists(String key);

    /**
     * Saves the given data to the data file.
     * 
     * @param key The key to save the data with.
     * @param data The data to save.
     * @param type The type of data.
     */
    <T> void saveData(String key, T data, DataType<T> type);

    /**
     * Loads data from the disk using a key.
     * 
     * @param key The key to load the data using.
     * @param type The type of data that was saved.
     * @return The loaded data, if present.
     */
    <T> Optional<T> loadData(String key, DataType<T> type);

    /**
     * Gets the id of this {@link DataManager}.
     * 
     * @return The id of this {@link DataManager}.
     */
            String getId();
}
