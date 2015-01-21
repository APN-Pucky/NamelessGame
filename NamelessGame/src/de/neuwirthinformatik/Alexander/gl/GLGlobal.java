package de.neuwirthinformatik.Alexander.gl;

import java.util.LinkedList;
import java.util.Queue;

import org.lwjgl.opengl.Display;

import de.neuwirthinformatik.Alexander.gl.obejct.Renderable;
import de.neuwirthinformatik.Alexander.gl.obejct.Updateable;
import de.neuwirthinformatik.Alexander.gl.threads.RenderThread;
import de.neuwirthinformatik.Alexander.gl.threads.UpdateThread;

public class GLGlobal 
{
	private static UpdateThread ut;
	private static RenderThread rt;
	private static Updateable[] updates;
	private static Queue<Renderable> rs0,rs1,rs2;
	private static int crs=2,rrs=2;
	public static Object sync_swap;
	
	public static void init(Updateable[] update)
	{
		updates = update;
		ut = new UpdateThread();
		rt = new RenderThread();
		rs0 = new LinkedList<Renderable>();
		rs1 = new LinkedList<Renderable>();
		rs2 = new LinkedList<Renderable>();
		ut.init();
		//rt.init();
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
	
	public static void start()
	{
		rt.start();
		//wait for window creation
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ut.start();
	}
	
	public static void stop()
	{
		Display.destroy();
	    System.exit(0);
	}
}
