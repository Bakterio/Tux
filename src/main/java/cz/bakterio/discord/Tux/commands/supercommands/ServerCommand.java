package cz.bakterio.discord.Tux.commands.supercommands;

import cz.bakterio.discord.Tux.commands.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.List;

public class ServerCommand extends Command {
    @Override
    public String getName() {
        return "servers";
    }

    @Override
    public String[] getAliases() {
        return new String[0];
    }

    @Override
    public String getHelp() {
        return null;
    }

    @Override
    public List<Role> roles() {
        return null;
    }

    @Override
    public void invoke(MessageReceivedEvent e, String[] args) {
        final EmbedBuilder builder = new EmbedBuilder();
        builder.setTitle("Servers");
        builder.setColor(Color.YELLOW);
        for (Guild g : e.getJDA().getGuilds()) {
            builder.addField(g.getName() + "\n", "Members: " + g.getMemberCount(), false);
        }
        e.getChannel().sendMessageEmbeds(builder.build()).queue();
    }
}
