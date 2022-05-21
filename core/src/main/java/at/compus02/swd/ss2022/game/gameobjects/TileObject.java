package at.compus02.swd.ss2022.game.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TileObject implements GameObject
{
    private Texture image;
    private Sprite sprite;

    public TileObject(int Type) {
        switch (Type){
            case 1:
                image = new Texture("tile_gras.png");
                sprite = new Sprite(image);
            break;
            case 2:
                image = new Texture("tile_wall.png");
                sprite = new Sprite(image);
            break;
            case 3:
                image = new Texture("tile_gravel.png");
                sprite = new Sprite(image);
            break;
            case 4:
                image = new Texture("tile_water.png");
                sprite = new Sprite(image);
            break;
            default:
                Exception exception = new Exception("Dieses Tile gibt es nicht" + Type);
                try {
                    throw exception;
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }


    }
    @Override
    public void act(float delta) {

    }

    public void makeOrange(){
        sprite.setColor(1, 0.64f, 0, 1f);
    }

    @Override
    public void setPosition(float x, float y) {
        sprite.setPosition(x, y);
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.setSize(foregroundElement, foregroundElement);
        sprite.draw(batch);
    }
}
