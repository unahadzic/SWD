package at.compus02.swd.ss2022.game.Factories;

import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import at.compus02.swd.ss2022.game.groundObject.Gras;
import at.compus02.swd.ss2022.game.groundObject.Gravel;
import at.compus02.swd.ss2022.game.groundObject.Wall;
import at.compus02.swd.ss2022.game.groundObject.Water;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;

public class BackgroundFactory {

    private Array<GameObject> groundObjects;

    int backgrounditems = 64; // Anzahl der items
    int differenttypes = 4; // Hintergrund Elemente
    private float ycoordinate = -240;
    private float xcoordinate = -240;
    private int tilesamountx = 8;

    public Array<GameObject> getGroundObjects() {
        return groundObjects;
    }

    public void createObjects() {
        groundObjects = new Array<>();


        for (int i = 0; i < backgrounditems; i = i + differenttypes) {


            groundObjects.add(new Gravel());
            groundObjects.add(new Gras());
            groundObjects.add(new Wall());
            groundObjects.add(new Water());
        }

    }


    public void placeBackground() {
        System.out.println(groundObjects.size);

        for (int i = 0; i < groundObjects.size; i++) {

            if (i % tilesamountx == 0 && i != 0) {
                ycoordinate = ycoordinate + 60;
                xcoordinate = -240;
                tilesamountx = tilesamountx + 8;
            }

            System.out.println(ycoordinate);
            System.out.println(xcoordinate);

            groundObjects.get(i).setPosition(xcoordinate, ycoordinate);
            xcoordinate = xcoordinate + 60;
        }




    }


}
