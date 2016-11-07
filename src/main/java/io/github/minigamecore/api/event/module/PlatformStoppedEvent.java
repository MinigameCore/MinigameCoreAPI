package io.github.minigamecore.api.event.module;

import io.github.minigamecore.api.module.phase.MinigameModuleLifecycle;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.game.state.GameStoppingEvent;

/**
 * Event fired after {@link MinigameModuleLifecycle#PLATFORM_STOPPING} to
 * indicate that Minigame Core has finished its work.
 *
 * <p>
 *     This is where plugins should do their non minigame shutdown steps,
 *     instead of {@link GameStoppingEvent}.
 * </p>
 */
public interface PlatformStoppedEvent extends Event {

}
