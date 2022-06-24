package at.compus02.swd.ss2022.game.commands;

import at.compus02.swd.ss2022.game.gameobjects.GameObject;

public class EnemyMovement {

    public EnemyMovement() {

    }

    public void goToEnemy(GameObject gameObject, GameObject dora)
    {
        if(dora.getX()<=gameObject.getX())
        {
            new CommandLeft(gameObject).execute();
        }
        if(dora.getX()>=gameObject.getX())
        {
            new CommandRight(gameObject).execute();
        }
        if(dora.getY()<=gameObject.getY())
        {
            new CommandDown(gameObject).execute();
        }
        if(dora.getY()>=gameObject.getX())
        {
            new CommandUp(gameObject).execute();
        }

    }
}
