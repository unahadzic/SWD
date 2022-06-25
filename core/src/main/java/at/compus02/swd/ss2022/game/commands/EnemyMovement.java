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
    public void goFromEnemy(GameObject gameObject, GameObject dora)
    {
     if(gameObject.getX()<170&&gameObject.getY()<170 && gameObject.getX()>-170&&gameObject.getY()>-170)
        {
            if (dora.getX() >= gameObject.getX())
            {
                new CommandLeft(gameObject).execute();

            }
            if (dora.getX() <= gameObject.getX())
            {
                new CommandRight(gameObject).execute();

            }
            if (dora.getY() >= gameObject.getY())
            {
                new CommandDown(gameObject).execute();
            }
            if (dora.getY() <= gameObject.getX())
            {
                new CommandUp(gameObject).execute();

            }
        }
        if(gameObject.getX()>=170||gameObject.getY()>=170 || gameObject.getX()<=-170||gameObject.getY()<=-170)
        {
            if(gameObject.getX() < 0)
            {
                new CommandRight(gameObject).execute();
            }
            if(gameObject.getX() > 0)
            {
                new CommandLeft(gameObject).execute();
            }
            if(gameObject.getY() < 0)
            {
                new CommandUp(gameObject).execute();
            }
            if(gameObject.getY() > 0)
            {
                new CommandDown(gameObject).execute();
            }
        }

    }
}
