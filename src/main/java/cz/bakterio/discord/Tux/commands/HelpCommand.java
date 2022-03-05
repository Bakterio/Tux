package cz.bakterio.discord.Tux.commands;

import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class HelpCommand extends Command{
    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String[] getAliases() {
        return new String[] {"info", "?"};
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
        MessageBuilder builder = new MessageBuilder("Available commands: (don't forget to **" + CommandsListener.PREFIX + "** prefix)");

        final HashMap<String, Command> commands = new HashMap<>();
        for (Command i : CommandsListener.getCommands()) {
            commands.put(i.getName(), i);
        }

        ArrayList<String> sortedKeys = new ArrayList<String>(commands.keySet());
        Collections.sort(sortedKeys);

        for (String key : sortedKeys) {
            for (Command i : CommandsListener.getCommands()) {
                if (i.getName() == key) {
                    builder.append("\n  **" + i.getName() + "** - " + i.getHelp());
                    break;
                }
            }
        }
        e.getChannel().sendMessage(builder.build()).queue();
    }
}
