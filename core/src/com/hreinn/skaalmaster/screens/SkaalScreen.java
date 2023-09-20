package com.hreinn.skaalmaster.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.hreinn.skaalmaster.SkaalMaster;

public abstract class SkaalScreen implements Screen {

    public static final Color BACKGROUND_COLOR = new Color((25f / 255), 0, 51f / 255, 1);

    private final SkaalMaster game;
    private final OrthographicCamera camera;
    private final Stage stage = new Stage();

    protected SkaalScreen(SkaalMaster game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        Gdx.input.setInputProcessor(stage);
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(BACKGROUND_COLOR);

        stage.act();
        stage.draw();

        camera.update();
        game.getBatch().setProjectionMatrix(camera.combined);

        if (Gdx.input.isTouched()) {
            System.out.println("Click");
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
    }

    protected SkaalMaster getGame() {
        return game;
    }

    protected Stage getStage() {
        return stage;
    }

    protected void addActor(Actor actor) {
        getStage().addActor(actor);
    }

    protected OrthographicCamera getCamera() {
        return camera;
    }
}
