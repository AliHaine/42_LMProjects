package com.alihaine.swingy.controller.input.inputs;

import com.alihaine.swingy.controller.GameLoop;
import com.alihaine.swingy.controller.input.Input;

public class Fight implements Input {
    @Override
    public void executor() {
        if (GameLoop.gameLoop.stats != 1)
            return;

        GameLoop.gameLoop.LaunchFight();
    }
}
