package cz.bakterio.discord.Tux.commands.audio;

import cz.bakterio.discord.Tux.commands.Command;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.managers.AudioManager;

import java.util.List;

public class JoinCommand extends Command {
    @Override
    public String getName() {
        return "join";
    }

    @Override
    public String[] getAliases() {
        return new String[0];
    }

    @Override
    public String getHelp() {
        return "I will join your audio channel. :notes:";
    }

    @Override
    public List<Role> roles() {
        return null;
    }

    @Override
    public void invoke(MessageReceivedEvent e, String[] args) {
        final GuildVoiceState voiceState = e.getGuild().getSelfMember().getVoiceState();
        final GuildVoiceState memberVoiceState = e.getMember().getVoiceState();

        if (voiceState.inAudioChannel()) {
            e.getChannel().sendMessage("I am already in " + voiceState.getChannel().getName() + " channel.").queue();
            return;
        }

        if (!memberVoiceState.inAudioChannel()) {
            e.getChannel().sendMessage("You have to be in voice channel to invoke this command...").queue();
            return;
        }

        final AudioManager audioManager = e.getGuild().getAudioManager();
        audioManager.openAudioConnection(memberVoiceState.getChannel());
        e.getChannel().sendMessage("I am in!!!").queue();
    }
}
