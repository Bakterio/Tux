package cz.bakterio.discord.Tux.commands;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public abstract class Command {
    /**
     * @return Commands name
     */
    public abstract String getName();

    public abstract String[] getAliases();

    /**
     * Short command's description shown in help.
     * Has to start with uppercase letter.
     *
     * @return help
     */
    public abstract String getHelp();

    public abstract List<Role> roles();

    public abstract void invoke(GuildMessageReceivedEvent e, String[] args);
}
