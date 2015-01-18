package de.neuwirthinformatik.Alexander.gl.projection;

import static org.lwjgl.opengl.GL11.glMultMatrix;

import java.nio.FloatBuffer;

public class Projection 
{
	private float[] matrix = new float[16];
	private FloatBuffer fl = FloatBuffer.wrap(matrix);
	
	public Projection(float[] mat)
	{
		matrix = mat;
	}
	
	public void apply()
	{
		glMultMatrix(fl);
	}
}
