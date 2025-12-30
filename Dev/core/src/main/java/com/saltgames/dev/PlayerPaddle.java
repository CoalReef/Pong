package com.saltgames.dev;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class PlayerPaddle {
    SpriteBatch batch;
    ShapeRenderer shape;
    int speed;
    int xPos;
    int yPos;
    int width;
    int height;

    public PlayerPaddle(SpriteBatch batch, ShapeRenderer shape, int speed, int width, int height) {
        this.batch = batch;
        this.shape = shape;
        this.speed = speed;

        // Set base y and x positons prior to update
        xPos = Gdx.graphics.getWidth() / 2;
        yPos = Gdx.graphics.getHeight() / 8;

        // Modular height and width on creation
        this.width = width;
        this.height = height;
    }

    public void update() {
        // Logic to move paddle based on user input
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && xPos >= 0) {
            xPos -= speed;
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && xPos <= Gdx.graphics.getWidth() - width) {
            xPos += speed;
        }
    }

    public void render() {
        shape.rect(xPos, yPos, width, 5);
    }

    public int getYPos() {
        return yPos;
    }

    public int getXPos() {
        return xPos;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
