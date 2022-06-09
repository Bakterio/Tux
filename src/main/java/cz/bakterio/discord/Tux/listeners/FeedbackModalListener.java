package cz.bakterio.discord.Tux.listeners;

import cz.bakterio.discord.Tux.Tux;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class FeedbackModalListener extends ListenerAdapter {
    @Override
    public void onModalInteraction(@NotNull ModalInteractionEvent e) {
        if (!e.getModalId().equals("feedback")) return;

        String title = e.getValue("title").getAsString();
        String text = e.getValue("text").getAsString();
        String stars = e.getValue("stars").getAsString();
        User sender = e.getUser();

        if (Integer.parseInt(stars) > 5) {
            e.reply("You can't count to 5? :rofl:").queue();
            return;
        }

        e.getUser().openPrivateChannel() // TODO: 09.06.22 send to Bakterio
                .flatMap(channel -> channel.sendMessage(String.format("""
                        **NEW FEEDBACK!!!**
                        ===============
                        **User:** %s
                        **Title:** %s
                        **Stars:** %s
                        **Text:** %s
                        """, sender.getName(), title, stars, text))).queue();

        e.reply("Thank you for you feedback!!! :smile:").queue();
    }
}
