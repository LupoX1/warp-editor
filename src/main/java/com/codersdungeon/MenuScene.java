package com.codersdungeon;

import com.codersdungeon.warp.engine.scenes.Scene2D;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MenuScene implements Scene2D {
    private static final Logger LOG = LoggerFactory.getLogger(MenuScene.class);

    @Override
    public void init() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void enter() {
        LOG.info("Enter Menu");
    }

    @Override
    public void update(float v) {

    }

    @Override
    public void render(float v) {

    }


    @Override
    public void exit() {
        LOG.info("Exit Menu");
    }
}
