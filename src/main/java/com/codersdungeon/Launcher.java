package com.codersdungeon;

import com.codersdungeon.warp.engine.Application;
import com.codersdungeon.warp.engine.scenes.Scene2D;
import com.codersdungeon.warp.engine.scenes.SceneManager2D;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Launcher {
    private static final Logger LOG = LoggerFactory.getLogger(Launcher.class);

    public static void main(String... args){
        LOG.info("Start");

        Application application = new WarpApp();
        application.run();

        LOG.info("End");
    }
}
