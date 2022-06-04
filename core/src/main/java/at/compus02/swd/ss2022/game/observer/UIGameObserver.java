package at.compus02.swd.ss2022.game.observer;

import at.compus02.swd.ss2022.game.Main;

public class UIGameObserver implements GameObserver{
    @Override
    public void onPlayerMovedUp() {
        Main.setUIText("Dora moved up!");
    }

    @Override
    public void onPlayerMovedDown() {
        Main.setUIText("Dora moved down!");
    }

    @Override
    public void onPlayerMovedLeft() {
        Main.setUIText("Dora moved left!");
    }

    @Override
    public void onPlayerMovedRight() {
        Main.setUIText("Dora moved right!");
    }
}
