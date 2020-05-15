package dumbfoundgames.library.graphic;

import java.awt.image.BufferedImage;

/**
 * Handles an image that holds many different images with in it in a grid-like fashion.
 * @author FossilFind
 */
public class SpriteSheet
{
	private BufferedImage image;
	
	public final int gridSize;
	
	/**
	 * Handles an image that holds many different images with in it in a grid-like fashion.
	 * @param image The grid-like image.
	 * @param gridSize The size, in pixels, of a grid on the image.
	 */
	public SpriteSheet(BufferedImage image, int gridSize)
	{
		this.image = image;
		this.gridSize = gridSize;
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
		return image.getSubimage(x * gridSize, y * gridSize, width * gridSize, height * gridSize);
	}
}