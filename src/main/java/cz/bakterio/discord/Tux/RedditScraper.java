package cz.bakterio.discord.Tux;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class RedditScraper {
    /*
    Hodina práce, takže si to uvědomte až to budete copypastovat :D
     */
    public static String scrapeImage(final String url) {
        /*
        Returns random image from given reddit url.
         */
        try {
            final Document document = Jsoup.connect(url).get();
            final ArrayList<String> images = new ArrayList<>();

            for (Element post : document.select("img")) {
                if (post.attr("alt").equalsIgnoreCase("Post image")) {
                    final String image = post.attr("src");
                    images.add(image);
                }
            }

            Random r = new Random();
            return images.get(r.nextInt(images.size()-1));
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Connection error.");
            return null;
        }
    }

    public static String scrapeImageMemeApi(final String subredditName) {
        try {
            final String url = "https://meme-api.herokuapp.com/gimme/" + subredditName;
            final URL request = new URL(url);
            final JSONTokener tokener = new JSONTokener(request.openStream());
            final JSONObject json = new JSONObject(tokener);
            return json.getString("url");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Coming soon!!!";
    }
}
