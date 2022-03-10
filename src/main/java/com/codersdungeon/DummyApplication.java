package com.codersdungeon;

import com.codersdungeon.warp.engine.Application;
import com.codersdungeon.warp.engine.GameLogic;

public class DummyApplication extends Application {

    @Override
    protected GameLogic createGameLogic() {
        return new DummyGame();
    }
}