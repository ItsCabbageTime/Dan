package dumbfoundgames.dan.entity;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity
{
	public static final int DEFUALTHEALTH = 3;
	
	protected float x, y;
	protected int width, height, health;
	protected boolean active;
	
	protected Rectangle bounds;
	
	public Entity(float x, float y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		health = DEFUALTHEALTH;
		active = true;
		
		bounds = new Rectangle(0, 0, width, height);
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public abstract void die();
	
	public void hurt(int amt)
	{
		health -= amt;
		if(health <= 0)
		{
			active = false;
			die();
		}
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
	
	public int getHealth()
	{
		return health;
	}
	
	public boolean isActive()
	{
		return active;
	}
}