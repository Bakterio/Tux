package cz.bakterio.discord.Tux.commands.supercommands;

import net.dv8tion.jda.api.entities.Member;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class SuperChecker {
    private static final File file = new File("superusers.json");

    public static boolean checkMember(Member m) {
        try {
            JSONTokener tokener = new JSONTokener(new FileReader(file));
            JSONObject obj = new JSONObject(tokener);
            final JSONArray array = obj.getJSONArray("ids");
            for (int i = 0; i < array.length(); i++) {
                if (m.getId().equals(array.get(i))) return true;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
