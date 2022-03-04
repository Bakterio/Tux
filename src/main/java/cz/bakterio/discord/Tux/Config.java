package cz.bakterio.discord.Tux;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class Config {

    public static String getSecretValue(String key) throws KeyNotFoundException {
        try {
            Object obj = new JSONParser().parse(new FileReader("secret.json"));
            JSONObject jo = (JSONObject) obj;
            String out = (String) jo.get(key);
            if (out == null) throw new KeyNotFoundException(key);
            return out;
        } catch (IOException | ParseException e) {
            throw new KeyNotFoundException(key);
        }
    }

    public static String getValue(String key) throws KeyNotFoundException {
        try {
            Object obj = new JSONParser().parse(new FileReader("config.json"));
            JSONObject jo = (JSONObject) obj;
            String out = (String) jo.get(key);
            if (out == null) throw new KeyNotFoundException(key);
            return out;
        } catch (IOException | ParseException e) {
            throw new KeyNotFoundException(key);
        }
    }

    public static class KeyNotFoundException extends Exception {
        public KeyNotFoundException(String key) {
            super("Key \"" + key + "\" is not in json file.");
        }
    }
}
