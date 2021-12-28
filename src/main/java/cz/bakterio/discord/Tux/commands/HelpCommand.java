package cz.bakterio.discord.Tux.commands;

import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class HelpCommand extends Command{
    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String[] getAliases() {
        return new String[0];
    }

    @Override
    public String getHelp() {
        return "Shows help (wow)";
    }

    @Override
    public List<Role> roles() {
        return null;
    }

    @Override
    public void invoke(GuildMessageReceivedEvent e, String[] args) {
        MessageBuilder builder = new MessageBuilder("Available commands: (don't forget to **sudo** prefix)");

        for (Command i : CommandsListener.getCommands()) {
            builder.append("\n  **" + i.getName() + "** - " + i.getHelp());
        }

        e.getChannel().sendMessage(builder.build()).queue();
    }
}
