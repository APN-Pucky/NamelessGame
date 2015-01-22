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
}
