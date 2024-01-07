package com.hreinn.skaalmaster;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.hreinn.skaalmaster.screens.CardScreens.OnePlayerCardScreen;

import java.util.ArrayList;
import java.util.List;

public class SkaalMaster extends Game {

    private SpriteBatch batch;
    private final List<Player> players = new ArrayList<>();

    @Override
    public void create() {

        batch = new SpriteBatch();
        players.addAll(List.of(
                new Player("Hreinn", Color.valueOf("32a852")),
                new Player("Tobbe", Color.valueOf("c9d450")),
                new Player("Fredrik", Color.valueOf("ca0b0b"))
        ));
        this.setScreen(new OnePlayerCardScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getRandomPlayer() {
        return players.get((int) (players.size() * Math.random()));
    }

    public void addPlayer(Player player) {
        players.add(player);
    }
}
