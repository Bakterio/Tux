package cz.bakterio.discord.Tux.commands;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import org.jetbrains.annotations.NotNull;

public class CommandData extends GuildMessageReceivedEvent {
    public CommandData(@NotNull JDA api, long responseNumber, @NotNull Message message) {
        super(api, responseNumber, message);
    }

    public Member getSender() {
        return getMember();
    }
}
