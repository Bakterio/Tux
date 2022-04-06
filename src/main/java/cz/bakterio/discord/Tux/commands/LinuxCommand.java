package cz.bakterio.discord.Tux.commands;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class LinuxCommand extends Command {
    @Override
    public String getName() {
        return "linux";
    }

    @Override
    public String[] getAliases() {
        return new String[0];
    }

    @Override
    public String getHelp() {
        return "Return short text about GNU/Linux. :computer:";
    }

    @Override
    public List<Role> roles() {
        return null;
    }

    @Override
    public void invoke(GuildMessageReceivedEvent e, String[] args) {
        e.getChannel().sendMessage("Linux is a family of open-source Unix-like operating systems based on the Linux kernel," +
                "an operating system kernel first released on September 17, 1991, by Linus Torvalds. " +
                "Linux is typically packaged in a Linux distribution.").queue();
    }

}
