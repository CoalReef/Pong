package com.saltgames.dev.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.saltgames.dev.Managers.GameStateManager;

public class GameOverState extends State {
    GameStateManager gsm;
    SpriteBatch batch;
    BitmapFont font;
    boolean backToMenu = false;

    public GameOverState(GameStateManager gsm) {
        super(gsm);
        batch = gsm.getMain().getBatch();
        gsm.getMain().getFont();
        this.gsm = gsm;
    }

    public void update() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            backToMenu = true;
        }
    }

    public void render() {
        if (backToMenu) {
            gsm.setState(new MenuState(gsm));
            return;
        }

        batch.begin();
        font.draw(batch, "Game Over", Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        batch.end();
    }

    public void dispose() {
        font.dispose();
    }
}
