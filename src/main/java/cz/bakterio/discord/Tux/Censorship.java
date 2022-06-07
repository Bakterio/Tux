package cz.bakterio.discord.Tux;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.Timer;
import java.util.TimerTask;

public class Censorship {
    /*
    FOSS is about freedom, but we like censorship.
    TODO add logging :D
     */
    private final String[] args;
    public Censorship(net.dv8tion.jda.api.events.message.MessageReceivedEvent e) {
        args = e.getMessage().getContentRaw().split(" ");
        microshit(e);
        windows(e);
    }

    private void microshit(MessageReceivedEvent e) {
        for (String i : args) {
            if (i.equalsIgnoreCase("microsoft")) {
                e.getMessage().reply("Did you mean: Microshit :poop:? :smile:").queue();
                System.out.println(e.getMember().getEffectiveName() +  " is Bill Gates pet.");
                tempChangeNickname(e.getMember(), "Microshit lover", 5*60);
                return;
            }
        }
    }

    private void windows(MessageReceivedEvent e) {
        for (String i : args) {
            if (i.equalsIgnoreCase("windows")) {
                tempChangeNickname(e.getMember(), "Windows fanboy", 5*60);
            }
        }
    }

    public static void tempChangeNickname(Member m, String nickname, long seconds) {
        m.modifyNickname(nickname);
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                m.modifyNickname(m.getUser().getName());
            }
        };
        Timer t = new Timer();
        t.schedule(tt, seconds*1000);
    }
}
