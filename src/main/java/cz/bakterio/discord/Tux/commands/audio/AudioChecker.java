package cz.bakterio.discord.Tux.commands.audio;

import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class AudioChecker {
    public static boolean check(GuildMessageReceivedEvent e) {
        /**
         * Return true if there is a problem, false if not.
         */
        final Member selfMember = e.getGuild().getSelfMember();
        final GuildVoiceState selfVoiceState = selfMember.getVoiceState();

        if (!e.getMember().getVoiceState().inVoiceChannel()) {
            e.getChannel().sendMessage("You are not in voice channel!!!").queue();
            return true;
        } else if (!selfVoiceState.inVoiceChannel()) {
            e.getChannel().sendMessage("I am not in voice channel, please join me.").queue();
            return true;
        } else if (e.getMember().getVoiceState().getChannel() != selfVoiceState.getChannel()) {
            e.getChannel().sendMessage("I am not in the same voice channel as you, you can't control me.").queue();
            return true;
        }
        return false;
    }
}
