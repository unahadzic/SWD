package at.compus02.swd.ss2022.game.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class InteractiveObject implements GameObject
{

    private Texture image;
    private Sprite sprite;
    private AssetRepository assetRepository = new AssetRepository();
    private boolean doNotDraw;

    public InteractiveObject(int objectType){
        switch (objectType){
            case 1:
                image = assetRepository.getTexture(8);
                sprite = new Sprite(image);
            break;
            case 2:
                image = assetRepository.getTexture(7);
                sprite = new Sprite(image);
            break;
            case 3:
                image = assetRepository.getTexture(6);
                sprite = new Sprite(image);
            break;
            case 4:
                image = assetRepository.getTexture(5);
                sprite = new Sprite(image);
            break;
            case 5:
                image = assetRepository.getTexture(10);
                sprite = new Sprite(image);
            break;
            default:
                Exception exception = new Exception("Pfad ist nicht gültig");
                try {
                    throw exception;
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }

        sprite.setSize(backgroundElement, backgroundElement);

    }

    @Override
    public void act(float delta) {

    }

    @Override
    public void setPosition(float x, float y)
    {
        sprite.setPosition(x, y);
    }

    @Override
    public void draw(SpriteBatch batch)
    {
        if(sprite != null) {
            sprite.draw(batch);
        }

    }

    @Override
    public float getX() {
        return sprite.getX();
    }

    @Override
    public float getY() {
        return sprite.getY();
    }

    @Override
    public void dispose() {
        image.dispose();
        sprite.setSize(0,0);
        sprite = null;
    }


}
