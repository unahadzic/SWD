package at.compus02.swd.ss2022.game.gameobjects;

import at.compus02.swd.ss2022.game.Enums.AssetFactoryEnum;
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

    private Texture enemy;

    public AssetRepository() {
    }



    public Texture getTexture(AssetFactoryEnum whichTexture) {
        switch (whichTexture) {
            case gras:
                return createTextrue(grasImage,"tile_gras.png");

            case wall:
                return createTextrue(wallImage,"tile_wall.png");

            case gravel:
                return createTextrue(gravelTexture,"tile_gravel.png");

            case water:
                return createTextrue(waterImage,"tile_water.png");

            case stone:
                return createTextrue(stone,"stone.png");

            case sign:
                return createTextrue(sign,"sign.png");

            case log:
                return createTextrue(log,"log.png");

            case bush:
                return createTextrue(bush, "bush.png");

            case dora:
                return createTextrue(dora,"dora.png");

            case swiper:
                return createTextrue(enemy,"Swiper.png");

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
