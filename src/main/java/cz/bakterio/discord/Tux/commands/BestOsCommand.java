package cz.bakterio.discord.Tux.commands;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.util.ArrayList;
import java.util.List;

public class BestOsCommand extends Command {
    @Override
    public String getName() {
        return "os";
    }

    @Override
    public String[] getAliases() {
        return new String[0];
    }

    @Override
    public String getHelp() {
        return "Can you guess the best os? :computer:";
    }

    @Override
    public List<Role> roles() {
        return null;
    }

    @Override
    public void invoke(MessageReceivedEvent e, String[] args) {
        final ArrayList<Button> buttons = new ArrayList<>();

        buttons.add(Button.primary("windows", "Windows"));
        buttons.add(Button.primary("macos", "MacOS"));
        buttons.add(Button.primary("linux", "Linux"));
        e.getChannel().sendMessage("Select the best OS:").setActionRow(buttons).queue();
    }
}
