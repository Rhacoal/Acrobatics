package com.github.rhacoal.acrobatics.command;

import com.github.rhacoal.acrobatics.Acrobatics;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.text.Text;

public class CommandHandler{

    private final Acrobatics plugin;
    private final CommandSpec basic;
    private final CommandSpec acrobaticsOn;

    public CommandHandler(Acrobatics plugin) {
        this.plugin = plugin;
        basic = CommandSpec.builder()
                .description(Text.of("The basic command of Acrobatics"))
                .permission("acrobatics.basic.help")
                .arguments(GenericArguments.string(Text.of("operation")), GenericArguments.remainingJoinedStrings(Text.of("args")))
                .executor(this::basicCommand)
                .build();
        acrobaticsOn = CommandSpec.builder()
                .description(Text.of("Enable Acrobatics for one player."))
                .permission("acrobatics.basic.activate.self")
                .arguments(GenericArguments.optional(GenericArguments.player(Text.of("player"))))
                .executor(this::enableAcrobatics)
                .build();
        Sponge.getCommandManager().register(plugin, basic, "acrobatics", "acr");
        Sponge.getCommandManager().register(plugin, acrobaticsOn, "acrobaticson", "acron");
    }

    private CommandResult basicCommand(CommandSource src, CommandContext args) {
        src.sendMessage(Text.of("Invoked!"));
        return CommandResult.success();
    }

    private CommandResult enableAcrobatics(CommandSource src, CommandContext args) {
        src.sendMessage(Text.of("Acrobatics enabled for you!"));
        return CommandResult.success();
    }

}
