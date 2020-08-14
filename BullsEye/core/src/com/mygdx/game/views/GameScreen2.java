package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.BullsEye;

public class GameScreen2 implements Screen {

    private BullsEye parent;
    private Stage stage;
    private int complexity;
    private ImageButton image;
    private TextField name;
    private TextButton next, check, hint;

    public GameScreen2(BullsEye bullsEye, int complexity) {
        parent = bullsEye;
        stage = new Stage(new ScreenViewport());
        this.complexity = complexity;
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

        Skin skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        image = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("image1.png")))));
        image.setSkin(skin);

        name = new TextField("", skin);
        name.setMessageText("........");
//        name.setHeight(250);
        name.setAlignment(Align.center);

        check = new TextButton("Check", skin);

        next = new TextButton("Next", skin);
//        next.setSize(160, 40);
        next.setPosition(Gdx.graphics.getWidth()-350, next.getHeight()-110);
        stage.addActor(next);

        hint = new TextButton("Hint!", skin);
//        hint.setSize(160, 40);
        hint.setPosition(Gdx.graphics.getWidth()-350, Gdx.graphics.getHeight()-hint.getHeight()-30);
        stage.addActor(hint);

        table.add(image).fillX().uniformX();
        table.row().pad(20, 0, 20, 0);
        table.add(name).fillX().uniformX();
        table.row().pad(20, 0, 20, 0);
        table.add(check).fillX().uniformX();
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
