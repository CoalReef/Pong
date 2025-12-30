package com.saltgames.dev.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.saltgames.dev.Ball;
import com.saltgames.dev.EnemyPaddle;
import com.saltgames.dev.Managers.GameStateManager;
import com.saltgames.dev.PlayerPaddle;

public class PlayState extends State {
    GameStateManager gsm;

    // Game Objects
    Ball ball;
    PlayerPaddle playerPaddle;
    EnemyPaddle enemyPaddle;

    boolean gameOver = false;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        this.gsm = gsm;
        ball = new Ball(gsm.getMain().getBatch(), gsm.getMain().getShape(), 10, 10);
        playerPaddle = new PlayerPaddle(gsm.getMain().getBatch(), gsm.getMain().getShape(), 10, 100, 10);
        enemyPaddle = new EnemyPaddle(gsm.getMain().getBatch(), gsm.getMain().getShape(), ball, 10, 100, 10);
    }

    public void update() {
        if (ball.getY() <= 0 || ball.getY() >= Gdx.graphics.getHeight()) {
            gameOver = true;
        } else {
            ball.update(playerPaddle, enemyPaddle);
            playerPaddle.update();
            enemyPaddle.update();
        }
    }

    public void render() {
        if (gameOver) {
            gsm.setState(new GameOverState(gsm));
        } else {
            gsm.getMain().getShape().begin(ShapeRenderer.ShapeType.Filled);
            ball.render();
            playerPaddle.render();
            enemyPaddle.render();
            gsm.getMain().getShape().end();
        }
    }

    public void dispose() {

    }
}
