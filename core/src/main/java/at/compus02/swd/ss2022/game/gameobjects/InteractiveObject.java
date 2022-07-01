package at.compus02.swd.ss2022.game.gameobjects;

import at.compus02.swd.ss2022.game.enums.AssetFactoryEnum;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class InteractiveObject implements GameObject
{

    private Texture image;
    private Sprite sprite;
    private AssetRepository assetRepository = new AssetRepository();
    private boolean doNotDraw;

    public InteractiveObject(AssetFactoryEnum objectType){
        switch (objectType){
            case stone:
                image = assetRepository.getTexture(AssetFactoryEnum.stone);
                sprite = new Sprite(image);
            break;
            case sign:
                image = assetRepository.getTexture(AssetFactoryEnum.sign);
                sprite = new Sprite(image);
            break;
            case bush:
                image = assetRepository.getTexture(AssetFactoryEnum.bush);
                sprite = new Sprite(image);
            break;
            case log:
                image = assetRepository.getTexture(AssetFactoryEnum.log);
                sprite = new Sprite(image);
            break;
            case swiper:
                image = assetRepository.getTexture(AssetFactoryEnum.swiper);
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
        if (sprite == null)
            return 0;

        return sprite.getX();
    }

    @Override
    public float getY() {
        if(sprite == null)
            return 0;
        return sprite.getY();
    }

    @Override
    public void dispose() {
        image.dispose();
        sprite.setSize(0,0);
        sprite = null;
    }


}
