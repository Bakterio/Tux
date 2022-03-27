package cz.bakterio.discord.Tux.audio;

public class PlayerManager {
    private static PlayerManager INSTANCE;

    public static PlayerManager getINSTANCE() {
        if (INSTANCE == null) INSTANCE = new PlayerManager();
        return INSTANCE;
    }
}
