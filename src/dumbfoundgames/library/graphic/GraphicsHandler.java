package dumbfoundgames.library.graphic;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * A helper class to handle graphical things.
 * @author FossilFind
 */
public class GraphicsHandler
{
	/**
	 * Gets a font from a {@code .ttf} file.
	 * @param path The file path.
	 * @param size The size of the font.
	 * @return A {@link Font} from the specified file path.
	 */
	public static Font loadFont(String path, float size)
	{
		try 
		{
			return Font.createFont(Font.TRUETYPE_FONT, new File(path)).deriveFont(Font.PLAIN, size);
		} 
		catch (FontFormatException | IOException e) 
		{
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
	/**
	 * Makes a new {@link BufferedImage} from the specified {@code path}.
	 * @param path The image path.
	 * @return A {@link BufferedImage} containing the image at the specified {@code path}.
	 * @throws IllegalArgumentException if input is null.
	 * @throws IOExeption if an error occurs during reading or when notable to create required ImageInputStream.
	 */
	public static BufferedImage loadImage(String path)
	{
		BufferedImage img = null;
		try 
		{
			img = ImageIO.read(new File(path));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			System.exit(1);
		}
		return img;
	}
	
	/**
	 * Draws a string on to the screen.
	 * @param g A {@link Graphics} object to draw with.
	 * @param text The text to be drawn.
	 * @param xPos The x position to draw at.
	 * @param yPos The y position to draw at.
	 * @param centered Should the text be centered at the coordinates.
	 * @param c The color to draw the text in.
	 * @param font The font of the text.
	 */
	public static void drawString(Graphics g, String text, int xPos, int yPos, boolean centered, Color c, Font font)
	{
		g.setColor(c);
		g.setFont(font);
		int x = xPos;
		int y = yPos;
		if(centered)
		{
			FontMetrics fm = g.getFontMetrics(font);
			x = xPos - fm.stringWidth(text) / 2;
			y = (yPos - fm.getHeight() / 2) + fm.getAscent();
		}
		g.drawString(text, x, y);
	}
}