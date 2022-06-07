package cz.bakterio.discord.Tux.commands;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;

public class PlaylistCommand extends Command {
    @Override
    public String getName() {
        return "playlist";
    }

    @Override
    public String[] getAliases() {
        return new String[0];
    }

    @Override
    public String getHelp() {
        return "Shows you playlist of my favourite YT videos.";
    }

    @Override
    public List<Role> roles() {
        return null;
    }

    @Override
    public void invoke(MessageReceivedEvent e, String[] args) {
        final String[] links = new String[] {
            ""
        };

        final int lenght = 30;

        for (String link : links) {

        }
    }
}
