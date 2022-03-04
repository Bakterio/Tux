package cz.bakterio.discord.Tux;

import cz.bakterio.discord.Tux.commands.CommandsListener;
import cz.bakterio.discord.Tux.listeners.JoinListener;
import cz.bakterio.discord.Tux.listeners.MemberJoinListener;
import cz.bakterio.discord.Tux.listeners.ReadyListener;
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
            jda = JDABuilder.createDefault(SecretConfig.getValue("token")).build();
        } catch (LoginException e) {
            System.out.println("Login error, feels frustrating man");
            e.printStackTrace();
        } catch (SecretConfig.KeyNotFoundException e) {
            e.printStackTrace();
        }

        jda.getPresence().setPresence(Activity.watching( "Linus's Linux challenge"), false);

        jda.addEventListener(new CommandsListener());
        jda.addEventListener(new JoinListener());
        jda.addEventListener(new MemberJoinListener());
        jda.addEventListener(new ReadyListener());

        ActivitySwitcher.startSwitcher();
    }

    private static String getToken() { //outdated
        String returning = null;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("token"));
            returning = reader.readLine();

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (returning != null) return returning;

        System.out.println("Token error...");
        System.exit(1);
        return null;
    }
}
