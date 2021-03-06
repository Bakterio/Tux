package cz.bakterio.discord.Tux.commands.audio;

import cz.bakterio.discord.Tux.audio.PlayerManager;
import cz.bakterio.discord.Tux.commands.Command;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;

public class PauseCommand extends Command {
    @Override
    public String getName() {
        return "pause";
    }

    @Override
    public String[] getAliases() {
        return new String[] {"stop"};
    }

    @Override
    public String getHelp() {
        return "Pauses the music. :pause_button:";
    }

    @Override
    public List<Role> roles() {
        return null;
    }

    @Override
    public void invoke(MessageReceivedEvent e, String[] args) {
        if (AudioTools.check(e)) return;

        final MessageChannel channel = e.getChannel();
        final Member selfMember = e.getGuild().getSelfMember();
        final GuildVoiceState selfVoiceState = selfMember.getVoiceState();

        if (!selfVoiceState.inAudioChannel()) {
            channel.sendMessage("I need to be in voice channel, use join command.").queue();
            return;
        }

        PlayerManager.getINSTANCE().getMusicManager(e.getGuild()).audioPlayer.setPaused(true);
        e.getChannel().sendMessage("Music paused...").queue();
    }
}
