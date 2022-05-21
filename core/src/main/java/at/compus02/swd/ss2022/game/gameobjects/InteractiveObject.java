package at.compus02.swd.ss2022.game.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class InteractiveObject implements GameObject
{

    private Texture image;
    private Sprite sprite;

    public InteractiveObject(int objectType){
        switch (objectType){
            case 1:
                image = new Texture("bush.png");
                sprite = new Sprite(image);
            break;
            case 2:
                image = new Texture("log.png");
                sprite = new Sprite(image);
            break;
            case 3:
                image = new Texture("sign.png");
                sprite = new Sprite(image);
            break;
            case 4:
                image = new Texture("stone.png");
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
        sprite.setSize(backgroundElement, backgroundElement);
        sprite.draw(batch);
    }

}
