package cz.bakterio.discord.Tux.commands.audio;

import cz.bakterio.discord.Tux.audio.PlayerManager;
import cz.bakterio.discord.Tux.commands.Command;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
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
        return "Get outta here!!!";
    }

    @Override
    public List<Role> roles() {
        return null;
    }

    @Override
    public void invoke(GuildMessageReceivedEvent e, String[] args) {
        final GuildVoiceState voiceState = e.getGuild().getSelfMember().getVoiceState();

        if (!voiceState.inVoiceChannel()) {
            e.getChannel().sendMessage("I can't leave, I am not in any voice channel!!!").queue();
            return;
        }

        final AudioManager audioManager = e.getGuild().getAudioManager();
        audioManager.closeAudioConnection(); // TODO why tf is this not working?
        PlayerManager.getINSTANCE().getMusicManager(e.getGuild()).audioPlayer.destroy();
        PlayerManager.getINSTANCE().getMusicManager(e.getGuild()).scheduler.clearup();
        e.getChannel().sendMessage("See you around... :wink:").queue();
    }
}
