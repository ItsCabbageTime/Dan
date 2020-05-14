package fossilfind.platformer.state;

import fossilfind.platformer.world.World;

public abstract class LevelState extends State
{
	protected World world;
	
	public LevelState(String worldFilePath)
	{
		world = new World(worldFilePath);
	}
	
	public World getWorld()
	{
		return world;
	}
}