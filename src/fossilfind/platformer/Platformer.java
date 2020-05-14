package fossilfind.platformer;

import java.awt.Graphics;

import fossilfind.library.engine.Engine;
import fossilfind.library.graphic.GraphicsHandler;
import fossilfind.platformer.graphic.Assets;
import fossilfind.platformer.graphic.Camera;
import fossilfind.platformer.input.Input;
import fossilfind.platformer.state.MenuState;
import fossilfind.platformer.state.SettingsState;
import fossilfind.platformer.state.StartState;
import fossilfind.platformer.state.State;
import fossilfind.platformer.state.TestLevelState;

public class Platformer extends Engine
{
	private Input inputs;
	private Camera camera;
	private StartState startState;
	private MenuState menuState;
	private SettingsState settingsState;
	private TestLevelState testLevelState;
	
	private boolean initialized = false;
	
	protected Platformer(String windowTitle)
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