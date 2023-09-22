package com.hreinn.skaalmaster.screens;

import static com.badlogic.gdx.graphics.Color.WHITE;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.hreinn.skaalmaster.Player;
import com.hreinn.skaalmaster.SkaalMaster;
import com.hreinn.skaalmaster.util.LabelFactory;

import java.util.ArrayList;
import java.util.List;

public class AddPlayersScreen extends SkaalScreen {

    private final AddNewPlayerImage addNewPlayer;

    public AddPlayersScreen(SkaalMaster game) {
        super(game);
        addNewPlayer = new AddNewPlayerImage(game.getPlayers());
        addActor(addNewPlayer);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

//        getGame().getPlayers().
    }

    private class AddNewPlayerImage extends Image {
        private float xPos;
        private float yPos;
        List<Player> players;

        public AddNewPlayerImage(List<Player> players) {
            super(new Texture("image/add-new-player.png"));
            this.players = players;
            xPos = 75f;
            yPos = Gdx.graphics.getHeight() - 400;
            setPosition(xPos, yPos);
            setScale(0.8f);

            addListener(new ClickListener() {

//                private List<String> hints = List.of("");

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    Input.TextInputListener textListener = new Input.TextInputListener()
                    {
                        @Override
                        public void input(String input)
                        {
                            System.out.println(input);
                        }

                        @Override
                        public void canceled()
                        {
                            System.out.println("Aborted");
                        }
                    };
                    Gdx.input.getTextInput(textListener, "Player Name", "Name", "Max 3 char");
                }
            });
        }

        public float getYPos() {
            return yPos;
        }
    }
}
