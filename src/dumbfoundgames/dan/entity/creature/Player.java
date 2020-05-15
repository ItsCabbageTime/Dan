package dumbfoundgames.dan.entity.creature;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import dumbfoundgames.dan.Launcher;
import dumbfoundgames.dan.graphic.Assets;

public class Player extends Creature
{
	public Player(float x, float y)
	{
		super(x, y, DEFUALTSIZE, DEFUALTSIZE);
	}

	@Override
	public void tick()
	{
		getInputs();
		move();
		Launcher.HANDLER.getCamera().centerOnEntity(this);
	}

	@Override
	public void render(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillRect((int) (x - Launcher.HANDLER.getCamera().getXOffset()), (int) (y - Launcher.HANDLER.getCamera().getYOffset()), width, height);
		g.setColor(new Color(0, 0, 0, 200));
		if(Launcher.HANDLER.getInputs().keys[KeyEvent.VK_Q]) g.drawImage(Assets.characterSelect, (int) (x + width / 2 - 128 - Launcher.HANDLER.getCamera().getXOffset()), (int) (y + height / 2 - 128 - Launcher.HANDLER.getCamera().getYOffset()), null);
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