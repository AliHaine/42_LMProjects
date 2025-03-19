package com.alihaine.swingy.controller.input.inputs;

import com.alihaine.swingy.controller.GameLoop;
import com.alihaine.swingy.controller.input.Input;

public class Up implements Input {
    @Override
    public void executor() {
        if (GameLoop.gameLoop.stats != 0)
            return;

        final int[] actualPos = GameLoop.gameLoop.getCurrentHero().getCurrentPos();

        GameLoop.gameLoop.getCurrentHero().setLastPos(actualPos[0]*64, actualPos[1]*64);
        GameLoop.gameLoop.getViewMode().DisplayToPosition(actualPos[0], actualPos[1], null);
        GameLoop.gameLoop.getViewMode().DisplayToPosition(actualPos[0], actualPos[1] - 1, GameLoop.gameLoop.getCurrentHero());
        GameLoop.gameLoop.PlayerMoveTrigger();
    }
}
