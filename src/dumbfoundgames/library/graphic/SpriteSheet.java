package dumbfoundgames.library.graphic;

import java.awt.image.BufferedImage;

/**
 * Handles an image that holds many different images with in it in a grid-like fashion.
 * @author FossilFind
 */
public class SpriteSheet
{
	private BufferedImage image;
	
	public final int gridSizeX;
	public final int gridSizeY;
	
	/**
	 * Handles an image that holds many different images with in it in a grid-like fashion.
	 * @param image The grid-like image.
	 * @param gridSizeX The size, in pixels, of a grid on the image within the X coordinate.
	 * @param gridSizeY The size, in pixels, of a grid on the image within the Y coordinate.
	 */
	public SpriteSheet(BufferedImage image, int gridSizeX, int gridSizeY)
	{
		this.image = image;
		this.gridSizeX = gridSizeX;
		this.gridSizeY = gridSizeY;
	}
	
	/**
	 * Gets a grid section of the {@code SpriteSheet}.
	 * @param x X coordinate of the grid square.
	 * @param y Y coordinate of the grid square.
	 * @param width The width of the section in grid squares.
	 * @param height The height of the grid section in grid squares.
	 * @return A sub-section {@link BufferedImage} of the {@code SpriteSheet}.
	 */
	public BufferedImage crop(int x, int y, int width, int height)
	{
		return image.getSubimage(x * gridSizeX, y * gridSizeY, width * gridSizeX, height * gridSizeY);
	}
}