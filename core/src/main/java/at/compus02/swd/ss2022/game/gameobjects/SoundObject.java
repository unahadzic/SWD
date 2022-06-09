package at.compus02.swd.ss2022.game.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class SoundObject {
    private String path;

    public SoundObject(String path) {
        this.path = path;
    }

    public void start(float volume){
        Sound mp3Sound = Gdx.audio.newSound(Gdx.files.internal(path));
        mp3Sound.loop(volume);
    }
}
