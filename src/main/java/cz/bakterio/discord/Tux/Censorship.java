package cz.bakterio.discord.Tux;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.Timer;
import java.util.TimerTask;

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
                tempChangeNickname(e.getMember(), "Microshit lover");
                return;
            }
        }
    }

    private void windows(GuildMessageReceivedEvent e) {
        for (String i : args) {
            if (i.equalsIgnoreCase("windows")) {
                tempChangeNickname(e.getMember(), "Windows fanboy");
            }
        }
    }

    private void tempChangeNickname(Member m, String nickname) {
        m.modifyNickname(nickname);
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                m.modifyNickname(m.getUser().getName());
            }
        };
        Timer t = new Timer();
        t.schedule(tt, 5*60000);
    }
}
