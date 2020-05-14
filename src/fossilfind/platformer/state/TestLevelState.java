package fossilfind.platformer.state;

import java.awt.Graphics;

import fossilfind.platformer.graphic.Assets;

public class TestLevelState extends LevelState
{	
	public TestLevelState()
	{
		super("src/res/maps/testmap1.map");
	}
	
	@Override
	public void tick()
	{
		world.tick();
	}
	
	@Override
	public void render(Graphics g)
	{
		g.drawImage(Assets.mountains, 0, 0, 1920, 1080, null);
		
		world.render(g);
	}
}