package de.neuwirthinformatik.Alexander.gl.threads;

import java.util.Queue;

import de.neuwirthinformatik.Alexander.gl.GLGlobal;
import de.neuwirthinformatik.Alexander.gl.obejct.Drawable;
import de.neuwirthinformatik.Alexander.gl.obejct.Initable;
import de.neuwirthinformatik.Alexander.gl.obejct.Renderable;
import de.neuwirthinformatik.Alexander.gl.obejct.Updateable;

public class UpdateThread extends SyncThread implements Initable
{
	boolean running = true;
	
	public void run()
	{
		while(running)
		{
			int rrs = GLGlobal.getRenderRenderStatus();
			int crs = GLGlobal.getCurrentRenderStatus();
			int urs = 0;
			while(urs == crs || urs == rrs)
			{
				urs++;
			}
			Queue<Renderable> rs = GLGlobal.getRenderStatus(urs);
			Updateable[] ua = GLGlobal.getUpdates();
			for(int i = 0; i < ua.length;i++)
			{
				Updateable u = ua[i];
				u.update(getDelta());
				if(u instanceof Drawable)
				{
					Drawable d = (Drawable)u;
					rs.add(d.draw());
				}
			}
			GLGlobal.setCurrentRenderStatus(urs);
			sync(60);
		}
	}

	@Override
	public void init() 
	{
		for(Updateable u : GLGlobal.getUpdates())
		{
			if(u instanceof Initable)
			{
				((Initable)u).init();
			}
		}
	}
}
