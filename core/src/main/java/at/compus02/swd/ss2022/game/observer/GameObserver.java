package at.compus02.swd.ss2022.game.observer;

public interface GameObserver {
    public void onPlayerMovedUp();
    public void onPlayerMovedDown();
    public void onPlayerMovedLeft();
    public void onPlayerMovedRight();
    public void onPlayerHitWall();
}
