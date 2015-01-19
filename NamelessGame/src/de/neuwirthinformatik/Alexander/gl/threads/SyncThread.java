package de.neuwirthinformatik.Alexander.gl.threads;

public class SyncThread extends Thread
{
	private long cur;
	private long prev;
	private int millis; 
	private long delta;
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
			long diff = millis-delta;
			if(diff>0)
			{
				try 
				{
					sleep(diff);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
				
		}
	}
	
	public long getDelta()
	{
		return delta;
	}
	
	public void init(float fps)
	{
		init = false;
		millis = (int) Math.round(1000/fps);
		prev = System.currentTimeMillis();
	}
	
	public void calcDelta()
	{
		cur = System.currentTimeMillis();
		delta = cur-prev;
		prev = System.currentTimeMillis();
	}
}
