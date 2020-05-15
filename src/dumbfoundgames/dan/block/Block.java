package dumbfoundgames.dan.block;

import java.awt.Graphics;

import dumbfoundgames.dan.Launcher;
import dumbfoundgames.dan.graphic.Assets;

public class Block
{	
	public static final int BLOCKSIZE = 128;
	
	protected int id, x, y;
	
	public Block(int id, int x, int y)
	{
		this.id = id;
		this.x = x;
		this.y = y;
	}
	
	public void tick()
	{
		
	}
	
	public void render(Graphics g)
	{
		if(id == 0);
		else if(id == 1) g.drawImage(Assets.brick, x * BLOCKSIZE - (int) Launcher.HANDLER.getCamera().getXOffset(), y * BLOCKSIZE - (int) Launcher.HANDLER.getCamera().getYOffset(), BLOCKSIZE, BLOCKSIZE, null);
	}
	
	public boolean isSolid()
	{
		if(id == 0) return false;
		return true;
	}
}