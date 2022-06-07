package cz.bakterio.discord.Tux.commands;

import cz.bakterio.discord.Tux.Config;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
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
        return "Shows help. :regional_indicator_w::regional_indicator_o::regional_indicator_w:";
    }

    @Override
    public List<Role> roles() {
        return null;
    }

    @Override
    public void invoke(MessageReceivedEvent e, String[] args) {
        final EmbedBuilder builder = new EmbedBuilder();
        builder.setTitle("My Commands");
        builder.setColor(Color.YELLOW);
        try {
            builder.setDescription("Don't forget the " + Config.getValue("prefix") + " prefix!!!");
        } catch (Config.KeyNotFoundException ex) {
            ex.printStackTrace();
        }

        final HashMap<String, Command> commands = new HashMap<>();
        for (Command i : CommandsListener.getCommands()) {
            commands.put(i.getName(), i);
        }

        ArrayList<String> sortedKeys = new ArrayList<>(commands.keySet());
        Collections.sort(sortedKeys);

        for (String key : sortedKeys) {
            for (Command i : CommandsListener.getCommands()) {
                if (i.getName() == key) {
                    builder.addField(i.getName(), i.getHelp(), false);
                    break;
                }
            }
        }
        e.getChannel().sendMessageEmbeds(builder.build()).queue();
    }
}
