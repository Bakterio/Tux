package cz.bakterio.discord.Tux.commands.slashcommands;

import cz.bakterio.discord.Tux.Tux;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class SlashCommandsManager extends ListenerAdapter {
    private final ArrayList<SlashCommand> commands = new ArrayList<>();
    public SlashCommandsManager() {
        commands.add(new FeedbackCommand());
        
        guildSetup(Tux.testingServer);
    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent e) {
        for (SlashCommand c : commands) {
            if (c.getName().equalsIgnoreCase(e.getName())) {
                c.invoke(e);
                return;
            }
        }
    }

    /**
     * Guild setup only for debugging purposes.
     * @param g Testing guild.
     */
    private void guildSetup(Guild g) {
       for (SlashCommand c : commands)  {
           System.out.println("Command setup: " + c.getName());
           c.setup(g);
       }
    }
}
