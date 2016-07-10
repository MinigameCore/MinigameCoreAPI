package io.github.minigamecore.api.arena;

//import lom

import lombok.Getter;

/**
 * A functional stage of the arena (i.e. lobby, in-game). MUST call arena.next() when done!
 */
public abstract class ArenaStage {

    @Getter
    private final Arena arena;

    @Getter
    private final long timeStarted;

    public ArenaStage(Arena arena) {
        this.arena = arena;
        this.timeStarted = System.currentTimeMillis();
    }

    /**
     * Gets the time remaining for the ArenaStage, in milliseconds.
     *
     * @return The time remaining
     */
    public final long getTimeRemaining() {
        return (timeStarted + getDuration()) - System.currentTimeMillis();
    }

    /**
     * Gets the ID of the ArenaStage. Should be in the form of gamename:stagename, i.e. walls:lobby
     *
     * @return The ID
     */
    public abstract String getId();

    /**
     * Gets the human readable name of the ArenaStage. Can be used for signs and such, so should be short and concise.
     *
     * @return
     */
    public abstract String getName();

    /**
     * Gets the duration of the ArenaStage, in milliseconds.
     *
     * @return The duration
     */
    public abstract long getDuration();

}
