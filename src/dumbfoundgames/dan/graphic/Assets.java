package dumbfoundgames.dan.graphic;

import java.awt.image.BufferedImage;

import dumbfoundgames.library.graphic.GraphicsHandler;
import dumbfoundgames.library.graphic.SpriteSheet;

public class Assets
{	
	public static BufferedImage 
			brick, 
			mountains, 
			pauseMenu, characterSelect,
			btnStart, btnStartHover, btnSettings, btnSettingsHover, btnQuit, btnQuitHover;
	
	public static void init()
	{
		SpriteSheet ui = new SpriteSheet(GraphicsHandler.loadImage("src/res/textures/ui.png"), 64);
		
		brick = GraphicsHandler.loadImage("src/res/textures/brick.png");
		
		mountains = GraphicsHandler.loadImage("src/res/textures/mountain.png");
		
		pauseMenu = GraphicsHandler.loadImage("src/res/textures/pause_menu.png");
		characterSelect = GraphicsHandler.loadImage("src/res/textures/character_select.png");
		
		btnStart = ui.crop(0, 1, 2, 1);
		btnStartHover = ui.crop(2, 1, 2, 1);
		btnSettings = ui.crop(0, 0, 2, 1);
		btnSettingsHover = ui.crop(2, 0, 2, 1);
		btnQuit = ui.crop(0, 2, 2, 1);
		btnQuitHover = ui.crop(2, 2, 2, 1);
	}
}