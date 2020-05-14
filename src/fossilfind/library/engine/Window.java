package fossilfind.library.engine;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

/**
 * An object that handles the window.
 * @author FossilFind
 */
public class Window 
{
	private JFrame frame;
	private Canvas canvas;
	
	private String title;
	
	/**
	 * An object that handles the window.
	 * @param title The text displayed at the top of the screen.
	 */
	public Window(String title)
	{
		this.title = title;
		
		createWindow();
	}
	
	/**
	 * An object that handles the window with an icon.
	 * @param title The text displayed at the top of the screen.
	 * @param icon The image displayed on the window icon.
	 */
	public Window(String title, BufferedImage icon)
	{
		this.title = title;
		
		createWindow(icon);
	}
	
	/**
	 * Creates the {@link JFrame} and the {@link Canvas} for the window.
	 */
	private void createWindow()
	{
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
	}
	
	/**
	 * Creates the {@link JFrame} and the {@link Canvas} for the window with an icon.
	 * @param icon The image displayed on the window icon.
	 */
	private void createWindow(BufferedImage icon)
	{
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setIconImage(icon);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
	}
	
	public Canvas getCanvas()
	{
		return canvas;
	}
	
	public JFrame getFrame()
	{
		return frame;
	}
}