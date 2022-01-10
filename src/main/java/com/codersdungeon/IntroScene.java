package com.codersdungeon;

import com.codersdungeon.warp.engine.KeyboardListener;
import com.codersdungeon.warp.engine.scenes.Scene2D;
import com.codersdungeon.warp.engine.scenes.SceneManager2D;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IntroScene implements Scene2D {
    private static final Logger LOG = LoggerFactory.getLogger(IntroScene.class);

    @Override
    public void enter() {
        LOG.info("Enter Intro");
    }

    @Override
    public void update(float v) {
        if(KeyboardListener.isKeyPressed(GLFW.GLFW_KEY_SPACE)){
            SceneManager2D.addScene(new MenuScene());
            SceneManager2D.currentScene().enter();
        }
    }

    @Override
    public void render(float v) {

    }


    @Override
    public void exit() {
        LOG.info("Exit Intro");
    }
}
