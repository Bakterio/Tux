package cz.bakterio.discord.Tux;

import cz.bakterio.discord.Tux.commands.CommandsListener;
import cz.bakterio.discord.Tux.commands.slashcommands.SlashCommandsManager;
import cz.bakterio.discord.Tux.listeners.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;

public class Tux {
    public static JDA jda;
    public static Date startupDate = new Date();
    public static boolean test;

    public static Guild testingServer;
    public static User Bakterio;

    public static void main(String[] args) {
        test = (args.length >= 1) ? args[0].equalsIgnoreCase("test") : false;
        try {
            jda = JDABuilder.createDefault(
                    Config.getSecretValue("token"))
                    .enableCache(CacheFlag.VOICE_STATE)
                    .build()
                    .awaitReady(); // wait until the bot is ready, no more api errors :D
        } catch (LoginException e) {
            System.out.println("Login error, feels frustrating man");
            e.printStackTrace();
        } catch (Config.KeyNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }

        testingServer = Objects.requireNonNull(Tux.jda.getGuildById("831571722675027999"));
        // Bakterio = Objects.requireNonNull(Tux.jda.getUserById("484281862068371467")); TODO null pointer exc

        jda.getPresence().setPresence(Activity.watching( "Linus's Linux challenge"), false);

        jda.addEventListener(new CommandsListener());
        jda.addEventListener(new JoinListener());
        jda.addEventListener(new MemberJoinListener());
        jda.addEventListener(new ReadyListener());
        jda.addEventListener(new BestOsListener());
        jda.addEventListener(new OcelotiJoinListener());
        jda.addEventListener(new SlashCommandsManager());
        jda.addEventListener(new FeedbackModalListener());

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
