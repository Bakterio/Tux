package cz.bakterio.discord.Tux.commands;

import cz.bakterio.discord.Tux.RedditScraper;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class PornCommand extends Command {
    @Override
    public String getName() {
        return "porn";
    }

    @Override
    public String[] getAliases() {
        return new String[0];
    }

    @Override
    public String getHelp() {
        return "Porn :face_with_monocle:.";
    }

    @Override
    public List<Role> roles() {
        return null;
    }

    @Override
    public void invoke(GuildMessageReceivedEvent e, String[] args) {
        e.getChannel().sendMessage(RedditScraper.scrapeImage("https://www.reddit.com/r/porn/")).queue();
    }
}
