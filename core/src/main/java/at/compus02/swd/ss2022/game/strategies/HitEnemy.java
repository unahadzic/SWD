package at.compus02.swd.ss2022.game.strategies;

import at.compus02.swd.ss2022.game.commands.Command;
import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import com.badlogic.gdx.utils.Array;

public class HitEnemy implements Command
{

    Array<GameObject> enemies;
    GameObject hittingObject;

    public HitEnemy(GameObject gameObject, Array<GameObject> enemies) {
        this.hittingObject = gameObject;
        this.enemies = enemies;
    }

    @Override
    public GameObject execute() {
        return null;
    }

    public Array<GameObject> hitEnemy()
    {
        //System.out.println("Dora schlägt Swiper");
        for (int i = 0;i<enemies.size; i++) {
            if ((enemies.get(i)==null))
                break;

            if((enemies.get(i).getX()-hittingObject.getX())<65 && (enemies.get(i).getY()-hittingObject.getY())<65) {
                System.out.println("Dora schlägt Swiper");
                enemies.removeIndex(i);
            }

        }
        return enemies;

    }


}
