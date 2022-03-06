package cz.bakterio.discord.Tux.commands;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.interactions.components.Button;

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
        return null;
    }

    @Override
    public List<Role> roles() {
        return null;
    }

    @Override
    public void invoke(GuildMessageReceivedEvent e, String[] args) {
        final ArrayList<Button> buttons = new ArrayList<>();

        buttons.add(Button.primary("windows", "Windows"));
        buttons.add(Button.primary("macos", "MacOS"));
        buttons.add(Button.primary("linux", "Linux"));
        e.getChannel().sendMessage("Select the best OS:").setActionRow(buttons).queue();
    }
}
