package fossilfind.platformer.world;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import fossilfind.library.graphic.GraphicsHandler;
import fossilfind.platformer.Launcher;
import fossilfind.platformer.block.AirBlock;
import fossilfind.platformer.block.Block;
import fossilfind.platformer.entity.creature.Player;
import fossilfind.platformer.graphic.Assets;
import fossilfind.platformer.state.State;
import fossilfind.platformer.state.TestLevelState;
import fossilfind.platformer.ui.ClickListener;
import fossilfind.platformer.ui.UIManager;
import fossilfind.platformer.ui.UITextButton;
import fossilfind.platformer.util.Util;

public class World
{
	private Block[][] blocks;
	private int width, height, spawnX, spawnY;
	private Player player;
	private UIManager pauseButtons;
	
	private boolean paused;
	
	public World(String path)
	{
		loadWorld(path);
		
		player = new Player(spawnX, spawnY);
		
		pauseButtons = new UIManager();
		
		pauseButtons.addObject(new UITextButton(960, 350, "Main Menu", Color.WHITE, Color.BLACK, true, new Font("Arial", Font.PLAIN, 70), new ClickListener()
		{
			@Override
			public void onClick()
			{
				State.setState(Launcher.HANDLER.getMenuState());
				paused = false;
			}
		}));
		pauseButtons.addObject(new UITextButton(960, 500, "Settings", Color.WHITE, Color.BLACK, true, new Font("Arial", Font.PLAIN, 70), new ClickListener()
		{
			@Override
			public void onClick()
			{
				State.setState(Launcher.HANDLER.getSettingsState());
				Launcher.HANDLER.getSettingsState().fromGame();
			}
		}));
		pauseButtons.addObject(new UITextButton(960, 650, "Restart", Color.WHITE, Color.BLACK, true, new Font("Arial", Font.PLAIN, 70), new ClickListener()
		{
			@Override
			public void onClick()
			{
				Launcher.HANDLER.setTestLevelState(new TestLevelState());
				State.setState(Launcher.HANDLER.getTestLevelState());
				paused = false;
			}
		}));
		pauseButtons.addObject(new UITextButton(960, 800, "Quit", Color.WHITE, Color.BLACK, true, new Font("Arial", Font.PLAIN, 70), new ClickListener()
		{
			@Override
			public void onClick()
			{
				System.exit(0);
			}
		}));
		
		paused = false;
	}
	
	public void tick()
	{
		if(Launcher.HANDLER.getInputs().keyJustPressed(KeyEvent.VK_ESCAPE)) paused = !paused;
		
		if(paused) 
		{
			Launcher.HANDLER.getInputs().setUiManager(pauseButtons);
			pauseButtons.tick();
			
			return;
		}
		
		Launcher.HANDLER.getInputs().setUiManager(null);
		
		for(int x = 0; x < width; x++)
		{
			for(int y = 0; y < height; y++)
			{
				blocks[x][y].tick();
			}
		}
		
		player.tick();
	}
	
	public void render(Graphics g)
	{	
		for(int x = 0; x < width; x++)
		{
			for(int y = 0; y < height; y++)
			{
				blocks[x][y].render(g);
			}
		}
		
		player.render(g);
		
		if(paused)
		{
			g.drawImage(Assets.pauseMenu, 603, 127, 714, 826, null);
			GraphicsHandler.drawString(g, "Pause", 960, 200, true, Color.WHITE, new Font("Arial", Font.PLAIN, 100));
			pauseButtons.render(g);
		}
	}
	
	private void loadWorld(String path)
	{
		String file = Util.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Util.parseInt(tokens[0]);
		height = Util.parseInt(tokens[1]);
		spawnX = Util.parseInt(tokens[2]);
		spawnY = Util.parseInt(tokens[3]);
		
		blocks = new Block[width][height];
		for(int y = 0; y < height; y++)
		{
			for(int x = 0; x < width; x++)
			{
				blocks[x][y] = new Block(Util.parseInt(tokens[(x + y * width) + 4]), x, y);
			}
		}
	}
	
	public Block getBlock(int x, int y)
	{
		if(x < 0 || y < 0 || x > width - 1 || y > height - 1) return new AirBlock(x, y);
		Block block = blocks[x][y];
		if(block == null) return new AirBlock(x, y);
		return block;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
}