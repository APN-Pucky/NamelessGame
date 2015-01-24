package de.neuwirthinformatik.Alexander.gl.threads;

public class SyncThread extends Thread
{
	private long cur;
	private long prev;
	private float nanos; 
	private float delta;
	protected boolean running = true;
	boolean init = true;
	
	public void sync(float fps)
	{
		if(init)
		{
			init(fps);
		}
		else
		{
			calcDelta();
			float diff = nanos-delta;
			if(diff>0)
			{
				try 
				{
					sleep(Math.round(diff));
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
				delta = nanos;
			}
				
		}
	}
	
	public float getDelta()
	{
		return delta;
	}
	
	public void init(float fps)
	{
		init = false;
		nanos = 1000/fps;
		prev = System.currentTimeMillis();
	}
	
	public void calcDelta()
	{
		cur = System.currentTimeMillis();
		delta = cur-prev;
		prev = cur;
	}
	
	public void stopExec()
	{
		running = false;
	}
}
