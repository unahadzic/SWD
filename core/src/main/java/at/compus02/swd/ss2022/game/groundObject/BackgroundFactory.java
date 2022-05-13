package at.compus02.swd.ss2022.game.groundObject;

import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;

public class BackgroundFactory {

    private Array<GameObject> groundObjects = new Array<>();

    ArrayList<GameObject> background;
    Gravel gravel;
    Gras gras;
    Wall wall;
    Water water;
    int backgrounditems = 63; // Anzahl der items
    int differenttypes= 4; // Hintergrund Elemente
    private int ycoordinate =  -240;
    private int xcoordinate = -240;
    private int tilesamountx = 7;

    public  void createObjects()
    {
        background = new ArrayList<>();
        gravel = new Gravel();
        gras = new Gras();
        water = new Water();
        wall = new Wall();

        for(int i = 0; i <= backgrounditems ; i = i+differenttypes)
        {
            groundObjects.add(gravel);
            groundObjects.add(gras);
            groundObjects.add(wall);
            groundObjects.add(water);

        }


    }

    public  void placeBackground(SpriteBatch batch){

        for(int i = 0; i <= groundObjects.size; i++)
        {

            if(i == tilesamountx) {
                ycoordinate = ycoordinate +60;
                xcoordinate = 0;
                tilesamountx = tilesamountx +8;
            }
            groundObjects.get(i).setPosition(xcoordinate,ycoordinate);
            groundObjects.get(i).draw(batch);
        }

    }




}
