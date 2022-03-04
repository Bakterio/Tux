package cz.bakterio.discord.Tux.commands;

import cz.bakterio.discord.Tux.Censorship;
import cz.bakterio.discord.Tux.RedditScraper;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.LinkedList;
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
        //e.getChannel().sendMessage(RedditScraper.scrapeImage("https://www.reddit.com/r/porn/")).queue();
        if (!e.getChannel().isNSFW()) {
            e.getChannel().sendMessage("I can't send it here, this is not NSFW channel... :smile:").queue();
            return;
        }
        e.getMessage().addReaction("U+1F924").queue();
        e.getChannel().sendMessage(RedditScraper.scrapeImageMemeApi("porn")).queue();
        Censorship.tempChangeNickname(e.getMember(), "Weird person", 30);
    }
}
