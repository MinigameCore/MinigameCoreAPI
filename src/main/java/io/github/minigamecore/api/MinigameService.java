package io.github.minigamecore.api;

import com.google.inject.Injector;
import org.spongepowered.api.service.ServiceManager;

import javax.annotation.Nonnull;

/**
 * The main service provided by MinigameCore.
 *
 * <p>
 *     This service is guaranteed to be present if the MinigameCore plugin is active. Therefore {@link ServiceManager#provideUnchecked(Class)} can be safely used. {@link MinigameService} can also be injected.
 * </p>
 */
public interface MinigameService {

    /**
     * Gets the {@link Injector} with extra mappings for MinigameCore
     *
     * @return The injector.
     */
    @Nonnull
    Injector getInjector();

}
