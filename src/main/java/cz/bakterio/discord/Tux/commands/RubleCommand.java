package cz.bakterio.discord.Tux.commands;

import cz.bakterio.discord.Tux.Config;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.json.JSONObject;
import org.json.JSONTokener;


import java.net.URL;
import java.util.List;

public class RubleCommand extends Command {
    @Override
    public String getName() {
        return "ruble";
    }

    @Override
    public String[] getAliases() {
        return new String[0];
    }

    @Override
    public String getHelp() {
        return "Shows current ruble value. :chart_with_downwards_trend:";
    }

    @Override
    public List<Role> roles() {
        return null;
    }

    @Override
    public void invoke(MessageReceivedEvent e, String[] args) {
        try { // yeah, I love the final keyword :D
            final String apikey = Config.getSecretValue("freecurrencyapi-token");
            final String url = "https://freecurrencyapi.net/api/v2/latest?apikey=" + apikey + "&base_currency=RUB";
            final URL urlForGetRequest = new URL(url);
            final JSONTokener tokener = new JSONTokener(urlForGetRequest.openStream());
            final JSONObject json = new JSONObject(tokener);
            //System.out.println(json);
            final String value = String.valueOf(json.getJSONObject("data").getDouble("USD"));
            //System.out.println(value);
            e.getChannel().sendMessage("Current value of Russian Ruble is " + value + " USD :sweat_smile:.").queue();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
