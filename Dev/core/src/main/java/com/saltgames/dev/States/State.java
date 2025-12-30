package com.saltgames.dev.States;

import com.saltgames.dev.Managers.GameStateManager;

public abstract class State {
    public State(GameStateManager gsm) {

    }

    public abstract void update();

    public abstract void render();

    public abstract void dispose();
}
