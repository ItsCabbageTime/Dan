package fossilfind.platformer;

public class Launcher
{
	private static final Platformer PLATFORMER = new Platformer("Togetherbound");
	public static final Handler HANDLER = new Handler(PLATFORMER);
	
	public static void main(String[] args)
	{
		PLATFORMER.start();
	}
}