package cz.bakterio.discord.Tux;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class OtherStuff {
    public static void microshit(GuildMessageReceivedEvent e) {
        final String[] args = e.getMessage().getContentRaw().split(" ");
        for (String i : args) {
            if (i.equalsIgnoreCase("microsoft")) {
                e.getMessage().reply("Did you mean: Microshit :poop:? :smile:").queue();
                System.out.println(e.getMember().getEffectiveName() +  " is Bill Gates pet.");
                return;
            }
        }
    }
}
