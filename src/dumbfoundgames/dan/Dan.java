package dumbfoundgames.dan;

import java.awt.Graphics;

import dumbfoundgames.dan.graphic.Assets;
import dumbfoundgames.dan.graphic.Camera;
import dumbfoundgames.dan.input.Input;
import dumbfoundgames.dan.state.MenuState;
import dumbfoundgames.dan.state.SettingsState;
import dumbfoundgames.dan.state.StartState;
import dumbfoundgames.dan.state.State;
import dumbfoundgames.dan.state.TestLevelState;
import dumbfoundgames.library.engine.Engine;
import dumbfoundgames.library.graphic.GraphicsHandler;

public class Dan extends Engine
{
	private Input inputs;
	private Camera camera;
	private StartState startState;
	private MenuState menuState;
	private SettingsState settingsState;
	private TestLevelState testLevelState;
	
	private boolean initialized = false;
	
	protected Dan(String windowTitle)
	{
		super(windowTitle, GraphicsHandler.loadImage("src/res/textures/brick.png"));
	}
	
	private void init()
	{
		Assets.init();
		
		inputs = new Input();
		
		window.getFrame().addKeyListener(inputs);
		window.getFrame().addMouseListener(inputs);
		window.getFrame().addMouseMotionListener(inputs);
		window.getCanvas().addMouseListener(inputs);
		window.getCanvas().addMouseMotionListener(inputs);
		
		camera = new Camera(0, 0);
		
		startState = new StartState();
		menuState = new MenuState();
		settingsState = new SettingsState();
		testLevelState = new TestLevelState();
		
		State.setState(startState);
		
		initialized = true;
	}
	
	@Override
	public void tick()
	{	
		if(!initialized) init();
		
		inputs.tick();
		if(State.getState() != null) State.getState().tick();
	}
	
	@Override
	public void render(Graphics g)
	{
		if(State.getState() != null) State.getState().render(g);
	}
	
	public Input getInputs()
	{
		return inputs;
	}
	
	public StartState getStartState()
	{
		return startState;
	}
	
	public MenuState getMenuState()
	{
		return menuState;
	}
	
	public SettingsState getSettingsState()
	{
		return settingsState;
	}
	
	public TestLevelState getTestLevelState()
	{
		return testLevelState;
	}
	
	public void setTestLevelState(TestLevelState state)
	{
		testLevelState = state;
	}
	
	public Camera getCamera()
	{
		return camera;
	}
}