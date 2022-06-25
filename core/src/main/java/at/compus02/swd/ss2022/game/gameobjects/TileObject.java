package at.compus02.swd.ss2022.game.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TileObject implements GameObject {
    private Texture image;
    private Sprite sprite;

    public TileObject(int Type) {

        AssetRepository assetRepository = new AssetRepository();
        image = assetRepository.getTexture(Type);
        sprite = new Sprite(image);

    }

    @Override
    public void act(float delta) {

    }

    public void makeOrange() {
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

    @Override
    public float getX() {
        return sprite.getX();
    }

    @Override
    public float getY() {
        return getY();
    }

    @Override
    public void dispose() {

    }

}
