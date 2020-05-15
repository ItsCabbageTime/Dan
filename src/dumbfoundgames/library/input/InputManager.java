package dumbfoundgames.library.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

/**
 * Handles all of the mouse and keyboard inputs.
 * @author FossilFind
 */
public class InputManager implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener
{
	public boolean[] keys = new boolean[256];
	public boolean[] mouseButtons = new boolean[4];
	public int mouseX, mouseY;
	public int mouseWheelRotation;
	
	/**
	 * Handles all of the mouse and keyboard inputs.
	 */
	public InputManager() {}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) 
	{
		mouseWheelRotation = e.getWheelRotation();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {}
	
	@Override
	public void mouseMoved(MouseEvent e) 
	{
		mouseX = e.getX();
		mouseY = e.getX();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {}
	
	@Override
	public void mousePressed(MouseEvent e) 
	{
		mouseButtons[e.getButton()] = true;
	}
	
	@Override
	public void mouseReleased(MouseEvent e) 
	{
		mouseButtons[e.getButton()] = false;
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {}
	
	@Override
	public void mouseExited(MouseEvent e) {}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	
	@Override
	public void keyPressed(KeyEvent e) 
	{
		keys[e.getKeyCode()] = true;
	}
	
	@Override
	public void keyReleased(KeyEvent e) 
	{
		keys[e.getKeyCode()] = false;
	}
}