package cz.bakterio.discord.Tux.listeners;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class OcelotiJoinListener extends ListenerAdapter {
    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent e) {
        if (!e.getGuild().getId().equals("765293985790296074")) return;
        final Member m = e.getMember();
        final String[] roles = {"765303311477374986", "798803185815781394", "766320048255139891"};
        for (String role : roles)
            m.getRoles().add(e.getGuild().getRoleById(role));
    }
}
