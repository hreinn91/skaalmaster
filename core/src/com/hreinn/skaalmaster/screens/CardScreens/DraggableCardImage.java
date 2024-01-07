package com.hreinn.skaalmaster.screens.CardScreens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.badlogic.gdx.utils.Align;
import com.hreinn.skaalmaster.Player;
import com.hreinn.skaalmaster.util.LabelFactory;

class DraggableCardImage extends Image {

    private final OnePlayerCardScreen screen;
    private final Label instructionLabel;
    private final Label playerNameLabel;
    private final Player player;

    private final float screenWidth;
    private final float screenHeight;

    public DraggableCardImage(OnePlayerCardScreen onePlayerCardScreen) {
        super(new Texture("image/rectangle.png"));
        this.screen = onePlayerCardScreen;
        this.player = screen.getNextPlayer();
        screenWidth = screen.getStage().getWidth();
        screenHeight = screen.getStage().getHeight();

        setPosition(screenWidth * 0.1f, screenHeight * 0.1f);
        setWidth(screenWidth * 0.85f);
        setHeight(screenHeight * 0.85f);
        setColor(player.getPlayerColor());

        String nextInstruction = screen.getNextInstruction();
        instructionLabel = LabelFactory.createLabel(nextInstruction, 0, 0, Color.WHITE);
        instructionLabel.setFontScale(0.4f);
        instructionLabel.setBounds(getX(), getY(), getWidth(), getHeight());
        instructionLabel.setAlignment(Align.center);

        playerNameLabel = LabelFactory.createLabel(player.getPlayerName(), 0, 0, Color.WHITE);
        playerNameLabel.setFontScale(1f);

        setLabelPositions();
//        addListener(new ClickListener() {
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                screen.nextCard();
//            }
//        });
    }

    private void setLabelPositions() {
        instructionLabel.setBounds(getX(), getY(), getWidth(), getHeight());
        instructionLabel.setAlignment(Align.center);
        instructionLabel.setPosition(instructionLabel.getX(), instructionLabel.getY() + 100);
        playerNameLabel.setAlignment(Align.bottom);
        playerNameLabel.setBounds(getX(), getY(), getWidth(), getHeight());
        playerNameLabel.setPosition(playerNameLabel.getX(),
                playerNameLabel.getY() + 100);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        instructionLabel.draw(batch, parentAlpha);
        playerNameLabel.draw(batch, parentAlpha);
    }

    public void addDragListener() {
        addListener(new CardDragListener());
    }

    private class CardDragListener extends DragListener {
        // Note that startDrag is not the same as dragStart
        private float startDragX = 0;
        private float startDragY = 0;

        @Override
        public void dragStart(InputEvent event, float x, float y, int pointer) {
            this.startDragX = x;
            this.startDragY = y;
        }

        @Override
        public void drag(InputEvent event, float x, float y, int pointer) {
            moveBy(x - startDragX, y - startDragY);
            setLabelPositions();
            System.out.println(x + "  " + y);
        }
    }
}

