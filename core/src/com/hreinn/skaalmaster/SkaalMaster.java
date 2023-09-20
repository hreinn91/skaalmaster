package com.hreinn.skaalmaster;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.hreinn.skaalmaster.screens.AddPlayersScreen;
import com.hreinn.skaalmaster.screens.WarningScreen;

import java.util.ArrayList;
import java.util.List;

public class SkaalMaster extends Game {

    private SpriteBatch batch;
	private final List<Player> players = new ArrayList<>();

	@Override
	public void create () {
        batch = new SpriteBatch();
//        this.setScreen(new AddPlayersScreen(this));
        this.setScreen(new WarningScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		super.dispose();
        batch.dispose();
	}

    public SpriteBatch getBatch() {
        return batch;
    }
	
	public List<Player> getPlayers() {
		return players;
	}

	public void addPlayer(Player player){
		players.add(player);
	}
}
