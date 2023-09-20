package com.hreinn.skaalmaster.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.ScreenUtils;
import com.hreinn.skaalmaster.SkaalMaster;

public class AddPlayersScreen extends SkaalScreen {

    private LabelWithImage addNewPlayerLabel;
    private Group labelWithImage = new Group();

    public AddPlayersScreen(SkaalMaster game) {
        super(game);

        String addNewPlayerText = Gdx.files.internal("text/add_new_player_text.txt").readString();
        addNewPlayerLabel = new LabelWithImage(addNewPlayerText,
                new Label.LabelStyle(new BitmapFont(), Color.WHITE),
                new Texture("plussign.png"));
        addNewPlayerLabel.setPosition(100, 500);
        addNewPlayerLabel.setFontScale(10f);
        addActor(addNewPlayerLabel);
        addActor(labelWithImage);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(BACKGROUND_COLOR);
        getCamera().update();
        getGame().getBatch().setProjectionMatrix(getCamera().combined);

        getStage().act();
        getStage().draw();

        if (Gdx.input.isTouched()) {
            System.out.println("Click");
        }
    }


    private class LabelWithImage extends Label {

        private final Image labelImage;
//        private final Label label;

        public LabelWithImage(CharSequence text,
                              LabelStyle style,
                              Texture texture) {
            super(text, style);
            labelImage = new Image(texture);
//            labelImage.set
        }

        @Override
        public void setPosition(float x, float y){
            super.setPosition(x, y);
            labelImage.setPosition(x - 20, y);
        }

        @Override
        public void draw(Batch batch,
                         float parentAlpha
        ) {
            super.draw(batch, parentAlpha);
            labelImage.draw(batch, parentAlpha);
        }
    }
}
