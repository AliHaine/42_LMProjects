package com.alihaine.swingy.controller.input.inputs;

import com.alihaine.swingy.controller.input.Input;

public class Exit implements Input {
    @Override
    public void executor() {
        System.exit(0);
    }
}
