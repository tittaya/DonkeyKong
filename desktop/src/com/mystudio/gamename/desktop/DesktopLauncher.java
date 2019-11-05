package com.mystudio.gamename.desktop;

import com.mystudio.gamename.DonkeyKongGame;
import org.mini2Dx.desktop.DesktopMini2DxConfig;
import com.badlogic.gdx.backends.lwjgl.DesktopMini2DxGame;

import com.mystudio.gamename.DonkeyKongGame;
import static com.mystudio.gamename.Variable.*;

public class DesktopLauncher {
	public static void main (String[] arg) {
		DesktopMini2DxConfig config = new DesktopMini2DxConfig(DonkeyKongGame.GAME_IDENTIFIER);
		config.vSyncEnabled = true;
		config.width = SCREEN_WIDTH;
		config.height = SCREEN_HEIGHT;
		new DesktopMini2DxGame(new DonkeyKongGame(), config);
	}
}
