package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.BullsEye;



public class GameSelectionScreen implements Screen {

    private BullsEye parent;
    private Stage stage;

    private TextButton game1, game2, logout, go;
    private Dialog levelDialog;
    private Skin skin;
    private SelectBox<String> selectBoxLevel;

    public GameSelectionScreen(BullsEye bullsEye) {
        parent = bullsEye;
        stage = new Stage(new ScreenViewport());
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        Gdx.input.setCatchKey(Input.Keys.BACK, true);

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1/30f));
        stage.draw();

        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        game1 = new TextButton("Game 1", skin);
        game2 = new TextButton("Game 2", skin);
        logout = new TextButton("Logout", skin);

        game1.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                levelDialog = new Dialog("Select Difficulty", skin);
                levelDialog.setSize(100, 100);
                levelDialog.setPosition(Gdx.graphics.getWidth()/2-100, Gdx.graphics.getHeight()/2-100);
                selectBoxLevel = new SelectBox<String>(skin);
                selectBoxLevel.setItems("Easy", "Medium", "Hard");
                go = new TextButton("Go -->>", skin);
                levelDialog.getContentTable().defaults().pad(10);
                levelDialog.getContentTable().add(selectBoxLevel);
                levelDialog.getContentTable().row();
                levelDialog.getContentTable().add(go);
                levelDialog.show(stage);
                stage.addActor(levelDialog);
                go.addListener(new ChangeListener() {
                    @Override
                    public void changed(ChangeEvent event, Actor actor) {
                        parent.openGame(BullsEye.GAME_SCREEN_1, selectBoxLevel.getSelectedIndex());
                    }
                });
                if(Gdx.input.isKeyPressed(Input.Keys.BACK)) {
                    levelDialog.cancel();
                }
            }
        });

        game2.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                levelDialog = new Dialog("Select Difficulty", skin);
                levelDialog.setSize(100, 100);
                levelDialog.setPosition(Gdx.graphics.getWidth()/2-100, Gdx.graphics.getHeight()/2-100);
                selectBoxLevel = new SelectBox<String>(skin);
                selectBoxLevel.setItems("Easy", "Medium", "Hard");
                go = new TextButton("Go -->>", skin);
                levelDialog.getContentTable().defaults().pad(10);
                levelDialog.getContentTable().add(selectBoxLevel);
                levelDialog.getContentTable().row();
                levelDialog.getContentTable().add(go);
                levelDialog.show(stage);
                stage.addActor(levelDialog);
                go.addListener(new ChangeListener() {
                    @Override
                    public void changed(ChangeEvent event, Actor actor) {
                        parent.openGame(BullsEye.GAME_SCREEN_2, selectBoxLevel.getSelectedIndex());
                    }
                });
                if(Gdx.input.isKeyPressed(Input.Keys.BACK)) {
                    levelDialog.cancel();
                }
            }
        });

        table.add(game1).fillX().uniformX();
        table.row().pad(30, 0, 40, 0);
        table.add(game2).fillX().uniformX();
        table.row().pad(30, 0, 90, 0);
        table.add(logout).fillX().uniformX().right();
        table.row().pad(0, 0, 0, 0);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1/30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
