package de.neuwirthinformatik.Alexander.gl.obejct;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.util.vector.Matrix4f;

public abstract class Object
{
	public float[] data = new float[]{	0,0,0,		//pos
										0,0,0,		//rotation
										1,1,1,		//scale
										255,255,255,		//color
										0.15F,0.15F,0.15F,1,	//ambient
										1,1,1,1,	//diffuse
										0,0,0,1,	//spekular
										0,0,0,1,	//emission
										0,0,0,0,	//texture
										};
	public Object()
	{
		
	}
	
	public Object(Object o)
	{
		setArray(o.getArray());
	}
	
	public float[] getArray()
	{
		return data;
	}
	
	public void setArray(float[] f)
	{
		if(f.length != data.length)return;
		System.arraycopy(f, 0, data, 0, f.length);
	}
}
