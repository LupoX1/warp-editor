package com.codersdungeon;

import com.codersdungeon.warp.engine.graphics.ModelData;
import com.codersdungeon.warp.engine.util.Resources;

public class Converter {
    public static void main(String... args){
        ModelData modelData = Resources.loadFromResource("assets/models/model.txt");
        Resources.serializeModel("D:\\progetti\\warp\\warp-editor\\src\\main\\resources\\assets\\models\\model.dat", modelData);
    }
}
