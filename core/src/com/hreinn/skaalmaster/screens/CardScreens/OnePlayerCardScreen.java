package com.hreinn.skaalmaster.screens.CardScreens;

import com.hreinn.skaalmaster.Player;
import com.hreinn.skaalmaster.SkaalMaster;
import com.hreinn.skaalmaster.challanges.SinglePlayerCards;
import com.hreinn.skaalmaster.screens.SkaalScreen;

public class OnePlayerCardScreen extends SkaalScreen {

    private DraggableCardImage topCard;
    private DraggableCardImage bottomCard;
    private final SinglePlayerCards singlePlayerCards = new SinglePlayerCards();

    public OnePlayerCardScreen(SkaalMaster game) {
        super(game);
        topCard = new DraggableCardImage(this);
        bottomCard = new DraggableCardImage(this);
        addActor(bottomCard);
        addActor(topCard);
        topCard.addDragListener();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }

    protected String getNextInstruction() {
        return singlePlayerCards.pop();
    }

    protected Player getNextPlayer() {
        return getGame().getRandomPlayer();
    }

    protected void nextCard(){
        System.out.println("New Card");
        removeActor(topCard);
        removeActor(bottomCard);

        topCard = bottomCard;
        bottomCard = new DraggableCardImage(this);
        addActor(bottomCard);
        addActor(topCard);
        topCard.addDragListener();
    }


}
