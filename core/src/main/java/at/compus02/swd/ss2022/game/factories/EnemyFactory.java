package at.compus02.swd.ss2022.game.factories;

import at.compus02.swd.ss2022.game.enums.AssetFactoryEnum;
import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import at.compus02.swd.ss2022.game.gameobjects.InteractiveObject;
import com.badlogic.gdx.utils.Array;

public class EnemyFactory {
    private Array<GameObject> enemies;

    public void createEnemies(int howMuchEnemies)
    {
        enemies = new Array<>();

        for(int i = 0;i < howMuchEnemies; i++)
        {
            enemies.add(new InteractiveObject(AssetFactoryEnum.swiper));
        }
    }
    public void placeForeground()
    {
        int min = -4;
        int max = 3;
         for (GameObject enemy: enemies) {
             int xPos = (int)(Math.random()*(max-min+1)+min);
             int yPos = (int)(Math.random()*(max-min+1)+min);
             xPos *= 60;
             yPos *= 60;
             enemy.setPosition(xPos,yPos);
        }
    }

    public Array<GameObject> getEnemies ()
    {
        return enemies;
    }
}
