package com.saltgames.dev;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.saltgames.dev.Managers.GameStateManager;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private GameStateManager gsm;
    private ShapeRenderer shape;
    private BitmapFont font;

    @Override
    public void create() {
        batch = new SpriteBatch();
        gsm = new GameStateManager(this);
        shape = new ShapeRenderer();
        font = new BitmapFont();
    }

    @Override
    public void render() {
        ScreenUtils.clear(0f, 0f, 0f, 1f);
        gsm.update();
        gsm.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public ShapeRenderer getShape() {
        return shape;
    }

    public BitmapFont getFont() {
        return font;
    }
}
