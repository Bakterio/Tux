package cz.bakterio.discord.Tux.commands;

import cz.bakterio.discord.Tux.Censorship;
import cz.bakterio.discord.Tux.Config;
import cz.bakterio.discord.Tux.Tux;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;

public class CommandsListener extends ListenerAdapter {
    public static ArrayList<Command> getCommands() {
        return commands;
    }

    private static final ArrayList<Command> commands = new ArrayList<>();
    private final String PREFIX = (Tux.test) ? "tux" : "sudo";

    public CommandsListener() {
        System.out.println("CommandListener");
        commands.add(new HelpCommand());
        commands.add(new SourceCommand());
        commands.add(new LinuxCommand());
        commands.add(new DownloadCommand());
        commands.add(new OnlineCommand());
        commands.add(new WindowsCommand());
        commands.add(new YoutubeCommand());
        commands.add(new AvatarCommand());
        commands.add(new NeofetchCommand());
        commands.add(new LinuxPornCommand());
        commands.add(new PornCommand());
        commands.add(new RubleCommand());
    }

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        new Censorship(event);
        final String[] args = event.getMessage().getContentRaw().split(" ");

        if (!args[0].toLowerCase().startsWith(PREFIX)) return;
        System.out.println("Searching for command....");
        event.getChannel().sendTyping().queue();
        event.getMessage().addReaction("U+1F44D\t").queue();

        if (args.length == 1) { // help command
            commands.get(0).invoke(event, args);
            return;
        }

        for (Command i : commands) {
            if (i.getName().equalsIgnoreCase(args[1])) { // TODO aliases
                System.out.println("Invoking command " + i.getName());
                i.invoke(event, args);
                return;
            }
        }

        event.getChannel().sendMessage("/bin/bash: %s: command not found :wink: (try **sudo help**)".formatted(args[1])).queue();
    }
}
