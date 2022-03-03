package cz.bakterio.discord.Tux.listeners;

import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.IOException;

public class ReadyListener extends ListenerAdapter {
    @Override
    public void onReady(ReadyEvent e) {
        System.out.println("The bot is ready!!!");
        try {
            Runtime.getRuntime().exec("notify-send \"Tux\" \"I am online!!!\"");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
