package dumbfoundgames.dan.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UIImageButton extends UIObject
{
	private BufferedImage image, hoveringImage;
	private ClickListener clicker;
	
	public UIImageButton(float x, float y, int width, int height, BufferedImage image, BufferedImage hoveringImage, ClickListener clicker)
	{
		super(x, y, width, height);
		this.image = image;
		this.hoveringImage = hoveringImage;
		this.clicker = clicker;
	}
	
	@Override
	public void tick()
	{
		
	}
	
	@Override
	public void render(Graphics g)
	{
		if(hovering) g.drawImage(hoveringImage, (int) x, (int) y, width, height, null);
		else g.drawImage(image, (int) x, (int) y, width, height, null);
	}
	
	@Override
	public void onClick()
	{
		clicker.onClick();
	}
	
	@Override
	public void onDrag()
	{
		
	}
}