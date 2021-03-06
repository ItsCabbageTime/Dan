package dumbfoundgames.dan.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import dumbfoundgames.dan.Launcher;
import dumbfoundgames.dan.graphic.Assets;
import dumbfoundgames.dan.ui.ClickListener;
import dumbfoundgames.dan.ui.UIManager;
import dumbfoundgames.dan.ui.UITextButton;
import dumbfoundgames.library.graphic.GraphicsHandler;

public class StartState extends State
{
	private UIManager uiManager;
	
	public StartState()
	{
		super();
		
		uiManager = new UIManager();
		
		uiManager.addObject(new UITextButton(960, 800, "Start", Color.WHITE, Color.BLACK, true, new Font("Arial", Font.PLAIN, 80), new ClickListener()
		{
			@Override
			public void onClick()
			{
				State.setState(Launcher.HANDLER.getMenuState());
				Launcher.HANDLER.getInputs().setUiManager(null);
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
		
		GraphicsHandler.drawString(g, "Dan", 960, 540, true, Color.WHITE, new Font("Arial", Font.PLAIN, 200));
		GraphicsHandler.drawString(g, "Credits: 99", 960, 950, true, Color.WHITE, new Font("Arial", Font.PLAIN, 50));
		
		uiManager.render(g);
	}
}