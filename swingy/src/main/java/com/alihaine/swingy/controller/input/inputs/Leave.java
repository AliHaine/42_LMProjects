package com.alihaine.swingy.controller.input.inputs;

import com.alihaine.swingy.controller.GameLoop;
import com.alihaine.swingy.controller.input.Input;

public class Leave implements Input {
    @Override
    public void executor() {
        if (GameLoop.gameLoop.stats != 3)
            return;

        GameLoop.gameLoop.LeaveArtifact();
    }
}
