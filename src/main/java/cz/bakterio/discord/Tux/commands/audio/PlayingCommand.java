package cz.bakterio.discord.Tux.commands.audio;

import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import cz.bakterio.discord.Tux.audio.PlayerManager;
import cz.bakterio.discord.Tux.commands.Command;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class PlayingCommand extends Command {
    @Override
    public String getName() {
        return "playing";
    }

    @Override
    public String[] getAliases() {
        return new String[] {"nowplaying", "now"};
    }

    @Override
    public String getHelp() {
        return "Which song is now playing?";
    }

    @Override
    public List<Role> roles() {
        return null;
    }

    @Override
    public void invoke(GuildMessageReceivedEvent e, String[] args) {
        AudioTools.check(e);
        AudioTrack track = PlayerManager.getINSTANCE().getMusicManager(e.getGuild()).audioPlayer.getPlayingTrack();

        if (track == null) {
            e.getChannel().sendMessage("No track is now playing.").queue();
            return;
        }

        e.getChannel().sendMessageEmbeds(AudioTools.infoEmbed(track, "Now playing:")).queue();
    }
}
