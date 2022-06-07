package cz.bakterio.discord.Tux.commands.audio;

import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import cz.bakterio.discord.Tux.audio.GuildMusicManager;
import cz.bakterio.discord.Tux.audio.PlayerManager;
import cz.bakterio.discord.Tux.commands.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.List;

public class QueueCommand extends Command {
    @Override
    public String getName() {
        return "queue";
    }

    @Override
    public String[] getAliases() {
        return new String[] {"list", "songy"};
    }

    @Override
    public String getHelp() {
        return "Song in the queue.";
    }

    @Override
    public List<Role> roles() {
        return null;
    }

    @Override
    public void invoke(MessageReceivedEvent e, String[] args) {
        final GuildMusicManager musicManager = PlayerManager.getINSTANCE().getMusicManager(e.getGuild());
        final EmbedBuilder builder = new EmbedBuilder();
        builder.setTitle("Queue");
        builder.setColor(Color.YELLOW);
        builder.setFooter(musicManager.scheduler.getQueue().size() + " songs in queue");
        int count = 1; // this is the worst way to do this, but I don't give a shit ;)
        for (AudioTrack audioTrack : musicManager.scheduler.getQueue()) {
            builder.addField(count + " - " + audioTrack.getInfo().title, audioTrack.getInfo().author, false);
            count++;
        }

        e.getChannel().sendMessageEmbeds(builder.build()).queue();
    }
}
