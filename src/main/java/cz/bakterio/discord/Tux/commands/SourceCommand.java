package cz.bakterio.discord.Tux.commands;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class SourceCommand extends Command {
    @Override
    public String getName() {
        return "source";
    }

    @Override
    public String[] getAliases() {
        return new String[0];
    }

    @Override
    public String getHelp() {
        return "Let's look under the hood.";
    }

    @Override
    public List<Role> roles() {
        return null;
    }

    @Override
    public void invoke(GuildMessageReceivedEvent e, String[] args) {
        e.getChannel().sendMessage("My source code is at: https://github.com/Bakterio/Tux").queue();
    }
}
