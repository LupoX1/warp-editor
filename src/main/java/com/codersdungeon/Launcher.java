package com.codersdungeon;

import com.codersdungeon.warp.engine.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Launcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(Launcher.class);

    public static void main(String... args){
        LOGGER.info("LOG_LEVEL {}", System.getProperty("LOG_LEVEL"));

        // https://youtu.be/025QFeZfeyM?t=4314
        LOGGER.info("Start");

        Application application = new DummyApplication();
        application.run();

        LOGGER.info("End");
    }
}