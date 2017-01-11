package com.github.rhacoal.acrobatics;

import com.github.rhacoal.acrobatics.command.CommandHandler;
import com.google.inject.Inject;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;

import java.util.logging.Logger;

import static com.github.rhacoal.acrobatics.Acrobatics.*;

@Plugin(id = PLUGIN_ID, name = PLUGIN_NAME, version = PLUGIN_VERSION, authors = {"Rhacoal"})
public class Acrobatics {

    public static final String PLUGIN_ID = "acrobatics";
    public static final String PLUGIN_NAME = "Acrobatics";
    public static final String PLUGIN_VERSION = "0.1";

    private Logger logger;
    private CommandHandler commandHandler;

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        logger.info(PLUGIN_NAME  + " " + PLUGIN_VERSION + "is loaded!");
        commandHandler = new CommandHandler(this);
    }

    public Logger getLogger() {
        return logger;
    }

    @Inject
    public void setLogger(Logger logger) {
        this.logger = logger;
    }


}
