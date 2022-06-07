package cz.bakterio.discord.Tux.commands.audio;

import cz.bakterio.discord.Tux.audio.PlayerManager;
import cz.bakterio.discord.Tux.commands.Command;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
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
        return "Plays music. **play *<youtube url>*** :play_pause: :musical_note:";
    }

    @Override
    public List<Role> roles() {
        return null;
    }

    @Override
    public void invoke(MessageReceivedEvent e, String[] args) {
        final TextChannel channel = e.getChannel();
        final Member selfMember = e.getGuild().getSelfMember();
        final GuildVoiceState selfVoiceState = selfMember.getVoiceState();

        if (AudioTools.check(e)) return;

        if (args.length == 2) {
            PlayerManager.getINSTANCE().getMusicManager(e.getGuild()).audioPlayer.setPaused(false);

            if (PlayerManager.getINSTANCE().getMusicManager(e.getGuild()).scheduler.isEmpty()) {
                e.getChannel().sendMessage("There is nothing in the queue, please add something.").queue();
                return;
            }

            e.getChannel().sendMessage("OK, starts playing...").queue();
            return;
        }

        final Member member = e.getMember();
        final GuildVoiceState memberVoiceState = member.getVoiceState();


        if (!memberVoiceState.inVoiceChannel()) {
            channel.sendMessage("You need to be in voice channel.").queue();
            return;
        }

        final ArrayList<String> listArgs = new ArrayList<>();
        listArgs.addAll(List.of(args));
        listArgs.remove(0);
        listArgs.remove(0);

/*        String url = args[2];

        if (!isUrl(url)) {
            url = "ytsearch:" + String.join(" ", listArgs);
            System.out.println("yt");
            System.out.println("listArgs.size() = " + listArgs.size());
        }*/

        final String url = (isUrl(args[2])) ? args[2] : "ytsearch:" + String.join(" ", listArgs);

        System.out.println("url = " + url);
        PlayerManager.getINSTANCE().loadAndPlay(channel, url);
    }

    private boolean isUrl(String url) {
        try {
            new URL(url);
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }
}
