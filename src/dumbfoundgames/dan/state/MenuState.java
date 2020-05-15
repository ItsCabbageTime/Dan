package dumbfoundgames.dan.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import dumbfoundgames.dan.Launcher;
import dumbfoundgames.dan.graphic.Assets;
import dumbfoundgames.dan.ui.ClickListener;
import dumbfoundgames.dan.ui.UIManager;
import dumbfoundgames.dan.ui.UITextButton;

public class MenuState extends State
{
	private UIManager uiManager;
	
	public MenuState()
	{
		uiManager = new UIManager();
		
		uiManager.addObject(new UITextButton(10 , 100, "Start", Color.WHITE, Color.BLACK, false, new Font("Arial", Font.PLAIN, 50), new ClickListener()
		{
			@Override
			public void onClick()
			{
				State.setState(Launcher.HANDLER.getTestLevelState());
				Launcher.HANDLER.getInputs().setUiManager(null);
			}
		}));
		uiManager.addObject(new UITextButton(10, 200, "Settings", Color.WHITE, Color.BLACK, false, new Font("Arial", Font.PLAIN, 50), new ClickListener()
		{
			@Override
			public void onClick()
			{
				State.setState(Launcher.HANDLER.getSettingsState());
				Launcher.HANDLER.getSettingsState().fromMenu();
				Launcher.HANDLER.getInputs().setUiManager(null);
			}
		}));
		uiManager.addObject(new UITextButton(10, 300, "Quit", Color.WHITE, Color.BLACK, false, new Font("Arial", Font.PLAIN, 50), new ClickListener()
		{
			@Override
			public void onClick()
			{
				System.exit(0);
			}
		}));
	}
	
	@Override
	public void tick()
	{
		if(State.getState() == this) Launcher.HANDLER.getInputs().setUiManager(uiManager);
		uiManager.tick();
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
		
		uiManager.render(g);
	}
}