package de.neuwirthinformatik.Alexander.gl.threads;

import java.util.Queue;

import de.neuwirthinformatik.Alexander.gl.GLGlobal;
import de.neuwirthinformatik.Alexander.gl.obejct.Drawable;
import de.neuwirthinformatik.Alexander.gl.obejct.InitLevel;
import de.neuwirthinformatik.Alexander.gl.obejct.Initable;
import de.neuwirthinformatik.Alexander.gl.obejct.Renderable;
import de.neuwirthinformatik.Alexander.gl.obejct.Updateable;

public class UpdateThread extends SyncThread
{
	
	public void run()
	{
		int j = 0;
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
			rs.clear();
			Updateable[] ua = GLGlobal.getUpdates();
			for(int i = 0; i < ua.length;i++)
			{
				Updateable u = ua[i];
				u.update(getDelta());
			}
			Drawable[] da = GLGlobal.getDraws();
			for(int i = 0; i < da.length;i++)
			{
				Drawable d = da[i];
				rs.add(d.draw());
			}
			GLGlobal.setCurrentRenderStatus(urs);
			sync(240);
		}
	}
}
