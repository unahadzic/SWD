package at.compus02.swd.ss2022.game.input;

import com.badlogic.gdx.InputAdapter;

public class GameInput extends InputAdapter {
    private int keyCode;

    @Override
    public boolean keyDown(int keycode) {
        this.keyCode = keycode;
        return true;
    }

    public int getKeyCode() { return keyCode; }
    public void setKeyCode(int keyCode) { this.keyCode = keyCode; }
}
