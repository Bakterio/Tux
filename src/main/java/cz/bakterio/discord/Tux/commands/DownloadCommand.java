package cz.bakterio.discord.Tux.commands;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class DownloadCommand extends Command{
    @Override
    public String getName() {
        return "download";
    }

    @Override
    public String[] getAliases() {
        return new String[0];
    }

    @Override
    public String getHelp() {
        return "Shows some download sites.";
    }

    @Override
    public List<Role> roles() {
        return null;
    }

    @Override
    public void invoke(GuildMessageReceivedEvent e, String[] args) {
        String output = """
            Here is some sites where you can download Linux:
              Ubuntu - ubuntu.com
              Fedora - getferdora.org
              ArchLinux - archlinux.org
            """;

        e.getChannel().sendMessage(output).queue();
    }
}
