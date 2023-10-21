package com.hreinn.skaalmaster.screens.CardScreens;

import com.hreinn.skaalmaster.SkaalMaster;
import com.hreinn.skaalmaster.screens.SkaalScreen;

public class ChallengeScreen extends SkaalScreen {

    public ChallengeScreen(SkaalMaster game) {
        super(game);
        game.getPlayers().forEach(e -> System.out.println(e.getPlayerName()));
    }
}
