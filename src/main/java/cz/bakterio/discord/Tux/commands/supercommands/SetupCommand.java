package cz.bakterio.discord.Tux.commands.supercommands;

import cz.bakterio.discord.Tux.Tux;
import cz.bakterio.discord.Tux.commands.Command;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;
import java.util.Objects;

/**
 * Testing command.
 */
public class SetupCommand extends Command {
    @Override
    public String getName() {
        return "setup";
    }

    @Override
    public String[] getAliases() {
        return new String[0];
    }

    @Override
    public String getHelp() {
        return "Add server slash commands";
    }

    @Override
    public List<Role> roles() {
        return null;
    }

    @Override
    public void invoke(MessageReceivedEvent e, String[] args) {
        try {
            // setup code here
        } finally {
            e.getMessage().reply("Setup has been done successfully").queue();
        }
    }
}
