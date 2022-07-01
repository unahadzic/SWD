package at.compus02.swd.ss2022.game.strategies;

import at.compus02.swd.ss2022.game.commands.CommandDown;
import at.compus02.swd.ss2022.game.commands.CommandLeft;
import at.compus02.swd.ss2022.game.commands.CommandRight;
import at.compus02.swd.ss2022.game.commands.CommandUp;
import at.compus02.swd.ss2022.game.gameobjects.GameObject;

public class EnemyMovement {

    public EnemyMovement() {

    }

    public void goToEnemy(GameObject gameObject, GameObject dora)
    {
        if(dora.getX()<gameObject.getX())
        {
            new CommandLeft(gameObject).execute();
        } else if(dora.getX()>gameObject.getX())
        {
            new CommandRight(gameObject).execute();
        } else if(dora.getY()<gameObject.getY())
        {
            new CommandDown(gameObject).execute();
        } else if(dora.getY()>gameObject.getY())
        {
            new CommandUp(gameObject).execute();
        }

    }
    public void goFromEnemy(GameObject gameObject, GameObject dora)
    {
        if(dora.getX()<gameObject.getX())
        {
            new CommandRight(gameObject).execute();
        }
        if(dora.getX()>gameObject.getX())
        {
            new CommandLeft(gameObject).execute();
        } if(dora.getY()<gameObject.getY())
        {
            new CommandUp(gameObject).execute();
        } if(dora.getY()>gameObject.getY())
        {
            new CommandDown(gameObject).execute();
        }

    }
}
