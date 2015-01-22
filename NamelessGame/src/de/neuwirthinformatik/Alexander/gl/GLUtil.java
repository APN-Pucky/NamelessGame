package de.neuwirthinformatik.Alexander.gl;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;

public class GLUtil 
{
	public static FloatBuffer toFloatBuffer(float[] fb)
	{
		FloatBuffer buffer = BufferUtils.createFloatBuffer(fb.length);
		buffer.put(fb);
		buffer.rewind();
		return buffer;
	}
	
	public static FloatBuffer toFloatBuffer(Float[] fb)
	{
		FloatBuffer buffer = BufferUtils.createFloatBuffer(fb.length);
		for(int i = 0; i < fb.length; i++)
		{
			buffer.put((float)fb[i]);
		}
		buffer.rewind();
		return buffer;
	}
}
