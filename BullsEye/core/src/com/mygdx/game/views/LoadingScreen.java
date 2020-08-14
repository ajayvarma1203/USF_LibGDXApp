package com.mygdx.game.views;

import com.badlogic.gdx.Screen;
import com.mygdx.game.BullsEye;

public class LoadingScreen implements Screen {

    private BullsEye parent;

    public LoadingScreen(BullsEye bullsEye) {
        parent = bullsEye;
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        parent.changeScreen(BullsEye.INTRO);
    }

    @Override
    public void resize(int width, int height) {

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

    }
}
