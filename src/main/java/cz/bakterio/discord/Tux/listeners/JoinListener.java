package cz.bakterio.discord.Tux.listeners;

import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class JoinListener extends ListenerAdapter {
    @Override
    public void onGuildJoin(@NotNull GuildJoinEvent event) {
        event.getGuild().getCommunityUpdatesChannel().sendMessage("""
                Hi there!!!
                I'm penguin Tux, mascot of Linux. I can reply for many commands, try me :cowboy:.
                
                My prefix is **sudo**, for help type **sudo help** :smile:.
                
                Find bug or missing feature? Feel free to join our GitHub: https://github.com/Bakterio/Tux
                """).queue();
    }
}
