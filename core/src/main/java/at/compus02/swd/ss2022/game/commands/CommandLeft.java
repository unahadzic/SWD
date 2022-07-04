package at.compus02.swd.ss2022.game.commands;

import at.compus02.swd.ss2022.game.gameobjects.GameObject;

public class CommandLeft implements Command{
    GameObject dora;

    public CommandLeft(GameObject dora) { this.dora = dora; }
    @Override
    public GameObject execute() {
        if(dora.getX() > -240){
            dora.setPosition(dora.getX() - 60, dora.getY());
        } else {
            return null;
        }
        return dora;
    }
}
