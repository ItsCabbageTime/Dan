package fossilfind.platformer.graphic;

import fossilfind.platformer.Launcher;
import fossilfind.platformer.block.Block;
import fossilfind.platformer.entity.Entity;

public class Camera
{
	private float xOffset, yOffset;
	
	public Camera(float xOffset, float yOffset)
	{
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void centerOnEntity(Entity e)
	{
		xOffset = e.getX() - Launcher.HANDLER.getWindowWidth() / 2;
		yOffset = e.getY() - Launcher.HANDLER.getWindowHeight() / 4 * 3;
		checkBlankSpace();
	}
	
	public void checkBlankSpace()
	{
		if(xOffset < 1 * Block.BLOCKSIZE) xOffset = 1 * Block.BLOCKSIZE;
		else if(xOffset > (Launcher.HANDLER.getWorld().getWidth() - 1) * Block.BLOCKSIZE - Launcher.HANDLER.getWindowWidth()) xOffset = (Launcher.HANDLER.getWorld().getWidth() - 1) * Block.BLOCKSIZE - Launcher.HANDLER.getWindowWidth();
		
		if(yOffset < 0) yOffset = 0;
		else if(yOffset > Launcher.HANDLER.getWorld().getHeight() * Block.BLOCKSIZE - Launcher.HANDLER.getWindowHeight()) yOffset = Launcher.HANDLER.getWorld().getHeight() * Block.BLOCKSIZE - Launcher.HANDLER.getWindowHeight();
	}
	
	public void move(float xAmt, float yAmt)
	{
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace();
	}
	
	public float getXOffset()
	{
		return xOffset;
	}
	
	public void setXOffset(float xOffset)
	{
		this.xOffset = xOffset;
	}
	
	public float getYOffset()
	{
		return yOffset;
	}
	
	public void setYOffset(float yOffset)
	{
		this.yOffset = yOffset;
	}
}