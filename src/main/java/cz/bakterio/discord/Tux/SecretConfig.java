package cz.bakterio.discord.Tux;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class SecretConfig {

    public static String getValue(String key) {
        try {
            Object obj = new JSONParser().parse(new FileReader("secret.json"));
            JSONObject jo = (JSONObject) obj;
            return (String) jo.get(key);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return "none";
    }
}
