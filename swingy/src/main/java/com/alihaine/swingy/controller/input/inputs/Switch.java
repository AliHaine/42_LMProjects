package com.alihaine.swingy.controller.input.inputs;

import com.alihaine.swingy.controller.GameLoop;
import com.alihaine.swingy.controller.input.Input;

public class Switch implements Input {
    @Override
    public void executor() {
        GameLoop.gameLoop.SwitchView();
    }
}
