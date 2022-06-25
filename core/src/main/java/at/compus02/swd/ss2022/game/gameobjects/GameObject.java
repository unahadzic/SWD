package at.compus02.swd.ss2022.game.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface GameObject {
    float foregroundElement = 60;
    float backgroundElement = 60;
    void act(float delta);
    void setPosition(float x, float y);
    void draw(SpriteBatch batch);
    float getX();
    float getY();
    void dispose();


}
