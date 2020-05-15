package dumbfoundgames.dan.state;

import java.awt.Graphics;

public abstract class State
{
	private static State currentState = null;
	private static LevelState currentLevelState = null;
	
	public static State getState()
	{
		return currentState;
	}
	
	public static void setState(State state)
	{
		currentState = state;
		if(state instanceof LevelState) currentLevelState = (LevelState) state;
	}
	
	public static LevelState getLevelState()
	{
		return currentLevelState;
	}
	
	public State()
	{
		
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
}