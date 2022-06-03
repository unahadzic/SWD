package at.compus02.swd.ss2022.game.DoraTheExplorer;

import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Dora implements GameObject
{
    private Texture image;
    private Sprite sprite;

    public Dora() {
        image = new Texture("dora.png");
        sprite = new Sprite(image);
    }
    @Override
    public void act(float delta) {
        sprite.setPosition(sprite.getX(),sprite.getY());
    }

    public float getX() {
        return sprite.getX();
    }

    public float getY() {
        return sprite.getY();
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
