package cz.bakterio.discord.Tux.commands.audio;

import cz.bakterio.discord.Tux.audio.GuildMusicManager;
import cz.bakterio.discord.Tux.audio.PlayerManager;
import cz.bakterio.discord.Tux.commands.Command;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.managers.AudioManager;

import java.util.List;

public class LeaveCommand extends Command {
    @Override
    public String getName() {
        return "leave";
    }

    @Override
    public String[] getAliases() {
        return new String[0];
    }

    @Override
    public String getHelp() {
        return "Get outta here!!! :eject:";
    }

    @Override
    public List<Role> roles() {
        return null;
    }

    @Override
    public void invoke(MessageReceivedEvent e, String[] args) {
        if (AudioTools.check(e)) return;

        final GuildVoiceState voiceState = e.getGuild().getSelfMember().getVoiceState();

        if (!voiceState.inAudioChannel()) {
            e.getChannel().sendMessage("I can't leave, I am not in any voice channel!!!").queue();
            return;
        }

        final AudioManager audioManager = e.getGuild().getAudioManager();
        audioManager.closeAudioConnection();
        GuildMusicManager musicManager = PlayerManager.getINSTANCE().getMusicManager(e.getGuild());
        musicManager.audioPlayer.destroy();
        musicManager.scheduler.clearup();
        musicManager.audioPlayer.setVolume(100);
        e.getChannel().sendMessage("See you around... :wink:").queue();
    }
}
