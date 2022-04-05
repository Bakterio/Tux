package cz.bakterio.discord.Tux.commands.audio;

import cz.bakterio.discord.Tux.audio.GuildMusicManager;
import cz.bakterio.discord.Tux.audio.PlayerManager;
import cz.bakterio.discord.Tux.commands.Command;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class SkipCommand extends Command {
    @Override
    public String getName() {
        return "skip";
    }

    @Override
    public String[] getAliases() {
        return new String[0];
    }

    @Override
    public String getHelp() {
        return "Skip the song in queue.";
    }

    @Override
    public List<Role> roles() {
        return null;
    }

    @Override
    public void invoke(GuildMessageReceivedEvent e, String[] args) {
        if (AudioChecker.check(e)) return;

        GuildMusicManager musicManager = PlayerManager.getINSTANCE().getMusicManager(e.getGuild());

        if (musicManager.audioPlayer.getPlayingTrack() == null) {
            e.getChannel().sendMessage("There is no track playing.").queue();
            return;
        }

        musicManager.scheduler.nextTrack();
        e.getChannel().sendMessage("Skipping...").queue();
    }
}
