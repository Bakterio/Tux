package cz.bakterio.discord.Tux.commands.audio;

import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import com.sedmelluq.discord.lavaplayer.track.AudioTrackInfo;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

public class AudioTools {
    public static boolean check(MessageReceivedEvent e) {
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

    public static MessageEmbed infoEmbed(AudioTrack track, String title) {
        final EmbedBuilder b = new EmbedBuilder();
        b.setTitle(title);
        AudioTrackInfo info = track.getInfo();
        b.addField(info.title, "by: " + info.author, false);
        b.setColor(Color.YELLOW);
        b.setFooter(info.uri);
        return b.build();
    }
}
