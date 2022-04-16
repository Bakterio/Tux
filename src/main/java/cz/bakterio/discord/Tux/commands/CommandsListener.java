package cz.bakterio.discord.Tux.commands;

import cz.bakterio.discord.Tux.Censorship;
import cz.bakterio.discord.Tux.Logger;
import cz.bakterio.discord.Tux.Tux;
import cz.bakterio.discord.Tux.commands.audio.*;
import cz.bakterio.discord.Tux.commands.supercommands.ServerCommand;
import cz.bakterio.discord.Tux.commands.supercommands.SuperChecker;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CommandsListener extends ListenerAdapter {
    public static ArrayList<Command> getCommands() {
        return commands;
    }

    private static final ArrayList<Command> commands = new ArrayList<>();
    private static final ArrayList<Command> superCommands = new ArrayList<>();
    public static final String PREFIX = (Tux.test) ? "tux" : "sudo";

    private static final Logger logger = new Logger("commands.log");

    public CommandsListener() {
        System.out.println("CommandListener");
        commands.add(new HelpCommand());
        commands.add(new SourceCommand());
        commands.add(new InviteCommand());
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
        commands.add(new BitcoinCommand());
        commands.add(new BestOsCommand());

        commands.add(new JoinCommand());
        commands.add(new LeaveCommand());
        commands.add(new PlayCommand());
        commands.add(new PauseCommand());
        commands.add(new SkipCommand());
        commands.add(new PlayingCommand());

        superCommands.add(new ServerCommand());
    }

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
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
            if (isCommand(i, args[1])) {
                System.out.println("Invoking command " + i.getName());
                logger.log("#" + event.getChannel().getName() + " -- " + event.getMember().getUser().getName() + " -- " + i.getName());
                i.invoke(event, args);
                return;
            }
        }

        for (Command i : superCommands) {
            if (isCommand(i, args[1])) {
                if (!SuperChecker.checkMember(event.getMember())) {
                    event.getChannel().sendMessage("You ain't a super user, fuck off!!!").queue();
                    return;
                }
                System.out.println("Invoking command " + i.getName());
                i.invoke(event, args);
                return;
            }
        }

        event.getChannel().sendMessage("/bin/bash: " + args[1] + ": command not found :wink: (try **" + CommandsListener.PREFIX + " help**)").queue();
    }

    public static boolean isCommand(Command cmd, String input) {
        if (cmd.getName().equalsIgnoreCase(input)) return true;

        for (String alias : cmd.getAliases()) {
            if (alias.equalsIgnoreCase(input)) return true;
        }

        return false;
    }
}
