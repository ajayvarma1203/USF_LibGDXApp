package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.BullsEye;

public class PasswordResetScreen implements Screen {

    private BullsEye parent;
    private Stage stage;
    private TextField userName, month, date, year, password, confirmPassword;
    private TextButton resetPassword;

    public PasswordResetScreen(BullsEye bullsEye) {
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

        Skin skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        userName = new TextField("", skin);
        userName.setMessageText("Username");
        month = new TextField("", skin);
        month.setMessageText("MM");
        month.setTextFieldFilter(new TextField.TextFieldFilter.DigitsOnlyFilter());
        month.setMaxLength(2);
        date = new TextField("", skin);
        date.setMessageText("DD");
        date.setTextFieldFilter(new TextField.TextFieldFilter.DigitsOnlyFilter());
        date.setMaxLength(2);
        year = new TextField("", skin);
        year.setMessageText("YYYY");
        year.setTextFieldFilter(new TextField.TextFieldFilter.DigitsOnlyFilter());
        year.setMaxLength(4);
        password = new TextField("", skin);
        password.setMessageText("Password");
        password.setPasswordMode(true);
        password.setPasswordCharacter('*');
        confirmPassword = new TextField("", skin);
        confirmPassword.setMessageText("Confirm Password");
        confirmPassword.setPasswordMode(true);
        confirmPassword.setPasswordCharacter('*');
        resetPassword = new TextButton("Reset Password", skin);

        table.add(userName).colspan(3);
        table.row().pad(40, 0, 40, 0);
        table.add(month).left();
        table.add(date).center();
        table.add(year).right();
        table.row().pad(40, 0, 40, 0);
        table.add(password).colspan(3);
        table.row().pad(40, 0, 40, 0);
        table.add(confirmPassword).colspan(3);
        table.row().pad(40, 0, 40, 0);
        table.add(resetPassword).right();
        table.row().pad(40, 0, 40, 0);

        resetPassword.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.changeScreen(BullsEye.LOGIN);
            }
        });


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
