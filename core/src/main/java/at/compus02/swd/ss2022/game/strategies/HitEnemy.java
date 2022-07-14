package at.compus02.swd.ss2022.game.strategies;
import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import com.badlogic.gdx.utils.Array;

public class HitEnemy
{
    Array<GameObject> enemies;
    GameObject hittingObject;

    public HitEnemy(GameObject gameObject, Array<GameObject> enemies) {
        this.hittingObject = gameObject;
        this.enemies = enemies;
    }
    
    public Array<GameObject> execute() {
        Array<GameObject> deadEnemies = new Array<>();

        for(GameObject enemy: enemies) {
            float xDiff = Math.abs(hittingObject.getX() - enemy.getX());
            float yDiff = Math.abs(hittingObject.getY() - enemy.getY());
            if(xDiff <= 60 && yDiff <= 60) {
                deadEnemies.add(enemy);
            }
        }
        return deadEnemies;
    }

}
