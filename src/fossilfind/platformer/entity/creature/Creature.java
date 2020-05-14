package fossilfind.platformer.entity.creature;

import fossilfind.platformer.Launcher;
import fossilfind.platformer.block.Block;
import fossilfind.platformer.entity.Entity;

public abstract class Creature extends Entity
{
	public static final float DEFUALTSPEED = 6, DEFUALTJUMPSPEED = 8, DEFUALTFALLSPEED = 8;
	public static final int DEFUALTSIZE = 64;
	
	protected float speed, jumpSpeed, fallSpeed;
	protected float xMove, jumpMove, fallMove;
	protected boolean jumping, falling;
	
	public Creature(float x, float y, int width, int height)
	{
		super(x, y, width, height);
		
		speed = DEFUALTSPEED;
		jumpSpeed = DEFUALTJUMPSPEED;
		fallSpeed = DEFUALTFALLSPEED;
		xMove = 0;
		jumpMove = jumpSpeed;
		fallMove = 0.1f;
	}
	
	public void move()
	{
		moveX();
		moveY();
	}
	
	public void moveX()
	{	
		if(xMove > 0)
		{
			int x = (int) (this.x + xMove + bounds.x + bounds.width) / Block.BLOCKSIZE;
			if(!entityBlockCollision(x, (int) (y + bounds.y) / Block.BLOCKSIZE) && !entityBlockCollision(x, (int) (y + bounds.y + bounds.height) / Block.BLOCKSIZE)) this.x += xMove;
			else this.x = x * Block.BLOCKSIZE - bounds.x - bounds.width - 1;
		}
		
		if(xMove < 0)
		{
			int x = (int) (this.x + xMove + bounds.x) / Block.BLOCKSIZE;
			if(!entityBlockCollision(x, (int) (y + bounds.y) / Block.BLOCKSIZE) && !entityBlockCollision(x, (int) (y + bounds.y + bounds.height) / Block.BLOCKSIZE)) this.x += xMove;
			else this.x = x * Block.BLOCKSIZE + Block.BLOCKSIZE - bounds.x;
		}
	}
	
	public void moveY()
	{	
		if(jumping)
		{
			int y = (int) (this.y + jumpMove + bounds.y) / Block.BLOCKSIZE;
			if(!entityBlockCollision((int) (this.x + bounds.x) / Block.BLOCKSIZE, y) && !entityBlockCollision((int) (this.x + bounds.x + bounds.width) / Block.BLOCKSIZE, y))
			{
				this.y -= jumpMove;
				jumpMove -= 0.2f;
				
				if(jumpMove <= 0)
				{
					jumpMove = jumpSpeed;
					jumping = false;
					falling = true;
				}
			}
			else
			{
				this.y = y * Block.BLOCKSIZE + Block.BLOCKSIZE + bounds.y;
				jumping = false;
				falling = true;
			}
		}
		
		if(falling)
		{
			int y = (int) (this.y + fallMove + bounds.y + bounds.height) / Block.BLOCKSIZE;
			if(!entityBlockCollision((int) (this.x + bounds.x) / Block.BLOCKSIZE, y) && !entityBlockCollision((int) (this.x + bounds.x + bounds.width) / Block.BLOCKSIZE, y))
			{
				this.y += fallMove;
				
				if(fallMove < fallSpeed) fallMove += 0.2f;
			}
			else
			{
				this.y = y * Block.BLOCKSIZE - bounds.y - bounds.height - 1;
				falling = false;
			}
		}
		
		if(!entityBlockCollision((int) (this.x + bounds.x) / Block.BLOCKSIZE, (int) (this.y + fallMove + bounds.y + bounds.height) / Block.BLOCKSIZE) && !entityBlockCollision((int) (this.x + bounds.x + bounds.width) / Block.BLOCKSIZE, (int) (this.y + fallMove + bounds.y + bounds.height) / Block.BLOCKSIZE) && !jumping) falling = true;
		
		if(!falling) 
		{
			fallMove = 0.1f;
		}
	}
	
	protected boolean entityBlockCollision(int x, int y)
	{
		return Launcher.HANDLER.getWorld().getBlock(x, y).isSolid();
	}
}