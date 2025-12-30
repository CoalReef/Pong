package com.saltgames.dev.Managers;

import com.saltgames.dev.Main;
import com.saltgames.dev.States.MenuState;
import com.saltgames.dev.States.State;

import java.util.Stack;

public class GameStateManager {

    private Stack<State> states;
    private Main main;

    public GameStateManager(Main main) {
        // Create stack of states using State object
        states = new Stack<State>();
        this.main = main;

        // Set the initial state (MenuState)
        states.push(new MenuState(this));
    }

    public void update() {
        states.peek().update();
    }

    public void render() {
        states.peek().render();
    }

    public void setState(State newState) {
        // Make sure the stack isn't empty before trying to pop (prevent errors in misuse)
        if (!states.empty()) {
            states.peek().dispose();
            states.pop();
        }
        states.push(newState);
    }

    public void removeState() {
        states.pop();
    }

    public Main getMain() {
        return main;
    }
}
