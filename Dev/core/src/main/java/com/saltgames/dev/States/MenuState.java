package com.saltgames.dev.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.saltgames.dev.Managers.GameStateManager;

public class MenuState extends State {

    SpriteBatch batch;
    BitmapFont font;
    GameStateManager gsm;
    boolean toPlayState;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        batch = gsm.getMain().getBatch();
        font = gsm.getMain().getFont();
        this.gsm = gsm;
    }

    public void update() {
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            toPlayState = true;
        }
    }

    public void render() {
        if (toPlayState) {
            gsm.setState(new PlayState(gsm));
            return;
        }
        batch.begin();
        font.draw(batch, "Start Game?", Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        batch.end();
    }

    public void dispose() {
        font.dispose();
    }
}
