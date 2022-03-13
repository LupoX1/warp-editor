package com.codersdungeon;

import com.codersdungeon.warp.engine.GameItem;
import com.codersdungeon.warp.engine.GameLogic;
import com.codersdungeon.warp.engine.Window;
import com.codersdungeon.warp.engine.exceptions.InitializationException;
import com.codersdungeon.warp.engine.graphics.Graphics;
import com.codersdungeon.warp.engine.graphics.Mesh;
import com.codersdungeon.warp.engine.graphics.Renderer;
import com.codersdungeon.warp.engine.graphics.VertexTemplate;
import com.codersdungeon.warp.engine.util.KeyboardListener;
import org.joml.Vector3f;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

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

        float[] vertices = new float[]{
                // VO
                -0.5f, 0.5f, 0.5f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f,
                // V1
                -0.5f, -0.5f, 0.5f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.5f,
                // V2
                0.5f, -0.5f, 0.5f, 1.0f, 1.0f, 1.0f, 0.0f, 0.5f, 0.5f,
                // V3
                0.5f, 0.5f, 0.5f, 1.0f, 1.0f, 1.0f, 0.0f, 0.5f, 0.0f,
                // V4
                -0.5f, 0.5f, -0.5f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f,
                // V5
                0.5f, 0.5f, -0.5f, 1.0f, 1.0f, 1.0f, 0.0f, 0.5f, 0.0f,
                // V6
                -0.5f, -0.5f, -0.5f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.5f,
                // V7
                0.5f, -0.5f, -0.5f, 1.0f, 1.0f, 1.0f, 0.0f, 0.5f, 0.5f,

                // For text coords in top face
                // V8: V4 repeated
                -0.5f, 0.5f, -0.5f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.5f,
                // V9: V5 repeated
                0.5f, 0.5f, -0.5f, 1.0f, 1.0f, 1.0f, 0.0f, 0.5f, 0.5f,
                // V10: V0 repeated
                -0.5f, 0.5f, 0.5f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f,
                // V11: V3 repeated
                0.5f, 0.5f, 0.5f, 1.0f, 1.0f, 1.0f, 0.0f, 0.5f, 1.0f,

                // For text coords in right face
                // V12: V3 repeated
                0.5f, 0.5f, 0.5f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f,
                // V13: V2 repeated
                0.5f, -0.5f, 0.5f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.5f,

                // For text coords in left face
                // V14: V0 repeated
                -0.5f, 0.5f, 0.5f, 1.0f, 1.0f, 1.0f, 0.0f, 0.5f, 0.0f,
                // V15: V1 repeated
                -0.5f, -0.5f, 0.5f, 1.0f, 1.0f, 1.0f, 0.0f, 0.5f, 0.5f,

                // For text coords in bottom face
                // V16: V6 repeated
                -0.5f, -0.5f, -0.5f, 1.0f, 1.0f, 1.0f, 0.0f, 0.5f, 0.0f,
                // V17: V7 repeated
                0.5f, -0.5f, -0.5f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 0.0f,
                // V18: V1 repeated
                -0.5f, -0.5f, 0.5f, 1.0f, 1.0f, 1.0f, 0.0f, 0.5f, 0.5f,
                // V19: V2 repeated
                0.5f, -0.5f, 0.5f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 0.5f,
        };

        int[] indices = new int[]{
                // Front face
                0, 1, 3, 3, 1, 2,
                // Top Face
                8, 10, 11, 9, 8, 11,
                // Right face
                12, 13, 7, 5, 12, 7,
                // Left face
                14, 15, 6, 4, 14, 6,
                // Bottom face
                16, 18, 19, 17, 16, 19,
                // Back face
                4, 6, 7, 5, 4, 7,
        };

        List<VertexTemplate> templateList = new ArrayList<>();
        templateList.add(new VertexTemplate(0, 3, "positions"));
        templateList.add(new VertexTemplate(1, 4, "colors"));
        templateList.add(new VertexTemplate(2, 2, "texture"));

        Mesh mesh = Graphics.createMesh(vertices, indices, templateList, "assets/textures/grassblock.png");

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