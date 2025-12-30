package com.saltgames.dev;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class EnemyPaddle {
    SpriteBatch batch;
    ShapeRenderer shape;

    int speed;
    int width;
    int height;
    int xPos;
    int yPos;

    Ball ball;

    boolean isFollowing;

    public EnemyPaddle(SpriteBatch batch, ShapeRenderer shape, Ball ball, int speed, int width, int height) {
        this.batch = batch;
        this.shape = shape;
        this.speed = speed;
        this.width = width;
        this.height = height;
        this.xPos = Gdx.graphics.getWidth() / 2;
        this.yPos = (Gdx.graphics.getHeight() * 7) / 8;
        this.ball = ball;
    }

    public void update() {
        isFollowing = false;

        if (ball.getX() < xPos || ball.getX() > xPos + width) {
            isFollowing = true;
        }

        if (isFollowing) {
            if (ball.getX() < xPos + (width / 2)) {
                xPos -= speed;
            } else if (ball.getX() > xPos + (width / 2)) {
                xPos += speed;
            } else {
                isFollowing = false;
            }
        }
    }

    public void render() {
        shape.rect(xPos, yPos, width, height);
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

