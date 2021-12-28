package cz.bakterio.discord.Tux.listeners;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class MemberJoinListener extends ListenerAdapter {
    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
        User u = event.getUser();

        u.openPrivateChannel().queue((channel) ->
        {
            channel.sendMessage("""
                    Hey bro...
                    Have you ever heard about this super os called Linux?
                    It's awesome. Type **sudo help** on %s server or just simply google it... :wink:
                    """.formatted(event.getGuild().getName())).queue();
        });
    }
}
