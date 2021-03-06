package at.compus02.swd.ss2022.game.factories;

import at.compus02.swd.ss2022.game.enums.AssetFactoryEnum;
import at.compus02.swd.ss2022.game.gameobjects.*;
import com.badlogic.gdx.utils.Array;

public class ForegroundFactory
{
    private Array<GameObject> foregroundObjects;


    public void createForegroundObjects()
    {
        foregroundObjects = new Array<>();

        foregroundObjects.add(new InteractiveObject(AssetFactoryEnum.stone));
        foregroundObjects.add(new InteractiveObject(AssetFactoryEnum.log));
        foregroundObjects.add(new InteractiveObject(AssetFactoryEnum.sign));
        foregroundObjects.add(new InteractiveObject(AssetFactoryEnum.stone));


    }


    public void placeForeground()
    {
        System.out.println(foregroundObjects.size);
        foregroundObjects.get(0).setPosition(60, 60);
        foregroundObjects.get(1).setPosition(180, -60);
        foregroundObjects.get(2).setPosition(-240, 120);
        foregroundObjects.get(3).setPosition(-60, 180);

    }

    public Array<GameObject> getForegroundObjects ()
    {
        return foregroundObjects;
    }
}