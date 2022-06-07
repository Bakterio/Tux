package cz.bakterio.discord.Tux.commands;

import cz.bakterio.discord.Tux.Tux;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.text.SimpleDateFormat;
import java.util.List;

public class OnlineCommand extends Command{
    @Override
    public String getName() {
        return "online";
    }

    @Override
    public String[] getAliases() {
        return new String[0];
    }

    @Override
    public String getHelp() {
        return "Shows bot's online time. :timer:";
    }

    @Override
    public List<Role> roles() {
        return null;
    }

    @Override
    public void invoke(MessageReceivedEvent e, String[] args) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        e.getChannel().sendMessage("Last restart was in: " + formatter.format(Tux.startupDate)).queue();
    }
}
