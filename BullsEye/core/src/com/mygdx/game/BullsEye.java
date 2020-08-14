package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.game.views.GameScreen1;
import com.mygdx.game.views.GameScreen2;
import com.mygdx.game.views.GameSelectionScreen;
import com.mygdx.game.views.IntroScreen;
import com.mygdx.game.views.LoadingScreen;
import com.mygdx.game.views.LoginScreen;
import com.mygdx.game.views.PasswordResetScreen;
import com.mygdx.game.views.PreferencesScreen;
import com.mygdx.game.views.SignupScreen;

public class BullsEye extends Game {

	private LoadingScreen loadingScreen;
	private IntroScreen introScreen;
	private LoginScreen loginScreen;
	private SignupScreen signupScreen;
	private PreferencesScreen preferencesScreen;
	private GameSelectionScreen gameSelectionScreen;
	private PasswordResetScreen passwordResetScreen;
	private GameScreen1 gameScreen1;
	private GameScreen2 gameScreen2;

	private AppPreferences preferences;

	public final static int INTRO = 0;
	public final static int LOGIN = 1;
	public final static int SIGNUP = 2;
	public final static int PREFERENCES = 3;
	public final static int GAME_SELECTION_SCREEN = 4;
	public final static int PASSWORD_RESET = 5;
	public final static int GAME_SCREEN_1 = 6;
	public final static int GAME_SCREEN_2 = 7;

	@Override
	public void create() {
		loadingScreen = new LoadingScreen(this);
		setScreen(loadingScreen);
		preferences = new AppPreferences();
	}

	public void changeScreen(int screen) {
		switch(screen) {
			case INTRO:
				if(introScreen == null)
					introScreen = new IntroScreen(this);
				this.setScreen(introScreen);
				break;
			case LOGIN:
				if(loginScreen == null)
					loginScreen = new LoginScreen(this);
				this.setScreen(loginScreen);
				break;
			case SIGNUP:
				if(signupScreen == null)
					signupScreen = new SignupScreen(this);
				this.setScreen(signupScreen);
				break;
			case PREFERENCES:
				if(preferencesScreen == null)
					preferencesScreen = new PreferencesScreen(this);
				this.setScreen(preferencesScreen);
				break;
			case GAME_SELECTION_SCREEN:
				if(gameSelectionScreen == null)
					gameSelectionScreen = new GameSelectionScreen(this);
				this.setScreen(gameSelectionScreen);
				break;
			case PASSWORD_RESET:
				if(passwordResetScreen == null)
					passwordResetScreen = new PasswordResetScreen(this);
				this.setScreen(passwordResetScreen);
				break;
		}
	}

	public void openGame(int game, int complexity) {
		switch (game) {
			case GAME_SCREEN_1:
				if(gameScreen1 == null)
					gameScreen1 = new GameScreen1(this, complexity);
				this.setScreen(gameScreen1);
				break;
			case GAME_SCREEN_2:
				if(gameScreen2 == null)
					gameScreen2 = new GameScreen2(this, complexity);
				this.setScreen(gameScreen2);
				break;
		}
	}

	public AppPreferences getPreferences() {
		return this.preferences;
	}

}
