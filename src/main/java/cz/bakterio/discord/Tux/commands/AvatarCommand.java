package cz.bakterio.discord.Tux.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

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
        builder.setImage(e.getAuthor().getAvatarUrl());
        builder.setTitle(e.getMember().getEffectiveName() + "'s avatar");
        builder.setColor(Color.YELLOW);
        builder.setDescription("Here is your avatar");
        e.getChannel().sendMessageEmbeds(builder.build()).queue();
        //e.getChannel().sendMessage("Your avatar url is: " + e.getAuthor().getAvatarUrl()).queue();
    }
}
