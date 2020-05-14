package fossilfind.platformer.block;

public class AirBlock extends Block
{
	public AirBlock(int x, int y)
	{
		super(0, x, y);
	}
	
	@Override
	public boolean isSolid()
	{
		return false;
	}
}