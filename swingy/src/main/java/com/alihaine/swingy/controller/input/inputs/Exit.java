package com.alihaine.swingy.controller.input.inputs;

import com.alihaine.swingy.controller.GameLoop;
import com.alihaine.swingy.controller.input.Input;
import com.alihaine.swingy.model.Database;

public class Exit implements Input {
    @Override
    public void executor() {
        Database.db.UpdateData(GameLoop.gameLoop.getCurrentHero());
        System.exit(0);
    }
}
