package cz.bakterio.discord.Tux.commands.audio;

import cz.bakterio.discord.Tux.audio.PlayerManager;
import cz.bakterio.discord.Tux.commands.Command;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

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
        return "Pauses the music.";
    }

    @Override
    public List<Role> roles() {
        return null;
    }

    @Override
    public void invoke(GuildMessageReceivedEvent e, String[] args) {
        if (AudioChecker.check(e)) return;

        final TextChannel channel = e.getChannel();
        final Member selfMember = e.getGuild().getSelfMember();
        final GuildVoiceState selfVoiceState = selfMember.getVoiceState();

        if (!selfVoiceState.inVoiceChannel()) {
            channel.sendMessage("I need to be in voice channel, use join command.").queue();
            return;
        }

        PlayerManager.getINSTANCE().getMusicManager(e.getGuild()).audioPlayer.setPaused(true);
        e.getChannel().sendMessage("Music paused...").queue();
    }
}
