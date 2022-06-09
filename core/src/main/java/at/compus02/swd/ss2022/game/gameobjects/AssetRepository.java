package at.compus02.swd.ss2022.game.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class AssetRepository {

    private Texture grasImage;
    private Texture wallImage;
    private Texture waterImage;
    private Texture gravelTexture;

    private Texture bush;
    private Texture log;
    private Texture sign;
    private Texture stone;
    private Texture dora;

    public AssetRepository() {
    }



    public Texture getTexture(int whichTexture) {
        switch (whichTexture) {
            case 1:
                return createTextrue(grasImage,"tile_gras.png");

            case 2:
                return createTextrue(wallImage,"tile_wall.png");

            case 3:
                return createTextrue(gravelTexture,"tile_gravel.png");

            case 4:
                return createTextrue(waterImage,"tile_water.png");

            case 5:
                return createTextrue(stone,"stone.png");

            case 6:
                return createTextrue(sign,"sgin.png");

            case 7:
                return createTextrue(log,"log.png");

            case 8:
                return createTextrue(bush, "bush.png");

            case 9:
                return createTextrue(dora,"dora.png");


            default:
                Exception exception = new Exception("Dieses Tile gibt es nicht" + whichTexture);
                try {
                    throw exception;
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        return null;
    }

   private Texture createTextrue(Texture tile, String path)
    {
        if(tile != null)
            return tile;

        tile = new Texture(path);
        return tile;



    }






}
