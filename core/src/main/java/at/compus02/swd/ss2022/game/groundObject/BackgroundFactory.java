package at.compus02.swd.ss2022.game.groundObject;

import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;

public class BackgroundFactory {

    private Array<GameObject> groundObjects;

    int backgrounditems = 63; // Anzahl der items
    int differenttypes= 4; // Hintergrund Elemente
    private float ycoordinate =  -300;
    private float xcoordinate = -240;
    private int tilesamountx = 7;

    public  void createObjects()
    {
        groundObjects = new Array<>();


        for(int i = 0; i <= backgrounditems ; i = i+differenttypes)
        {
            groundObjects.add(new Gravel());
            groundObjects.add(new Gras());
            groundObjects.add(new Wall());
            groundObjects.add(new Water());

        }


    }

    public  Array<GameObject> placeBackground(){
        System.out.println(groundObjects.size);

        for(int i = 0; i < groundObjects.size; i++)
        {

            if(i%tilesamountx==0) {
                ycoordinate = ycoordinate +60;
                xcoordinate = 0;
                tilesamountx = tilesamountx +8;
            }
            xcoordinate = xcoordinate + 60;
            System.out.println(ycoordinate);
            System.out.println(xcoordinate);

            groundObjects.get(i).setPosition(xcoordinate,ycoordinate);

        }

        return groundObjects;



    }




}
