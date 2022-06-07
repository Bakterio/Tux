package cz.bakterio.discord.Tux.commands;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;

public class YoutubeCommand extends Command {
    @Override
    public String getName() {
        return "youtube";
    }

    @Override
    public String[] getAliases() {
        return new String[0];
    }

    @Override
    public String getHelp() {
        return "My favourite Linux youtubers.";
    }

    @Override
    public List<Role> roles() {
        return null;
    }

    @Override
    public void invoke(MessageReceivedEvent e, String[] args) {
        e.getChannel().sendMessage("""
                Here is some of my favourite youtube creators:
                  DistroTube - https://www.youtube.com/c/DistroTube
                  The Linux Experiment - https://www.youtube.com/channel/UC5UAwBUum7CPN5buc-_N1Fw
                  TechHut - https://www.youtube.com/c/TechHutHD
                  Brodie Robertson - https://www.youtube.com/user/OmegaDungeon
                  Chris Titus Tech - https://www.youtube.com/user/homergfunk
                """).queue();
    }
}
