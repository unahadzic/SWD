package at.compus02.swd.ss2022.game.groundObject;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface GroundObject
{
    void setPosition(float x, float y);
    void draw(SpriteBatch batch);

}
