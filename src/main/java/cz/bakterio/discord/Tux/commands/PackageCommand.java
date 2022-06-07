package cz.bakterio.discord.Tux.commands;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.json.JSONTokener;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class PackageCommand extends Command {
    @Override
    public String getName() {
        return "package";
    }

    @Override
    public String[] getAliases() {
        return new String[0];
    }

    @Override
    public String getHelp() {
        return "Shows info about arch-linux package. :package:";
    }

    @Override
    public List<Role> roles() {
        return null;
    }

    @Override
    public void invoke(MessageReceivedEvent e, String[] args) {
        try {
            final String baseUrl = "https://aur.archlinux.org/rpc?v=5&type=info&arg[]=biojava";
            final URL url = new URL(baseUrl + args[2]);
            final JSONTokener tokener = new JSONTokener(url.openStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
