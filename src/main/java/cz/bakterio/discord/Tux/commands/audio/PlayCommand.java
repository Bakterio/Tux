package cz.bakterio.discord.Tux.commands.audio;

import cz.bakterio.discord.Tux.audio.PlayerManager;
import cz.bakterio.discord.Tux.commands.Command;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class PlayCommand extends Command {
    @Override
    public String getName() {
        return "play";
    }

    @Override
    public String[] getAliases() {
        return new String[0];
    }

    @Override
    public String getHelp() {
        return "Plays music.";
    }

    @Override
    public List<Role> roles() {
        return null;
    }

    @Override
    public void invoke(GuildMessageReceivedEvent e, String[] args) {
        final TextChannel channel = e.getChannel();
        final Member selfMember = e.getGuild().getSelfMember();
        final GuildVoiceState selfVoiceState = selfMember.getVoiceState();

        if (!selfVoiceState.inVoiceChannel()) {
            channel.sendMessage("I need to be in voice channel, use join command.").queue();
            return;
        }

        if (args.length == 2) {
            PlayerManager.getINSTANCE().getMusicManager(e.getGuild()).audioPlayer.setPaused(false);

            e.getChannel().sendMessage("OK, starts playing...").queue();
            return;
        }

        final Member member = e.getMember();
        final GuildVoiceState memberVoiceState = member.getVoiceState();


        if (!memberVoiceState.inVoiceChannel()) {
            channel.sendMessage("You need to be in voice channel.").queue();
            return;
        }

        final String url = args[2];
        PlayerManager.getINSTANCE().loadAndPlay(channel, url);
    }
}
