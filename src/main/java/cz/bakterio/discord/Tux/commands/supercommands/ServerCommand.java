package cz.bakterio.discord.Tux.commands.supercommands;

import cz.bakterio.discord.Tux.commands.Command;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class ServerCommand extends Command {
    @Override
    public String getName() {
        return "server";
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
    public void invoke(GuildMessageReceivedEvent e, String[] args) {
        final MessageBuilder builder = new MessageBuilder("I am on these servers:\n");
        for (Guild g : e.getJDA().getGuilds()) {
            builder.append(g.getName() + "\n");
        }
        e.getChannel().sendMessage(builder.build()).queue();
    }
}
