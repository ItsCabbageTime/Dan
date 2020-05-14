package fossilfind.platformer.ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public abstract class UIObject
{
	protected float x, y;
	protected int width, height;
	protected Rectangle bounds;
	protected boolean hovering = false;
	
	public UIObject(float x, float y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		bounds = new Rectangle((int) x, (int) y, width, height);
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public abstract void onClick();
	
	public abstract void onDrag();
	
	public void onMouseMoved(MouseEvent e)
	{
		if(bounds.contains(e.getX(), e.getY())) hovering = true;
		else hovering = false;
	}
	
	public void onMouseDragged()
	{
		if(hovering) onDrag();
	}
	
	public void onMouseReleased()
	{
		if(hovering) onClick();
	}
	
	public float getX()
	{
		return x;
	}
	
	public float getY()
	{
		return y;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public boolean isHovering()
	{
		return hovering;
	}
}