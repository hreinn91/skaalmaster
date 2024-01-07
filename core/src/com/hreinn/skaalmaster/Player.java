package com.hreinn.skaalmaster;

import com.badlogic.gdx.graphics.Color;

public class Player {
    private final String playerName;
    private final Color playerColor;

    public Player(String playerName, Color playerColor) {
        this.playerName = playerName;
        this.playerColor = playerColor;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Color getPlayerColor() {
        return playerColor;
    }
}
