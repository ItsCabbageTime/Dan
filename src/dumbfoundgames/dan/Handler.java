package dumbfoundgames.dan;

import dumbfoundgames.dan.graphic.Camera;
import dumbfoundgames.dan.input.Input;
import dumbfoundgames.dan.state.MenuState;
import dumbfoundgames.dan.state.SettingsState;
import dumbfoundgames.dan.state.StartState;
import dumbfoundgames.dan.state.State;
import dumbfoundgames.dan.state.TestLevelState;
import dumbfoundgames.dan.world.World;

public class Handler
{
	private Dan platformer;
	
	public Handler(Dan platformer)
	{
		this.platformer = platformer;
	}
	
	public Dan getPlatformer()
	{
		return platformer;
	}
	
	public int getWindowWidth()
	{
		return platformer.getWindowWidth();
	}
	
	public int getWindowHeight()
	{
		return platformer.getWindowHeight();
	}
	
	public Input getInputs()
	{
		return platformer.getInputs();
	}
	
	public StartState getStartState()
	{
		return platformer.getStartState();
	}
	
	public MenuState getMenuState()
	{
		return platformer.getMenuState();
	}
	
	public SettingsState getSettingsState()
	{
		return platformer.getSettingsState();
	}
	
	public TestLevelState getTestLevelState()
	{
		return platformer.getTestLevelState();
	}
	
	public void setTestLevelState(TestLevelState state)
	{
		platformer.setTestLevelState(state);
	}
	
	public World getWorld()
	{
		return State.getLevelState().getWorld();
	}
	
	public Camera getCamera()
	{
		return platformer.getCamera();
	}
}