package cz.bakterio.discord.Tux.commands.slashcommands;

import cz.bakterio.discord.Tux.Tux;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class SlashCommandsManager extends ListenerAdapter {
    public SlashCommandsManager() {
        Objects.requireNonNull(Tux.jda.getGuildById("831571722675027999")).upsertCommand("humor", "Humor je super!!!").queue();
    }
}
