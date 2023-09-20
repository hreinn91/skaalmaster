package com.hreinn.skaalmaster.screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.hreinn.skaalmaster.SkaalMaster;
import com.hreinn.skaalmaster.util.LabelFactory;

public class WarningScreen extends SkaalScreen {

    private Label instructionLabel;
    private Label messageLabel;
    private int numberOfClicks = 0;


    public WarningScreen(SkaalMaster game) {
        super(game);

        String warningText = Gdx.files.internal("text/warning01.txt").readString();
        messageLabel = LabelFactory.createLabel(warningText, 100, 500, Color.WHITE);
        getStage().addActor(messageLabel);
        String proceedText = "Click to Proceed";
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);

        if (Gdx.input.isTouched()) {
            System.out.println("Click");
        }
    }

    @Override
    public void dispose() {
        getStage().dispose();
    }
}
