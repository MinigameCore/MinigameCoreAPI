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
import static org.spongepowered.api.scoreboard.Team.builder;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.scoreboard.Team;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.Nonnull;

/**
 * .
 */
@CatalogedBy(SpawnpointTypes.class)
public interface SpawnpointType extends CatalogType {

    /**
     * .
     *
     * @param team "
     */
    void addTeam(Team team);

    /**
     * .
     *
     * @param teams "
     */
    void addAllTeams(Collection<Team> teams);

    /**
     * .
     *
     * @param teams "
     */
    default void addAllTeams(Team[] teams) {
         checkNotNull(teams, "teams");

         addAllTeams(asList(teams));
    }

    default boolean containsTeam(String teamName) {
        return false;
    }

    default boolean containsTeam(Team team) {
        return false;
    }

    /**
     * .
     * @param team "
     * @return "
     */
    default Optional<Team> getTeam(String team) {
        Team tempTeam = builder().name(team).build();

        if (getTeams().contains(tempTeam)) {
            return Optional.of(tempTeam);
        }

        return Optional.empty();
    }

    /**
     * .
     *
     * @return "
     */
    @Nonnull
    Collection<Team> getTeams();

    /**
     * .
     *
     * @return "
     */
    boolean isActive();

    /**
     * .
     *
     * @param active "
     */
    void setActive(boolean active);

}
