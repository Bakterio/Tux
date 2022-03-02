package cz.bakterio.discord.Tux;

import cz.bakterio.discord.Tux.commands.CommandsListener;
import cz.bakterio.discord.Tux.listeners.JoinListener;
import cz.bakterio.discord.Tux.listeners.MemberJoinListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class Tux {
    public static JDA jda;
    public static Date startupDate = new Date();

    public static void main(String[] args) {
        try {
            jda = JDABuilder.createDefault(getToken()).build();
        } catch (LoginException e) {
            System.out.println("Login error, feels frustrating man");
            e.printStackTrace();
        }

        jda.getPresence().setPresence(Activity.watching( "Linus's Linux challenge"), false);
        ActivitySwitcher.startSwitcher();

        jda.addEventListener(new CommandsListener());
        jda.addEventListener(new JoinListener());
        jda.addEventListener(new MemberJoinListener());
    }

    private static String getToken() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("token"));
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Token error...");
        System.exit(1);
        return null;
    }
}
