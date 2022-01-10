package com.coders.dungeon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Launcher {
    private static final Logger LOG = LoggerFactory.getLogger(Launcher.class);

    public static void main(String... args){
        LOG.info("Start");
        ApplicationRunner.run(WarpApp.class);
        LOG.info("End");
    }
}
