package com.hreinn.skaalmaster.screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.ScreenUtils;
import com.hreinn.skaalmaster.SkaalMaster;

public class WarningScreen implements Screen {

    private static final Color BACKGROUND_COLOR = new Color((25f / 255), 0, 51f / 255, 1);

    private SkaalMaster game;
    private OrthographicCamera camera;
    private Stage stage = new Stage();


    public WarningScreen(SkaalMaster game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        Gdx.input.setInputProcessor(stage);



        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("BebasNeue-Regular.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 1000;
        parameter.borderWidth = 1;
        parameter.color = Color.WHITE;
        parameter.shadowOffsetX = 3;
        parameter.shadowOffsetY = 3;
        parameter.shadowColor = new Color(0, 0.5f, 0, 0.75f);
        BitmapFont font24 = generator.generateFont(parameter); // font size 24 pixels
        generator.dispose();

        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = font24;

        Label label2 = new Label("True Type Font (.ttf) - Gdx FreeType", labelStyle);
//        label2.setSize(10, 10);
        label2.setPosition(100, 100);
        label2.setFontScale(0.1f);
        label2.setText("hahahaha");
//        label2.setFontScale(0.5f);
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
