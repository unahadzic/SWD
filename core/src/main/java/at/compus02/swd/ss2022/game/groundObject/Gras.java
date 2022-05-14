package at.compus02.swd.ss2022.game.groundObject;

import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Gras implements GameObject
{

    private Texture image;
    private Sprite sprite;

    public Gras() {
        image = new Texture("tile_gras.png");
        sprite = new Sprite(image);
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
