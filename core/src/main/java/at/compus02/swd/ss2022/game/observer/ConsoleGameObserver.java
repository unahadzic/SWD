package at.compus02.swd.ss2022.game.observer;

public class ConsoleGameObserver implements GameObserver{
    @Override
    public void onPlayerMovedUp() {
        System.out.println("Dora moved up!");
    }

    @Override
    public void onPlayerMovedDown() {
        System.out.println("Dora moved down!");
    }

    @Override
    public void onPlayerMovedLeft() {
        System.out.println("Dora moved left!");
    }

    @Override
    public void onPlayerMovedRight() {
        System.out.println("Dora moved right!");
    }
}
