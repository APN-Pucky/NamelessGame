package namelessgame;
import java.util.List;


public class World 
{
	
	private Quad[] quads;
	
	public World(List<Integer> ints, int sizeofrow)
	{		
		if(ints.size()%sizeofrow != 0)
		{
			int tmp = ints.size();
			for(int i = 0; i < sizeofrow-(tmp%sizeofrow);i++)
			{
				ints.add(0);
			}
		}
		
		quads = new Quad[ints.size() ];
		int x = 0;
		int z = 0;
		int count = -1;
		for(int i : ints)
		{
			count++;
			quads[count] = new Quad(x,(float)i/2,z,1,i,1,0,0,0,5,0,5);
			x++;		
			if(x >= sizeofrow)
			{
				x = 0;
				z++;
			}
		}
		for(Quad quad : quads)
		{
			quad.init();
		}
	}
	
	public void draw()
	{
		for(Quad quad : quads)
		{
			quad.draw();
		}
	}
}
