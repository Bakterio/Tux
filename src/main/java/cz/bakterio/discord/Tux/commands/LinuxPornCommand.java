package cz.bakterio.discord.Tux.commands;

import cz.bakterio.discord.Tux.RedditScraper;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class LinuxPornCommand extends Command {
    @Override
    public String getName() {
        return "linuxporn";
    }

    @Override
    public String[] getAliases() {
        return new String[0];
    }

    @Override
    public String getHelp() {
        return "Linuxporn :drool:.";
    }

    @Override
    public List<Role> roles() {
        return null;
    }

    @Override
    public void invoke(GuildMessageReceivedEvent e, String[] args) {
        e.getChannel().sendMessage(RedditScraper.scrapeImageMemeApi("linuxporn")).queue();
    }
}
