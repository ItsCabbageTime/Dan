package dumbfoundgames.dan.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

import dumbfoundgames.library.graphic.GraphicsHandler;

public class UITextButton extends UIObject
{
	private String text;
	private Color color, hoveringColor;
	private boolean centered;
	private Font font;
	private ClickListener clicker;
	
	public UITextButton(float x, float y, String text, Color color, Color hoveringColor, boolean centered, Font font, ClickListener clicker)
	{
		super(x, y, (int) font.getStringBounds(text, new FontRenderContext(new AffineTransform(), true, true)).getWidth(), (int) font.getStringBounds(text, new FontRenderContext(new AffineTransform(), true, true)).getHeight());
		this.text = text;
		this.color = color;
		this.hoveringColor = hoveringColor;
		this.centered = centered;
		this.font = font;
		this.clicker = clicker;
		
		float xPos = x;
		float yPos = y;
		
		if(!centered)
		{
			xPos += new Font("Arial", Font.PLAIN, 50).getStringBounds(text, new FontRenderContext(new AffineTransform(), true, true)).getWidth() / 2;
			yPos -= new Font("Arial", Font.PLAIN, 50).getStringBounds(text, new FontRenderContext(new AffineTransform(), true, true)).getHeight() / 2;
		}
		
		bounds.x = (int) (xPos - width / 2);
		bounds.y = (int) (yPos - height / 2);
	}

	@Override
	public void tick()
	{
		
	}
		
	@Override
	public void render(Graphics g)
	{
		if(hovering) GraphicsHandler.drawString(g, text, (int) x, (int) y, centered, hoveringColor, font);
		else GraphicsHandler.drawString(g, text, (int) x, (int) y, centered, color, font);
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