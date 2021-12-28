package cz.bakterio.discord.Tux;

import cz.bakterio.discord.Tux.commands.CommandsListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;
import java.util.Date;

public class Tux {
    public static JDA jda;
    public static Date startupDate = new Date();

    public static void main(String[] args) {
        try {
            jda = JDABuilder.createDefault("OTI1Mzc3NDEwNDU3ODIxMjE3.YcsO3w._wHwCWUAZxswlllFvXLB9555NiQ").build(); // TODO token from json here
        } catch (LoginException e) {
            System.out.println("Login error, feels frustrating man");
            e.printStackTrace();
        }

        jda.getPresence().setPresence(Activity.watching( "Linus's Linux challenge"), false);

        jda.addEventListener(new CommandsListener());
    }
}
