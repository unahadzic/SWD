package at.compus02.swd.ss2022.game;

import at.compus02.swd.ss2022.game.doraTheExplorer.Dora;
import at.compus02.swd.ss2022.game.factories.EnemyFactory;
import at.compus02.swd.ss2022.game.factories.ForegroundFactory;
import at.compus02.swd.ss2022.game.commands.*;
import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import at.compus02.swd.ss2022.game.factories.BackgroundFactory;
import at.compus02.swd.ss2022.game.gameobjects.SoundObject;
import at.compus02.swd.ss2022.game.input.GameInput;
import at.compus02.swd.ss2022.game.observer.ConsoleGameObserver;
import at.compus02.swd.ss2022.game.observer.GameObservable;
import at.compus02.swd.ss2022.game.observer.GameObserver;
import at.compus02.swd.ss2022.game.observer.UIGameObserver;
import at.compus02.swd.ss2022.game.strategies.EnemyMovement;
import at.compus02.swd.ss2022.game.strategies.HitEnemy;
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
public class Main extends ApplicationAdapter implements GameObservable {


    private ExtendViewport viewport = new ExtendViewport(480.0f, 480.0f, 480.0f, 480.0f);
    private GameInput gameInput = new GameInput();
    Dora dora;

    private Array<GameObject> gameObjects = new Array<>();
    private Array<GameObserver> observerList = new Array<>();

    SpriteBatch batchforground;

    BackgroundFactory backgroundFactory;
    ForegroundFactory foregroundFactory;
    EnemyFactory enemyFactory;

    Array<GameObject> enemiesObject;

    EnemyMovement enemyMovement = new EnemyMovement();

    private final float updatesPerSecond = 60;
    private final float logicFrameTime = 1 / updatesPerSecond;
    private float deltaAccumulator = 0;
    private BitmapFont font;
    private static String UIText = "Hello Game";


    public static void setUIText(String text) {
        UIText = text;
    }

    @Override
    public void create() {

        batchforground = new SpriteBatch();
        backgroundFactory = new BackgroundFactory();
        foregroundFactory = new ForegroundFactory();
        enemyFactory = new EnemyFactory();

        font = new BitmapFont();
        font.setColor(Color.WHITE);

        SoundObject backgroundSound = new SoundObject("soundassets/263060__b-lamerichs__short-loops-04-02-2015-2b.mp3");
        backgroundSound.start(0.2f);

        dora = new Dora();
        dora.setPosition(-120,120);

        Gdx.input.setInputProcessor(this.gameInput);

        enemyFactory.createEnemies(4);
        enemyFactory.placeForeground();
        enemiesObject = enemyFactory.getEnemies();


        foregroundFactory.createForegroundObjects();
        foregroundFactory.placeForeground();

        backgroundFactory.createObjects();
        backgroundFactory.placeBackground();


        gameObjects.addAll(backgroundFactory.getGroundObjects());
        gameObjects.addAll(foregroundFactory.getForegroundObjects());
        gameObjects.addAll(enemiesObject);
        gameObjects.add(dora);

        ConsoleGameObserver consoleObserver = new ConsoleGameObserver();
        UIGameObserver uiObserver = new UIGameObserver();
        observerList.add(consoleObserver);
        observerList.add(uiObserver);

    }

    private void act(float delta) {
        if (gameInput.getKeyCode() == 19) { //keycode 19 -> Up
            if(new CommandUp(dora).execute() != null){
                for (GameObserver element : observerList) {
                    element.onPlayerMovedUp();
                }
            }else {
                for (GameObserver element : observerList) {
                    element.onPlayerHitWall();
                }
            }
            gameInput.setKeyCode(0);

            goToEnemy(enemyMovement);
            goFromEnemy(enemyMovement);
        } else if (gameInput.getKeyCode() == 20) { //keycode 20 -> Down
            if(new CommandDown(dora).execute() != null) {
                for (GameObserver element : observerList) {
                    element.onPlayerMovedDown();
                }
            } else {
                for (GameObserver element : observerList) {
                    element.onPlayerHitWall();
                }
            }
            gameInput.setKeyCode(0);

            goToEnemy(enemyMovement);
            goFromEnemy(enemyMovement);
        } else if (gameInput.getKeyCode() == 21) { //keycode 21 -> Left
            if(new CommandLeft(dora).execute() != null) {
                for (GameObserver element : observerList) {
                    element.onPlayerMovedLeft();
                }
            } else {
                for (GameObserver element : observerList) {
                    element.onPlayerHitWall();
                }
            }
            gameInput.setKeyCode(0);

            goToEnemy(enemyMovement);
            goFromEnemy(enemyMovement);
        } else if (gameInput.getKeyCode() == 22) { //keycode 22 -> Right
            if(new CommandRight(dora).execute() != null) {
                for (GameObserver element : observerList) {
                    element.onPlayerMovedRight();
                }
            } else {
                for (GameObserver element : observerList) {
                    element.onPlayerHitWall();
                }
            }
            gameInput.setKeyCode(0);

            goToEnemy(enemyMovement);
            goFromEnemy(enemyMovement);
        } else if (gameInput.getKeyCode() == 36) { //keycode for h -> hit
            Array<GameObject> deadEnemies;
            deadEnemies = new HitEnemy(dora, enemiesObject).execute();
            for (GameObject enemy: deadEnemies) {
                gameObjects.removeIndex(gameObjects.indexOf(enemy,true));
                enemiesObject.removeIndex(enemiesObject.indexOf(enemy, true));
            }
            gameInput.setKeyCode(0);
        }
    }

    private void draw() {
        batchforground.setProjectionMatrix(viewport.getCamera().combined);
        batchforground.begin();

        for (GameObject gameObject : gameObjects) {
            gameObject.draw(batchforground);
        }

        font.draw(batchforground, UIText, -220, -220);
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

    @Override
    public void registerObserver(GameObserver observer) {
        this.observerList.add(observer);
    }

    public void goToEnemy(EnemyMovement enemyMovement) {
        for (int i = 0; i < enemiesObject.size; i = i + 3) {
            enemyMovement.goToEnemy(enemiesObject.get(i), dora);
        }
    }

    public void goFromEnemy(EnemyMovement enemyMovement) {
        for (int i = 1; i < enemiesObject.size; i = i + 3) {
            enemyMovement.goFromEnemy(enemiesObject.get(i), dora);
        }
        for (int i = 2; i < enemiesObject.size; i = i + 3) {
            enemyMovement.goFromEnemy2(enemiesObject.get(i), dora);
        }
    }


}



