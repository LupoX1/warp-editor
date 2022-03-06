package com.codersdungeon;

import com.codersdungeon.warp.engine.exceptions.ShaderException;
import com.codersdungeon.warp.engine.graphics.*;
import com.codersdungeon.warp.engine.graphics.renderer.Renderer;
import com.codersdungeon.warp.engine.graphics.renderer.TriangleRenderer;
import com.codersdungeon.warp.engine.scenes.Scene2D;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LevelEditorScene implements Scene2D {
    private static final Logger LOG = LoggerFactory.getLogger(LevelEditorScene.class);

    private static final String vertexSrc = "#version 330 core\n" +
            "layout (location = 0) in vec3 aPos;\n" +
            "layout (location = 1) in vec4 aColor;\n" +
            "\n" +
            "out vec4 fColor;\n" +
            "\n" +
            "void main()\n" +
            "{\n" +
            "    fColor = aColor;\n" +
            "\n" +
            "    gl_Position = vec4(aPos, 1.0);\n" +
            "}\n";

    private static final String fragmentSrc = "#version 330 core\n" +
            "in vec4 fColor;\n" +
            "\n" +
            "out vec4 color;\n" +
            "\n" +
            "void main()\n" +
            "{\n" +
            "    color = fColor;\n" +
            "}";

    private ShaderProgram shaderProgram;
    private Vao vao;

    private Renderer triangleRenderer = TriangleRenderer.create();

    @Override
    public void init() {
        try {
            VertexShader vertexShader = VertexShader.createShader(vertexSrc);
            FragmentShader fragmentShader = FragmentShader.createShader(fragmentSrc);
            shaderProgram = ShaderProgram.createProgram(vertexShader, fragmentShader);
        }catch (ShaderException ex){
            throw new RuntimeException(ex);
        }

        float[] vertexData = {
                -0.5f, 0.5f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f,
                 0.5f,-0.5f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f,
                 0.5f, 0.5f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f,
                -0.5f,-0.5f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f
        };
        VertexTemplate position = new VertexTemplate(0, 3, "position");
        VertexTemplate color = new VertexTemplate(1, 4, "color");
        VertexArray vertexArray = new VertexArray(vertexData, position, color);
        int[] elementArray = {
                0, 1, 2,
                1, 2, 3
        };
        vao = Vao.create(vertexArray, elementArray);
    }

    @Override
    public void enter() {
        LOG.debug("enter level editor");
    }

    @Override
    public void update(float v) {
        triangleRenderer.render(v, shaderProgram, vao);
    }

    @Override
    public void render(float v) {

    }

    @Override
    public void exit() {
        LOG.debug("exit level editor");
        shaderProgram.deleteProgram();
    }
}
