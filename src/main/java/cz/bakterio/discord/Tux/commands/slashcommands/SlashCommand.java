package cz.bakterio.discord.Tux.commands.slashcommands;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public abstract class SlashCommand {
    /**
     * Name of the command.
     * @return
     */
    public abstract String getName();

    /**
     * Setup data send to the server on start.
     * @param g Setup guild
     */
    public abstract void setup(Guild g);

    /**
     * Invoke the command.
     * @param e Event argument given by discord api
     */
    public abstract void invoke(SlashCommandInteractionEvent e);

}
