package cz.bakterio.discord.Tux.commands.slashcommands;

import cz.bakterio.discord.Tux.Tux;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;

public class SlashCommandsListener extends ListenerAdapter {
    public SlashCommandsListener() {
        CommandListUpdateAction commands = Tux.jda.updateCommands();

        CommandData testCommand = new CommandData("test", "Hope this test will work!!!");
        testCommand.addOption(OptionType.INTEGER, "num1", "First number", true);
        testCommand.addOption(OptionType.INTEGER, "num2", "Second number", true);

        commands.addCommands(testCommand);
    }
    @Override
    public void onSlashCommand(SlashCommandEvent e) {
    }
}
