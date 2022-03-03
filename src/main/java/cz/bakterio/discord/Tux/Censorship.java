package cz.bakterio.discord.Tux;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class Censorship {
    /*
    FOSS is about freedom, but we like censorship.
    TODO add logging :D
     */
    private final String[] args;
    public Censorship(GuildMessageReceivedEvent e) {
        args = e.getMessage().getContentRaw().split(" ");
        microshit(e);
        windows(e);
    }

    private void microshit(GuildMessageReceivedEvent e) {
        for (String i : args) {
            if (i.equalsIgnoreCase("microsoft")) {
                e.getMessage().reply("Did you mean: Microshit :poop:? :smile:").queue();
                System.out.println(e.getMember().getEffectiveName() +  " is Bill Gates pet.");
                return;
            }
        }
    }

    private void windows(GuildMessageReceivedEvent e) {
        for (String i : args) {
            if (i.equalsIgnoreCase("windows")) {
                e.getMember().modifyNickname("Windows funboy").queue(); // TODO temp nickname change
            }
        }
    }
}
