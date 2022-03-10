package com.codersdungeon;

import com.codersdungeon.warp.engine.Application;
import com.codersdungeon.warp.engine.GameLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DummyApplication extends Application {
    private static final Logger LOG = LoggerFactory.getLogger(DummyApplication.class);

    @Override
    protected GameLogic createGameLogic() {
        LOG.info("create game logic");
        return new DummyGame();
    }
}