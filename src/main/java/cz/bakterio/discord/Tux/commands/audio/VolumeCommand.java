package cz.bakterio.discord.Tux.commands.audio;

import cz.bakterio.discord.Tux.audio.PlayerManager;
import cz.bakterio.discord.Tux.commands.Command;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;

public class VolumeCommand extends Command {

    @Override
    public String getName() {
        return "volume";
    }

    @Override
    public String[] getAliases() {
        return new String[] {"hlasitost", "hlasytost", "zvuk"};
    }

    @Override
    public String getHelp() {
        return "Set bot's volume.";
    }

    @Override
    public List<Role> roles() {
        return null;
    }

    @Override
    public void invoke(MessageReceivedEvent e, String[] args) {
        if (AudioTools.check(e)) return;

        try {
            final int volume = Integer.parseInt(args[2]);
            PlayerManager.getINSTANCE().getMusicManager(e.getGuild()).audioPlayer.setVolume(volume);
            e.getChannel().sendMessage("Bot's volume changed to " + volume + "%.").queue();
        } catch (NumberFormatException ex) {
            e.getChannel().sendMessage("Enter valid number!!!").queue();
        }
    }
}
