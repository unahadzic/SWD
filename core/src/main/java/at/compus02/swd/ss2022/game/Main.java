package at.compus02.swd.ss2022.game;

import at.compus02.swd.ss2022.game.gameobjects.Bush;
import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import at.compus02.swd.ss2022.game.gameobjects.Sign;
import at.compus02.swd.ss2022.game.gameobjects.Stone;
import at.compus02.swd.ss2022.game.groundObject.BackgroundFactory;
import at.compus02.swd.ss2022.game.input.GameInput;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class Main extends ApplicationAdapter {


    private ExtendViewport viewport = new ExtendViewport(480.0f, 480.0f, 480.0f, 480.0f);
    private GameInput gameInput = new GameInput();

    private Array<GameObject> gameObjects = new Array<>();

    SpriteBatch batchforground;

    BackgroundFactory backgroundFactory;


    private final float updatesPerSecond = 60;
    private final float logicFrameTime = 1 / updatesPerSecond;
    private float deltaAccumulator = 0;
    private BitmapFont font;

    @Override
    public void create() {
        backgroundFactory = new BackgroundFactory();
        batchforground = new SpriteBatch();

        gameObjects.add(new Sign());
        Bush bush = new Bush();
        bush.setPosition(30, 0);
        Stone stone = new Stone();
        stone.setPosition(-30, 0);
        gameObjects.add(stone);
        gameObjects.add(bush);
        font = new BitmapFont();
        font.setColor(Color.WHITE);
        Gdx.input.setInputProcessor(this.gameInput);
        backgroundFactory.createObjects();
        gameObjects.addAll(backgroundFactory.placeBackground());

    }

    private void act(float delta) {
        for (GameObject gameObject : gameObjects) {
            gameObject.act(delta);
        }

    }

    private void draw() {
        batchforground.setProjectionMatrix(viewport.getCamera().combined);
        batchforground.begin();
        for (GameObject gameObject : gameObjects) {
            gameObject.draw(batchforground);
        }
        font.draw(batchforground, "Hello Game", -220, -220);
        batchforground.end();

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0.15f, 0.15f, 0.2f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        float delta = Gdx.graphics.getDeltaTime();
        deltaAccumulator += delta;
        while (deltaAccumulator > logicFrameTime) {
            deltaAccumulator -= logicFrameTime;
            act(logicFrameTime);
        }
        draw();
    }

    @Override
    public void dispose() {

        batchforground.dispose();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }
}