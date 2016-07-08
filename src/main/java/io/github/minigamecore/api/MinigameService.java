package io.github.minigamecore.api;

import com.google.inject.Injector;
import org.spongepowered.api.service.ServiceManager;

import javax.annotation.Nonnull;

/**
 * The main service for MinigameCore.
 *
 * <p>
 *     This service is guaranteed to be present if the plugin is active, so {@link ServiceManager#provideUnchecked(Class)} can be used.
 * </p>
 */
public interface MinigameService {

    @Nonnull
    Injector injector();

}
