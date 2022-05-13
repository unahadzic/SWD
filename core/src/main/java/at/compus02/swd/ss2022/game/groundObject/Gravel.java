package at.compus02.swd.ss2022.game.groundObject;

import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Gravel implements GameObject
{
    private Texture image;
    private Sprite sprite;

    public int getSize()
    {
        return size;
    }

    private int size = 60;

    public Gravel() {
        image = new Texture("tile_gravel.png");
        sprite = new Sprite(image);
    }

    @Override
    public void act(float delta) {

    }

    @Override
    public void setPosition(float x, float y) {
        sprite.setPosition(x, y);
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.setSize(size,size);
        sprite.draw(batch);
    }
}
