package fossilfind.library.graphic;

import java.awt.image.BufferedImage;
/**
 * Switches between the images on the {@link BufferedImage} array at the speed specified.
 * @author FossilFind
 */
public class Animation
{
	private int speed, index;
	private long lastTime, timer;
	private BufferedImage[] frames;
	
	/**
	 * Switches between the images on the {@link BufferedImage} array at the speed specified.
	 * @param speed The speed at witch the animation plays.
	 * @param frames The frames of the animation.
	 */
	public Animation(int speed, BufferedImage[] frames)
	{
		this.speed = speed;
		this.frames = frames;
		index = 0;
		timer = 0;
		lastTime = System.currentTimeMillis();
	}
	
	public void tick()
	{
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if(timer > speed)
		{
			index++;
			timer = 0;
			if(index >= frames.length) index = 0;
		}
	}
	
	/**
	 * Gets the current frame of the animation.
	 * @return A {@link BufferedImage} correlating to the current frame.
	 */
	public BufferedImage getCurrentFrame()
	{
		return frames[index];
	}
}