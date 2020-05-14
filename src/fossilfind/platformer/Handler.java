package fossilfind.platformer;

import fossilfind.platformer.graphic.Camera;
import fossilfind.platformer.input.Input;
import fossilfind.platformer.state.MenuState;
import fossilfind.platformer.state.SettingsState;
import fossilfind.platformer.state.StartState;
import fossilfind.platformer.state.State;
import fossilfind.platformer.state.TestLevelState;
import fossilfind.platformer.world.World;

public class Handler
{
	private Platformer platformer;
	
	public Handler(Platformer platformer)
	{
		this.platformer = platformer;
	}
	
	public Platformer getPlatformer()
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