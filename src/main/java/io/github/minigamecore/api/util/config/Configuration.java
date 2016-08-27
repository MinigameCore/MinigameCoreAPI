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

package io.github.minigamecore.api.util.config;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.nio.file.Files.createDirectories;
import static java.nio.file.Files.notExists;

import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.hocon.HoconConfigurationLoader;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import org.spongepowered.api.asset.Asset;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import javax.annotation.Nullable;

/**
 * The configuration class.
 */
public final class Configuration {

    private final ConfigurationLoader<CommentedConfigurationNode> loader;
    private final Asset asset;

    private CommentedConfigurationNode node;

    public Configuration(File file) {
        this(file.toPath(), null);
    }

    public Configuration(Path file) {
        this(file, null);
    }

    public Configuration(File file, @Nullable Asset asset) {
        this(file.toPath(), asset);
    }

    public Configuration(Path file, @Nullable Asset asset) {
        checkNotNull(file, "file");

        if (notExists(file)) {
            if (notExists(file.getParent())) {
                try {
                    createDirectories(file.getParent());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        loader = HoconConfigurationLoader.builder().setPath(file).build();
        this.asset = asset;
    }

    public void load() throws IOException {
        node = loader.load();
        if (asset != null) {
            try {
                node.mergeValuesFrom(HoconConfigurationLoader.builder().setURL(asset.getUrl()).build().load());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public CommentedConfigurationNode get() {
        return node;
    }

    public void save() throws IOException {
        loader.save(node);
    }

}
