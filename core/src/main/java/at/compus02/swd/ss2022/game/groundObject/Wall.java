package at.compus02.swd.ss2022.game.groundObject;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Wall implements GroundObject
{

    private Texture image;
    private Sprite sprite;

    public int getSize()
    {
        return size;
    }

    private int size = 60;

    public Wall() {
        image = new Texture("tile_wall.png");
        sprite = new Sprite(image);
    }
    @Override
    public void setPosition(float x, float y)
    {
        sprite.setPosition(x, y);
    }

    @Override
    public void draw(SpriteBatch batch)
    {
        sprite.setSize(size,size);
        sprite.draw(batch);
    }
}
