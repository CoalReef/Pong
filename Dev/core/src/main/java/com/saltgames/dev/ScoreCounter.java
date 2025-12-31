package com.saltgames.dev;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.saltgames.dev.Managers.GameStateManager;
import com.saltgames.dev.States.State;

public class ScoreCounter extends State {
    GameStateManager gsm;
    BitmapFont font;

    boolean playerScored;
    boolean enemyScored;

    int playerScore;
    int enemyScore;

    public ScoreCounter(GameStateManager gsm, boolean playerScored, boolean enemyScored) { // (true, false) = player point, (false, true) = enemy point
        super(gsm);
        this.playerScored = playerScored;
        this.enemyScored = enemyScored;
        this.font = gsm.getMain().getFont();
    }

    public void update() {
        if (playerScored) {
            playerScore += 1;
        } else if (enemyScored) {
            enemyScore += 1;
        }
    }

    public void render() {
        font.draw(gsm.getMain().getBatch(), "Player: " + String.valueOf(playerScore) + " Enemy: " + String.valueOf(enemyScore), Gdx.graphics.getWidth() / 2, (Gdx.graphics.getHeight() * 9) / 10);
    }

    public void dispose() {
        font.dispose();
    }


}
