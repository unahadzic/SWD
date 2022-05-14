package at.compus02.swd.ss2022.game.Factories;

import at.compus02.swd.ss2022.game.gameobjects.*;
import at.compus02.swd.ss2022.game.groundObject.Gras;
import at.compus02.swd.ss2022.game.groundObject.Gravel;
import at.compus02.swd.ss2022.game.groundObject.Wall;
import at.compus02.swd.ss2022.game.groundObject.Water;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.utils.Array;

public class ForegroundFactory
{
    private Array<GameObject> foregroundObjects;


    public void createForegroundObjects()
    {
        foregroundObjects = new Array<>();

        foregroundObjects.add(new Bush());
        foregroundObjects.add(new Log());
        foregroundObjects.add(new Sign());
        foregroundObjects.add(new Stone());

    }


    public void placeForeground()
    {
        System.out.println(foregroundObjects.size);
        foregroundObjects.get(0).setPosition(30, 30);
        foregroundObjects.get(1).setPosition(180, -60);
        foregroundObjects.get(2).setPosition(-240, 120);
        foregroundObjects.get(3).setPosition(-120, 180);

    }

    public Array<GameObject> getForegroundObjects ()
    {
        return foregroundObjects;
    }
}