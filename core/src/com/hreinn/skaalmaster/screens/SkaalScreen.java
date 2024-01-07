package com.hreinn.skaalmaster.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.hreinn.skaalmaster.SkaalMaster;

public abstract class SkaalScreen implements Screen {

    public static final Color BACKGROUND_COLOR = new Color((25f / 255), 0, 51f / 255, 1);

    private final SkaalMaster game;
    private final Camera camera;
    private final Viewport screenViewport;
    private final Stage stage;

    protected SkaalScreen(SkaalMaster game) {
        this.game = game;
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        screenViewport = new ExtendViewport(800, 640, camera);
        stage = new Stage(screenViewport);
        Gdx.input.setInputProcessor(stage);
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(getBackgroundColor());
        camera.update();
        game.getBatch().setProjectionMatrix(camera.combined);

        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
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
        stage.dispose();
    }

    protected Color getBackgroundColor(){
        return BACKGROUND_COLOR;
    }

    protected SkaalMaster getGame() {
        return game;
    }

    public Stage getStage() {
        return stage;
    }

    public float getWidth() {
        return stage.getWidth();
    }

    public float getHeight() {
        return stage.getHeight();
    }

    protected void addActor(Actor actor) {
        getStage().addActor(actor);
    }


    protected void removeActor(Actor actor) {
        actor.remove();
    }

    protected Camera getCamera() {
        return camera;
    }
}
