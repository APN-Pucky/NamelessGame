package de.neuwirthinformatik.Alexander.gl.obejct;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.util.vector.Matrix4f;

public abstract class Object extends Matrix4f
{
	FloatBuffer fl = BufferUtils.createFloatBuffer(16);
	
	public Object()
	{
		setIdentity();
	}
	
	public FloatBuffer getFloatBuffer()
	{
		return fl;
	}
	
	public float[] toArray()
	{
		return new float[]{m00,m10,m20,m30,m01,m11,m21,m31,m02,m12,m22,m32,m03,m13,m23,m33};
	}
	
	public void setArray(float[] f)
	{
		m00=f[0];m01=f[4];m02=f[8];m03=f[12];
		m10=f[1];m11=f[5];m12=f[9];m13=f[13];
		m20=f[2];m21=f[6];m22=f[10];m23=f[14];
		m30=f[3];m31=f[7];m32=f[11];m33=f[15];
	}
}
