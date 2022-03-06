package com.codersdungeon;

import com.codersdungeon.warp.engine.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Launcher {
    private static final Logger LOG = LoggerFactory.getLogger(Launcher.class);

    public static void main(String... args){
        // https://youtu.be/025QFeZfeyM?t=4314
        LOG.info("Start");

        Application application = new WarpApp();
        application.run();

        LOG.info("End");
    }
}
