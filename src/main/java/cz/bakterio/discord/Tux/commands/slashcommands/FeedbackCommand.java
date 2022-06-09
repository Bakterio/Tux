package cz.bakterio.discord.Tux.commands.slashcommands;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.Modal;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;

public class FeedbackCommand extends SlashCommand {
    @Override
    public String getName() {
        return "feedback";
    }

    @Override
    public void setup(Guild g) {
        g.upsertCommand("feedback", "Send us your feedback!!!").queue();
    }

    @Override
    public void invoke(SlashCommandInteractionEvent e) {
        TextInput title = TextInput.create("title", "Title:", TextInputStyle.SHORT)
                .setMinLength(5)
                .setRequired(true)
                .setPlaceholder("My honest feedback")
                .build();

        TextInput text = TextInput.create("text", "Feedback:", TextInputStyle.PARAGRAPH)
                .setMinLength(10)
                .setRequired(true)
                .setPlaceholder("I like your bot becouse.....\n\nYou should improve....")
                .build();

        TextInput stars = TextInput.create("stars", "Stars: (max 5)", TextInputStyle.SHORT)
                .setRequired(true)
                .setMaxLength(1)
                .setPlaceholder("-")
                .build();

        Modal modal = Modal.create("feedback", "Tux's feedback")
                .addActionRows(ActionRow.of(title), ActionRow.of(stars), ActionRow.of(text))
                .build();

        e.replyModal(modal).queue();
    }
}
