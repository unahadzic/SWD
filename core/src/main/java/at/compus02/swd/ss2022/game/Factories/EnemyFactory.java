package at.compus02.swd.ss2022.game.Factories;

import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import at.compus02.swd.ss2022.game.gameobjects.InteractiveObject;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;

public class EnemyFactory {

    private Array<GameObject> enemies;


    public void createEnemies(int howMuchEnemies)
    {
        enemies = new Array<GameObject>();

        for(int i = 0;i < howMuchEnemies; i++)
        {
            enemies.add(new InteractiveObject(5));
        }
    }
    public void placeForeground()
    {
         for (GameObject enemy: enemies) {
             enemy.setPosition(0,0);

        }

    }

    public Array<GameObject> getEnemies ()
    {

        return enemies;
    }




}
