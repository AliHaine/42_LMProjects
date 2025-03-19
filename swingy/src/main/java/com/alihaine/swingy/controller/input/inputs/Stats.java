package com.alihaine.swingy.controller.input.inputs;

import com.alihaine.swingy.controller.GameLoop;
import com.alihaine.swingy.controller.input.Input;

public class Stats implements Input {
    @Override
    public void executor() {
        GameLoop.gameLoop.getViewMode().DisplayPlayerInfos(GameLoop.gameLoop.getCurrentHero());
    }
}
