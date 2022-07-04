package at.compus02.swd.ss2022.game.commands;

import at.compus02.swd.ss2022.game.gameobjects.GameObject;

public class CommandDown implements Command{
    GameObject dora;
    public CommandDown(GameObject dora) { this.dora = dora; }

    @Override
    public GameObject execute() {
        if(dora.getY() > -240){
            dora.setPosition(dora.getX(), dora.getY() - 60);
        } else {
            return null;
        }
        return dora;
    }
}
