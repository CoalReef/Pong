package com.saltgames.dev;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
    SpriteBatch batch;
    ShapeRenderer shape;
    int xSpeed;
    int ySpeed;
    int xPos;
    int yPos;

    public Ball(SpriteBatch batch, ShapeRenderer shape, int xSpeed, int ySpeed) {
        this.batch = batch;
        this.shape = shape;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;

        // Give base y and y positions in the middle of screen for game start
        yPos = Gdx.graphics.getHeight() / 2;
        xPos = Gdx.graphics.getWidth() / 2;
    }

    public void update(PlayerPaddle playerPaddle, EnemyPaddle enemyPaddle) {
        // Logic for wall collision
        if (xPos >= Gdx.graphics.getWidth() - 10 || xPos <= 10) {
            xSpeed *= -1;
        }

        // Logic for paddle collision
        if (yPos <= playerPaddle.getYPos() + 10 &&
            xPos >= playerPaddle.getXPos() &&
            xPos <= playerPaddle.getXPos() + playerPaddle.getWidth() &&
            yPos >= playerPaddle.getYPos() ||
            yPos >= enemyPaddle.getyPos() && yPos <= enemyPaddle.getyPos() + enemyPaddle.getHeight() &&
            xPos >= enemyPaddle.getxPos() &&
            xPos <= enemyPaddle.getxPos() + enemyPaddle.getWidth()) {
            ySpeed *= -1;
        }



        // Add speed valuce to position after logic for if bounced or not
        xPos += xSpeed;
        yPos += ySpeed;
    }

    public void render() {
        shape.circle(xPos, yPos, 10);
    }

    public int getY() {
        return yPos;
    }

    public int getX() {
        return xPos;
    }
}
