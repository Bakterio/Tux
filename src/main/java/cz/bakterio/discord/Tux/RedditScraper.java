package cz.bakterio.discord.Tux;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class RedditScraper {
    /*
    Hodina práce, takže si to uvědomte až to budete copypastovat :D
     */
    public static String scrapeImage(String url) {
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
}
