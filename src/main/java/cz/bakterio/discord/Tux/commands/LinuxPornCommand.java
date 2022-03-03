package cz.bakterio.discord.Tux.commands;

import cz.bakterio.discord.Tux.RedditScraper;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

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
        e.getChannel().sendMessage(RedditScraper.scrapeImage("https://www.reddit.com/r/LinuxPorn/")).queue();
    }
}
