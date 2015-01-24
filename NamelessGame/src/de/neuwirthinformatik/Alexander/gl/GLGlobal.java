package de.neuwirthinformatik.Alexander.gl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import org.lwjgl.opengl.Display;

import de.neuwirthinformatik.Alexander.gl.obejct.Drawable;
import de.neuwirthinformatik.Alexander.gl.obejct.InitLevel;
import de.neuwirthinformatik.Alexander.gl.obejct.Initable;
import de.neuwirthinformatik.Alexander.gl.obejct.Renderable;
import de.neuwirthinformatik.Alexander.gl.obejct.Updateable;
import de.neuwirthinformatik.Alexander.gl.threads.RenderThread;
import de.neuwirthinformatik.Alexander.gl.threads.UpdateThread;

public class GLGlobal 
{
	private static UpdateThread ut;
	private static RenderThread rt;
	private static Updateable[] updates = new Updateable[1];
	private static Initable[] inits = new Initable[1];
	private static Drawable[] draws = new Drawable[1];
	private static Queue<Renderable> rs0,rs1,rs2;
	private static int crs=2,rrs=2;
	public static Object sync_swap;
	
	public static void init(GLGlobalParam[] m)
	{
		splitParam(m);
		ut = new UpdateThread();
		rt = new RenderThread();
		rs0 = new LinkedList<Renderable>();
		rs1 = new LinkedList<Renderable>();
		rs2 = new LinkedList<Renderable>();
		//-- Init
	  	GLGlobal.init(InitLevel.FIRST);
	  	//## Init
	}
	
	public static void splitParam(GLGlobalParam[] m)
	{
		ArrayList<Updateable> update = new ArrayList<Updateable>();
		ArrayList<Drawable> draw = new ArrayList<Drawable>();
		ArrayList<Initable> init = new ArrayList<Initable>();
		for(GLGlobalParam mx : m)
		{
			if(mx instanceof Updateable)
			{
				update.add((Updateable) mx);
			}
			if(mx instanceof Initable)
			{
				init.add((Initable) mx);
			}
			if(mx instanceof Drawable)
			{
				draw.add((Drawable) mx);
			}
		}
		updates = (Updateable[])update.toArray(updates);
		inits = (Initable[])init.toArray(inits);
		draws = (Drawable[])draw.toArray(draws);
	}
	
	public static Drawable[] getDraws()
	{
		return draws;
	}
	
	public static Initable[] getInits()
	{
		return inits;
	}
	
	public static Updateable[] getUpdates()
	{
		return updates;
	}
	
	public static int getCurrentRenderStatus()
	{
		return crs;
	}
	
	public static int getRenderRenderStatus()
	{
		return rrs;
	}
	
	public static void setCurrentRenderStatus(int i)
	{
		crs = i;
	}
	
	public static void setRenderRenderStatus(int i)
	{
		rrs = i;
	}
	
	public static Queue<Renderable> getRenderStatus(int i)
	{
		switch(i)
		{
			case(0):return rs0;
			case(1):return rs1;
			case(2):return rs2;
			default:return null;
		}
	}
	
	public static void init(int initlevel)
	{
		Initable[] ia = GLGlobal.getInits();
		for(int i = 0; i < ia.length;i++)
		{
			Initable init = ia[i];
			if(init.getInitLevel() == initlevel)init.init();
			
		}
	}
	
	public static void start()
	{
		rt.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ut.start();
		
	}
	
	public static void stop()
	{
		ut.stopExec();
		rt.stopExec();
	}
	
	public static void clean()
	{
		Display.destroy();
	}
}
