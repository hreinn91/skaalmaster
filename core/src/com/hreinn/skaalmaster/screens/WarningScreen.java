package com.hreinn.skaalmaster.screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.ScreenUtils;
import com.hreinn.skaalmaster.SkaalMaster;
import com.hreinn.skaalmaster.util.FontFactory;

public class WarningScreen implements Screen {

    private static final Color BACKGROUND_COLOR = new Color((25f / 255), 0, 51f / 255, 1);

    private SkaalMaster game;
    private OrthographicCamera camera;
    private Stage stage = new Stage();
    private BitmapFont bitmapFont;


    public WarningScreen(SkaalMaster game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        Gdx.input.setInputProcessor(stage);


        bitmapFont = FontFactory.getRobotRegular(Color.WHITE);

        Label.LabelStyle labelStyle = new Label.LabelStyle(bitmapFont, null);

        Label label2 = new Label("True Type Font (.ttf) - Gdx FreeType", labelStyle);
        label2.setPosition(100, 500);
        label2.setFontScale(1f);
        String text = Gdx.files.internal("text/warning01.txt").readString();
        label2.setText(text);
        stage.addActor(label2);

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
        stage.dispose();

    }
}
