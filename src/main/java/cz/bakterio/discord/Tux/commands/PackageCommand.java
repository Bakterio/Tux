package cz.bakterio.discord.Tux.commands;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
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
        return "Shows info about arch-linux package.";
    }

    @Override
    public List<Role> roles() {
        return null;
    }

    @Override
    public void invoke(GuildMessageReceivedEvent e, String[] args) {
        final String packageName = args[2];
        Document document = null;
        try {
            document = Jsoup.connect("https://archlinux.org/packages/community/x86_64" + packageName).get();
        } catch (IOException ex) {
            try {
                document = Jsoup.connect("https://archlinux.org/packages/community/any" + packageName).get();
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        }
        if (document == null) return;

        System.out.println(document.outerHtml());
        for (Element i : document.select("table")) {
            if (i.attr("id").equalsIgnoreCase("pkginfo")) {
                Element table = i.child(0);
                //table.getElements
            }
        }
    }
}
