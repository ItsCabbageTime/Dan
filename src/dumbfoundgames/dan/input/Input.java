package dumbfoundgames.dan.input;

import java.awt.event.MouseEvent;

import dumbfoundgames.dan.ui.UIManager;
import dumbfoundgames.library.input.InputManager;

public class Input extends InputManager
{
	private boolean[] justPressed, cantPress;
	private UIManager uiManager;
	
	public Input()
	{
		justPressed = new boolean[256];
		cantPress = new boolean[256];
	}
	
	public void tick()
	{
		for(int i = 0;i < keys.length;i++)
		{
			if(cantPress[i] && !keys[i])
			{
				cantPress[i] = false;
			}
			else if(justPressed[i])
			{
				cantPress[i] = true;
				justPressed[i] = false;
			}
			if(!cantPress[i] && keys[i])
			{
				justPressed[i] = true;
			}
		}
	}
	
	public boolean keyJustPressed(int keyCode)
	{
		if(keyCode < 0 || keyCode >= keys.length)
			return false;
		return justPressed[keyCode];
	}
	
	@Override
	public void mouseDragged(MouseEvent e)
	{
		super.mouseDragged(e);
		
		if(uiManager != null) uiManager.onMouseDragged();
	}
	
	@Override
	public void mouseMoved(MouseEvent e)
	{
		super.mouseMoved(e);
		
		if(uiManager != null) uiManager.onMouseMoved(e);
	}
	
	@Override
	public void mouseReleased(MouseEvent e)
	{
		super.mouseReleased(e);
		
		if(uiManager != null) uiManager.onMouseReleased();
	}
	
	public UIManager getUiManager()
	{
		return uiManager;
	}
	
	public void setUiManager(UIManager uiManager)
	{
		this.uiManager = uiManager;
	}
}