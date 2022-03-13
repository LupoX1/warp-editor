package com.codersdungeon;

import com.codersdungeon.warp.engine.GameItem;
import com.codersdungeon.warp.engine.GameLogic;
import com.codersdungeon.warp.engine.Window;
import com.codersdungeon.warp.engine.exceptions.InitializationException;
import com.codersdungeon.warp.engine.graphics.*;
import com.codersdungeon.warp.engine.util.KeyboardListener;
import com.codersdungeon.warp.engine.util.Resources;
import org.joml.Vector3f;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.lwjgl.glfw.GLFW.*;

public class DummyGame implements GameLogic {
    private static final Logger LOG = LoggerFactory.getLogger(DummyGame.class);

    private final Window window;
    private final Renderer renderer;

    private int displxInc = 0;
    private int displyInc = 0;
    private int displzInc = 0;
    private int scaleInc = 0;

    private GameItem[] gameItems;

    public DummyGame(Window window) {
        this.window = window;
        renderer = new Renderer(window);
    }

    @Override
    public void init() throws InitializationException {
        LOG.debug("init");
        renderer.init();

        ModelData modelData = Resources.deserializeModel("assets/models/model.dat");

        Mesh mesh = Graphics.createMesh(modelData, "assets/textures/grassblock.png");

        GameItem gameItem = new GameItem(mesh);
        gameItem.setPosition(0, 0, -2);
        gameItems = new GameItem[]{gameItem};
    }

    @Override
    public void handleInput() {
        displyInc = 0;
        displxInc = 0;
        displzInc = 0;
        scaleInc = 0;
        if (KeyboardListener.isKeyPressed(GLFW_KEY_UP)) {
            displyInc = 1;
        } else if (KeyboardListener.isKeyPressed(GLFW_KEY_DOWN)) {
            displyInc = -1;
        } else if (KeyboardListener.isKeyPressed(GLFW_KEY_LEFT)) {
            displxInc = -1;
        } else if (KeyboardListener.isKeyPressed(GLFW_KEY_RIGHT)) {
            displxInc = 1;
        } else if (KeyboardListener.isKeyPressed(GLFW_KEY_A)) {
            displzInc = -1;
        } else if (KeyboardListener.isKeyPressed(GLFW_KEY_Q)) {
            displzInc = 1;
        } else if (KeyboardListener.isKeyPressed(GLFW_KEY_Z)) {
            scaleInc = -1;
        } else if (KeyboardListener.isKeyPressed(GLFW_KEY_X)) {
            scaleInc = 1;
        }
    }

    @Override
    public void update(float interval) {
        for (GameItem gameItem : gameItems) {
            // Update position
            Vector3f itemPos = gameItem.getPosition();
            float posx = itemPos.x + displxInc * 0.01f;
            float posy = itemPos.y + displyInc * 0.01f;
            float posz = itemPos.z + displzInc * 0.01f;
            gameItem.setPosition(posx, posy, posz);

            // Update scale
            float scale = gameItem.getScale();
            scale += scaleInc * 0.05f;
            if (scale < 0) {
                scale = 0;
            }
            gameItem.setScale(scale);

            // Update rotation angle
            float rotation = gameItem.getRotation().x + 1.5f;
            if (rotation > 360) {
                rotation = 0;
            }
            gameItem.setRotation(rotation, rotation, rotation);
        }
    }

    @Override
    public void render() {
        renderer.render(gameItems);
    }

    @Override
    public void dispose() {
        LOG.debug("destroy");
        renderer.dispose();
        for (GameItem gameItem : gameItems) {
            gameItem.getMesh().dispose();
        }
    }
}