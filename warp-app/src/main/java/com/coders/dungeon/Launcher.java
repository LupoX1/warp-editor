package com.coders.dungeon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Launcher {
    private static final Logger LOG = LoggerFactory.getLogger(Launcher.class);

    public static void main(String... args){
        LOG.info("Start");
        Application app = Application.getInstance();
        app.run();
        LOG.info("End");
    }
}
