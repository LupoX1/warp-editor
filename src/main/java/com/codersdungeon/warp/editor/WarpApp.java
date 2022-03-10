package com.codersdungeon.warp.editor;

import com.codersdungeon.DummyGame;
import com.codersdungeon.warp.engine.Application;
import com.codersdungeon.warp.engine.GameLogic;
import com.codersdungeon.warp.engine.scenes.SceneManager2D;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WarpApp extends Application {
    private static final Logger LOG = LoggerFactory.getLogger(WarpApp.class);

    public WarpApp(){
        LOG.debug("New WarpApp");
        SceneManager2D.addScene(new LevelEditorScene());
    }

    @Override
    protected GameLogic createGameLogic() {
        return new DummyGame();
    }
}
