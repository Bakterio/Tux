package cz.bakterio.discord.Tux.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class BitcoinCommand extends Command {
    @Override
    public String getName() {
        return "btc";
    }

    @Override
    public String[] getAliases() {
        return new String[] {"bitcoin"};
    }

    @Override
    public String getHelp() {
        return "Current value of bitcoin.";
    }

    @Override
    public List<Role> roles() {
        return null;
    }

    @Override
    public void invoke(GuildMessageReceivedEvent e, String[] args) {
        try {
            final String url = "https://blockchain.info/ticker";
            final URL urlForGetRequest = new URL(url);
            final JSONTokener tokener = new JSONTokener(urlForGetRequest.openStream());
            final JSONObject json = new JSONObject(tokener);

            final JSONObject usd = json.getJSONObject("USD");
            final JSONObject czk = json.getJSONObject("CZK");

            final EmbedBuilder builder = new EmbedBuilder();
            builder.setTitle("Bitcoin value");
            builder.setColor(Color.yellow);
            builder.setThumbnail("https://bitcoin.org/img/icons/opengraph.png?1644775669");
            builder.addField("USD:", String.valueOf(usd.getDouble("last")), true);
            builder.addField("CZK:", String.valueOf(czk.getDouble("last")), true);
            e.getChannel().sendMessageEmbeds(builder.build()).queue();
        } catch (IOException ex) {
            ex.printStackTrace();
            e.getChannel().sendMessage("Error :/").queue();
        }
    }
}
