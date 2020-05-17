package dumbfoundgames.dan;

public class Launcher
{
	private static final Dan PLATFORMER = new Dan("DAN");
	public static final Handler HANDLER = new Handler(PLATFORMER);
	
	public static void main(String[] args)
	{
		PLATFORMER.start();
	}
}