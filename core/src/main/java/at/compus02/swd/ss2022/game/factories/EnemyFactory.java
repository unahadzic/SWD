package at.compus02.swd.ss2022.game.factories;

import at.compus02.swd.ss2022.game.enums.AssetFactoryEnum;
import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import at.compus02.swd.ss2022.game.gameobjects.InteractiveObject;
import com.badlogic.gdx.utils.Array;

public class EnemyFactory {

    private Array<GameObject> enemies;


    public void createEnemies(int howMuchEnemies)
    {
        enemies = new Array<GameObject>();

        for(int i = 0;i < howMuchEnemies; i++)
        {
            enemies.add(new InteractiveObject(AssetFactoryEnum.swiper));
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
