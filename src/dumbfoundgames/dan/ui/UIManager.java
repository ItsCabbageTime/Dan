package dumbfoundgames.dan.ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UIManager
{
	private ArrayList<UIObject> objects;
	
	public UIManager()
	{
		objects = new ArrayList<UIObject>();
	}
	
	public void tick()
	{
		for(UIObject o : objects) o.tick();
	}
	
	public void render(Graphics g)
	{
		for(UIObject o : objects) o.render(g);
	}
	
	public void onMouseMoved(MouseEvent e)
	{
		for(UIObject o : objects) o.onMouseMoved(e);
	}
	
	public void onMouseDragged()
	{
		for(UIObject o : objects) o.onMouseDragged();
	}
	
	public void onMouseReleased()
	{
		for(UIObject o : objects) o.onMouseReleased();
	}
	
	public void addObject(UIObject o)
	{
		objects.add(o);
	}
	
	public void removeObject(UIObject o)
	{
		objects.remove(o);
	}
}