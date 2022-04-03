package cz.bakterio.discord.Tux.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Emoji;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.interactions.components.Button;

import java.awt.*;
import java.util.List;

public class AvatarCommand extends Command{
    @Override
    public String getName() {
        return "avatar";
    }

    @Override
    public String[] getAliases() {
        return new String[0];
    }

    @Override
    public String getHelp() {
        return "Sends you your avatar.";
    }

    @Override
    public List<Role> roles() {
        return null;
    }

    @Override
    public void invoke(GuildMessageReceivedEvent e, String[] args) {
        final EmbedBuilder builder = new EmbedBuilder();
        final boolean mentoned = (e.getMessage().getMentionedMembers().size() != 0);
        final String url = (!mentoned) ? e.getMember().getUser().getAvatarUrl() :
                e.getMessage().getMentionedMembers().get(0).getUser().getAvatarUrl();

        if (url == null) {
            e.getChannel().sendMessage("Target doesn't have an avatar... ;(").queue();
            return;
        }

        builder.setImage(url);
        builder.setTitle((mentoned) ? e.getMessage().getMentionedMembers().get(0).getEffectiveName() : e.getMember().getEffectiveName() + "'s avatar");
        builder.setColor(Color.YELLOW);
        builder.setDescription("Here is your avatar");

        Button link = Button.primary("link", "Download").withUrl(url)
                .withEmoji(Emoji.fromMarkdown("U+2B07"));
        e.getChannel().sendMessageEmbeds(builder.build()).setActionRow(link).queue();
        //e.getChannel().sendMessage("Your avatar url is: " + e.getAuthor().getAvatarUrl()).queue();
    }
}
