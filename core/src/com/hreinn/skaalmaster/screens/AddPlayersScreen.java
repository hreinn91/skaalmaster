package com.hreinn.skaalmaster.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.hreinn.skaalmaster.Player;
import com.hreinn.skaalmaster.SkaalMaster;
import com.hreinn.skaalmaster.screens.CardScreens.OnePlayerCardScreen;
import com.hreinn.skaalmaster.util.LabelFactory;

import java.util.ArrayList;
import java.util.List;

public class AddPlayersScreen extends SkaalScreen {

    protected static float YPOS_START_GAME = Gdx.graphics.getHeight() - 580;
    protected static float YPOS_NEW_PLAYER = Gdx.graphics.getHeight() - 900;
    protected static float YPOS_PLAYERS_START_POS = YPOS_NEW_PLAYER - 300;
    protected static float XPOS_LEFT = 70f;
    protected static float XPOS_RIGHT = Gdx.graphics.getWidth() - 250f;

    private final AddNewPlayerImage addNewPlayerImage;
    private final StartGameImage startGameImage;
    protected final List<RemovablePlayer> removablePlayers = new ArrayList<>();
    protected final List<Color> availableColors = availableColors();

    public AddPlayersScreen(SkaalMaster game) {
        super(game);
        addNewPlayerImage = new AddNewPlayerImage();
        startGameImage = new StartGameImage();
        addActor(addNewPlayerImage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        if (Gdx.input.isTouched()) {
            System.out.println("Render clicked");
        }

    }

    protected void addNewRemovablePlayer(String name) {
        RemovablePlayer removablePlayer = new RemovablePlayer(name, XPOS_LEFT);
        removablePlayers.add(removablePlayer);
        addActor(removablePlayer.nameLabel);
        addActor(removablePlayer.deleteButton);
        if (removablePlayers.size() > 1) {
            addActor(startGameImage);
        }
    }

    protected void updatePlayerPositions() {
        float yPos = YPOS_PLAYERS_START_POS;
        for (RemovablePlayer player : removablePlayers){
            player.updatePosition(yPos);
            yPos = yPos - 200f;
        }
    }

    private ArrayList<Color> availableColors() {
        return new ArrayList<>(List.of(
                Color.valueOf("ca0b0b")
        ));
    }

    protected Color getRandomColor() {
        return availableColors.remove((int) (availableColors.size() * Math.random()));
    }

    private class StartGameImage extends Image {
        private final Sound skaalSound;

        public StartGameImage() {
            super(new Texture("image/start-game.png"));
            setPosition(XPOS_LEFT, YPOS_START_GAME);
            setScale(2.5f);
            skaalSound = Gdx.audio.newSound(Gdx.files.internal("sound/fredrik-skaaaaal-001.mp4"));
            addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    long id = skaalSound.play();
                    skaalSound.setVolume(id, 10);
                    removablePlayers.forEach(p -> getGame().addPlayer(new Player(p.getName(), getRandomColor())));
                    getGame().setScreen(new OnePlayerCardScreen(getGame()));
                }
            });
        }
    }

    private class AddNewPlayerImage extends Image {
        private final NewPlayerTextInputListener textInputListener = new NewPlayerTextInputListener();

        public AddNewPlayerImage() {
            super(new Texture("image/add-new-player.png"));
            setPosition(XPOS_LEFT, YPOS_NEW_PLAYER);
            setScale(0.8f);
            addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (removablePlayers.size() > 8) {
                        return;
                    }
                    System.out.println("Clicked");
                    Gdx.input.getTextInput(textInputListener, "New Player Name", "", textInputListener.getHint());
                }
            });
        }
    }

    private class RemovablePlayer {
        protected Label nameLabel;
        protected Image deleteButton;

        public RemovablePlayer(String name, float xPos) {
            float yPos = getNextYPos();
            this.nameLabel = LabelFactory.createLabel(name, xPos, yPos, Color.WHITE);
            this.nameLabel.setFontScale(1.2f);
            this.deleteButton = new Image(new Texture("image/red-cross.png"));
            this.deleteButton.setScale(0.7f);
            this.deleteButton.setPosition(XPOS_RIGHT, yPos - 20f);
            this.deleteButton.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    removablePlayers.remove(RemovablePlayer.this);
                    if (removablePlayers.size() < 2) {
                        startGameImage.remove();
                    }
                    updatePlayerPositions();
                    dispose();
                }
            });
        }

        public void updatePosition(float yPos) {
            nameLabel.setFontScale(1.2f);
            nameLabel.setPosition(XPOS_LEFT, yPos);
            deleteButton.setPosition(XPOS_RIGHT, yPos - 20f);
        }

        public float getNextYPos() {
            return removablePlayers.isEmpty() ? YPOS_PLAYERS_START_POS : removablePlayers.get(removablePlayers.size() - 1).deleteButton.getY() - 200f;
        }

        public void dispose() {
            nameLabel.remove();
            deleteButton.remove();
        }

        public String getName() {
            return nameLabel.getName();
        }
    }

    private class NewPlayerTextInputListener implements Input.TextInputListener {

        @Override
        public void input(String input) {
            if (input == null || input.isEmpty()) {
                return;
            }
            System.out.println("Clicked INPUT");
            String name = input.substring(0, Math.min(input.length(), 18));
            addNewRemovablePlayer(name);
        }

        @Override
        public void canceled() {
            System.out.println("Aborted");
        }

        public String getHint() {
            List<String> hints = List.of(
                    "Max 3 letters",
                    "No dirty names",
                    "Remember to drink water",
                    "Pick something funny now",
                    "Pick what ever you like",
                    "Sangria is really good");
            return hints.get((int) (hints.size() * Math.random()));
        }
    }
}
