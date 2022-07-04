package at.compus02.swd.ss2022.game.commands;

import at.compus02.swd.ss2022.game.gameobjects.GameObject;

public class CommandRight implements Command{
    GameObject dora;
    public CommandRight(GameObject dora) { this.dora = dora; }
    @Override
    public GameObject execute() {
        if(dora.getX() < 180){
            dora.setPosition(dora.getX() + 60, dora.getY());
        } else {
            return null;
        }
        return dora;
    }
}
