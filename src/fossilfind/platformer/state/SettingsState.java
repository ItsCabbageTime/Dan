package fossilfind.platformer.state;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import fossilfind.platformer.Launcher;
import fossilfind.platformer.graphic.Assets;
import fossilfind.platformer.ui.UIManager;

public class SettingsState extends State
{
	private UIManager settings;
	
	private boolean fromMenu, fromGame;
	
	public SettingsState()
	{
		super();
		
		settings = new UIManager();
	}
	
	@Override
	public void tick()
	{
		if(State.getState() == this) Launcher.HANDLER.getInputs().setUiManager(settings);
		settings.tick();
		
		if(Launcher.HANDLER.getInputs().keyJustPressed(KeyEvent.VK_ESCAPE))
		{
			if(fromMenu) State.setState(Launcher.HANDLER.getMenuState());
			if(fromGame) State.setState(State.getLevelState());
		}
	}

	@Override
	public void render(Graphics g)
	{
		for(int x = 0; x < 15; x++)
		{
			for(int y = 0; y < 9; y++)
			{
				g.drawImage(Assets.brick, 128 * x, 128 * y, 128, 128, null);
			}
		}
		
		settings.render(g);
	}
	
	public void fromMenu()
	{
		fromMenu = true;
		fromGame = false;
	}
	
	public void fromGame()
	{
		fromMenu = false;
		fromGame = true;
	}
}