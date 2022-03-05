package cz.bakterio.discord.Tux.commands;

import cz.bakterio.discord.Tux.commands.Command;
import net.dv8tion.jda.api.entities.Emoji;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.interactions.components.Button;

import java.util.List;

public class InviteCommand extends Command {
    @Override
    public String getName() {
        return "invite";
    }

    @Override
    public String[] getAliases() {
        return new String[0];
    }

    @Override
    public String getHelp() {
        return "Invite me to your server!!! :partying_face:";
    }

    @Override
    public List<Role> roles() {
        return null;
    }

    @Override
    public void invoke(GuildMessageReceivedEvent e, String[] args) {
        Button inviteBut = Button.primary("invite", "Invite!!!").withEmoji(Emoji.fromMarkdown("U+1F973"))
                .withUrl("https://discord.com/api/oauth2/authorize?client_id=925377410457821217&permissions=8&scope=bot");
        e.getChannel().sendMessage("The invite link is under this magic button:").setActionRow(inviteBut).queue();
    }
}
