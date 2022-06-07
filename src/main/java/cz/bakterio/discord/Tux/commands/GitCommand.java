package cz.bakterio.discord.Tux.commands;

import cz.bakterio.discord.Tux.Tux;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;

public class GitCommand extends Command{
    @Override
    public String getName() {
        return "git";
    }

    @Override
    public String[] getAliases() {
        return new String[0];
    }

    @Override
    public String getHelp() {
        return "Learns you basics of git.";
    }

    @Override
    public List<Role> roles() {
        return null;
    }

    @Override
    public void invoke(MessageReceivedEvent e, String[] args) {
        e.getChannel().sendMessage("""
                %s
                
                Do you want to resend this message via pms? (for better remembering)
                """.formatted(MESSAGE)).queue();

    }

    private static final String MESSAGE = """
            alsfjalsůfjlasfjklůasjladjlůfjalůsjfd alkfjalůsdjf aadfsjaslkdj 
            """;
}
