package dumbfoundgames.dan.entity.creature;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import dumbfoundgames.dan.Launcher;
import dumbfoundgames.dan.graphic.Assets;
import dumbfoundgames.library.graphic.Animation;

public class Player extends Creature
{
	private Animation walkRight, walkLeft, idle;
	
	public Player(float x, float y)
	{
		super(x, y, 115, 140);
		
		walkRight = new Animation(100, Assets.gilbertWalkRight);
		walkLeft = new Animation(100, Assets.gilbertWalkLeft);
		idle = new Animation(10000, Assets.gilbertIdle);
	}

	@Override
	public void tick()
	{
		getInputs();
		move();
		Launcher.HANDLER.getCamera().centerOnEntity(this);
		walkRight.tick();
		walkLeft.tick();
		idle.tick();
	}

	@Override
	public void render(Graphics g)
	{
		if(xMove > 0) g.drawImage(walkRight.getCurrentFrame(), (int) (x - Launcher.HANDLER.getCamera().getXOffset()), (int) (y - Launcher.HANDLER.getCamera().getYOffset()), width, height, null);
		else if(xMove < 0) g.drawImage(walkLeft.getCurrentFrame(), (int) (x - Launcher.HANDLER.getCamera().getXOffset()), (int) (y - Launcher.HANDLER.getCamera().getYOffset()), width, height, null);
		else g.drawImage(idle.getCurrentFrame(), (int) (x - Launcher.HANDLER.getCamera().getXOffset()), (int) (y - Launcher.HANDLER.getCamera().getYOffset()), width, height, null);
	}

	@Override
	public void die()
	{
		active = false;
	}
	
	private void getInputs()
	{
		xMove = 0;
		
		if(Launcher.HANDLER.getInputs().keys[KeyEvent.VK_W] && !jumping && !falling) jumping = true;
		if(Launcher.HANDLER.getInputs().keys[KeyEvent.VK_A]) xMove += -speed;
		if(Launcher.HANDLER.getInputs().keys[KeyEvent.VK_D]) xMove += speed;
	}
}