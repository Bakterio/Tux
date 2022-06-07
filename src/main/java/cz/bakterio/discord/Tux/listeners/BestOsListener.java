package cz.bakterio.discord.Tux.listeners;

import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.jetbrains.annotations.NotNull;

public class BestOsListener extends ListenerAdapter {
    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent e) {
        switch (e.getButton().getId()) {
            case "windows":
                e.getInteraction().getChannel().sendMessage("I don't like Bill Gates!!!").queue();
                break;
            case "macos":
                e.getInteraction().getChannel().sendMessage("I don't have money to this").queue();
                break;
            case "linux":
                e.getInteraction().getChannel().sendMessage("Perfect!!!").queue();
                break;
        }
        e.deferEdit().queue();
    }
}
