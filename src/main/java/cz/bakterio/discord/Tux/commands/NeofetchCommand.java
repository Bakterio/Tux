package cz.bakterio.discord.Tux.commands;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class NeofetchCommand extends Command {
    @Override
    public String getName() {
        return "neofetch";
    }

    @Override
    public String[] getAliases() {
        return new String[0];
    }

    @Override
    public String getHelp() {   
        return "Displays server info.";
    }

    @Override
    public List<Role> roles() {
        return null;
    }

    @Override
    public void invoke(GuildMessageReceivedEvent e, String[] args) {
        e.getChannel().sendMessage("""
                ``` 
                         .888888:.              tux@linux
                         88888.888.             ---------
                        .8888888888             **OS:** Arch Linux
                        8' `88' `888            **Kernel:** the newest
                        8 8 88 8 888            **Uptime:** forever
                        8:.,::,.:888            **Packages:** 1
                       .8`::::::'888            **Shell:** bash
                       88  `::'  888            **Resolution:** none, just printer
                      .88        `888.          **Terminal:** Alacritty
                    .88'   .::.  .:8888.
                    888.'   :'    `'88:88.
                  .8888'    '        88:88.
                 .8888'     .        88:888
                 `88888     :        8:888'
                  `.:.88    .       .::888'
                 .:::::88   `      .:::::::.
                .::::::.8         .:::::::::
                :::::::::..     .:::::::::'
                 `:::::::::88888:::::::'
                    rs`:::'       `:'
                ```
                """).queue();
    }
}
