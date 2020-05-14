package fossilfind.library.engine;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/**
 * A class that handles game looping and makes a {@link Window} object on it's own thread.
 * @author FossilFind
 */
public abstract class Engine implements Runnable
{
	protected Window window;
	private int windowWidth, windowHeight;
	
	private Thread thread;
	private boolean running = false;
	private long fps;
	protected int targetFps;
	
	private BufferStrategy strategy;
	private Graphics g;
	
	/**
	 * A class that handles game looping and makes a {@link Window} object on it's own thread.
	 * @param windowTitle The text displayed at the top of the screen.
	 */
	protected Engine(String windowTitle)
	{
		windowWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		windowHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		window = new Window(windowTitle);
		
		targetFps = 60;
	}
	
	/**
	 * A class that handles game looping and makes a {@link Window} object on it's own thread.
	 * @param windowTitle The text displayed at the top of the screen.
	 * @param icon The image displayed on the window icon.
	 */
	protected Engine(String windowTitle, BufferedImage icon)
	{
		windowWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		windowHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		window = new Window(windowTitle, icon);
		
		targetFps = 60;
	}
	
	/**
	 * Updates objects every game loop.
	 */
	public abstract void tick();
	
	/**
	 * Draws to the {@link Canvas} every game loop.
	 */
	public abstract void render(Graphics g);
	
	/**
	 * Prepares the screen for rendering.
	 */
	private void renderScreen()
	{
		strategy = window.getCanvas().getBufferStrategy();
		if(strategy == null)
		{
			window.getCanvas().createBufferStrategy(3);
			return;
		}
		g = strategy.getDrawGraphics();
		g.clearRect(0, 0, windowWidth, windowHeight);
		
		render(g);
		
		strategy.show();
		g.dispose();
	}
	
	@Override
	public void run() 
	{
		int fps = targetFps;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		long ticks = 0;
		
		while(running)
		{
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1)
			{
				tick();
				renderScreen();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000)
			{
				this.fps = ticks;
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
	}
	
	/**
	 * Starts the thread and the engine.
	 */
	public synchronized void start()
	{
		if(running) return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	/**
	 * Stops the thread and the engine.
	 */
	public synchronized void stop()
	{
		if(!running) return;
		running = false;
		
		try 
		{
			thread.join();
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * @return The frames per second in a long variable.
	 */
	public long getFPS()
	{
		return fps;
	}
	
	public int getWindowWidth()
	{
		return windowWidth;
	}
	
	public int getWindowHeight()
	{
		return windowHeight;
	}
}