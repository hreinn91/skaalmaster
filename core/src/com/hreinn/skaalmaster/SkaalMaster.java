package com.hreinn.skaalmaster;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.hreinn.skaalmaster.screens.WarningScreen;

public class SkaalMaster extends Game {

    private SpriteBatch batch;

	@Override
	public void create () {
        batch = new SpriteBatch();
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
}
