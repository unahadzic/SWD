package at.compus02.swd.ss2022.game;

import at.compus02.swd.ss2022.game.DoraTheExplorer.Dora;
import at.compus02.swd.ss2022.game.Factories.ForegroundFactory;
import at.compus02.swd.ss2022.game.commands.CommandDown;
import at.compus02.swd.ss2022.game.commands.CommandLeft;
import at.compus02.swd.ss2022.game.commands.CommandRight;
import at.compus02.swd.ss2022.game.commands.CommandUp;
import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import at.compus02.swd.ss2022.game.Factories.BackgroundFactory;
import at.compus02.swd.ss2022.game.input.GameInput;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
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
    Dora dora;

    private Array<GameObject> gameObjects = new Array<>();

    SpriteBatch batchforground;

    BackgroundFactory backgroundFactory;
    ForegroundFactory foregroundFactory;


    private final float updatesPerSecond = 60;
    private final float logicFrameTime = 1 / updatesPerSecond;
    private float deltaAccumulator = 0;
    private BitmapFont font;

    @Override
    public void create() {

        batchforground = new SpriteBatch();
        backgroundFactory = new BackgroundFactory();
        foregroundFactory = new ForegroundFactory();

        font = new BitmapFont();
        font.setColor(Color.WHITE);

       dora = new Dora();

        Gdx.input.setInputProcessor(this.gameInput);

        foregroundFactory.createForegroundObjects();
        foregroundFactory.placeForeground();

        backgroundFactory.createObjects();
        backgroundFactory.placeBackground();


        gameObjects.addAll(backgroundFactory.getGroundObjects());
        gameObjects.addAll(foregroundFactory.getForegroundObjects());
        gameObjects.add(dora);


    }

    private void act(float delta) {
        if(gameInput.getKeyCode() == 19){ //keycode 19 -> Up
            dora = new CommandUp(dora).execute();
            gameInput.setKeyCode(0);
        } else if (gameInput.getKeyCode() == 20) { //keycode 20 -> Down
            dora = new CommandDown(dora).execute();
            gameInput.setKeyCode(0);
        } else if (gameInput.getKeyCode() == 21) { //keycode 21 -> Left
            dora = new CommandLeft(dora).execute();
            gameInput.setKeyCode(0);
        } else if (gameInput.getKeyCode() == 22) { //keycode 22 -> Right
            dora = new CommandRight(dora).execute();
            gameInput.setKeyCode(0);
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