package cz.bakterio.discord.Tux.commands;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.exceptions.HierarchyException;

import java.util.List;

public class WindowsCommand extends Command {
    @Override
    public String getName() {
        return "windows";
    }

    @Override
    public String[] getAliases() {
        return new String[0];
    }

    @Override
    public String getHelp() {
        return "Windows, ah dear...";
    }

    @Override
    public List<Role> roles() {
        return null;
    }

    @Override
    public void invoke(GuildMessageReceivedEvent e, String[] args) {
        e.getChannel().sendMessage("""
                Windows? Are you fucking joking to me??? :rage:
                
                No, Windows is pretty good OS, but only for some cases. I am Tux, so fuck outta my server with Windows :window:...
                """).queue();

        try {
            e.getMember().modifyNickname("Windows fanboy").queue();
        } catch (HierarchyException ex) {
            System.out.println("I tried to change " + e.getMember().getUser().getName() + "'s nickname, but he is higher than me :(");
        }
    }
}
