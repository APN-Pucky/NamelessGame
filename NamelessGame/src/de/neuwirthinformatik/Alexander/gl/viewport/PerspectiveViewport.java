package de.neuwirthinformatik.Alexander.gl.viewport;

import static org.lwjgl.util.glu.GLU.gluPerspective;

import java.awt.Dimension;

public class PerspectiveViewport extends Viewport
{
	private float fovy,near,far;
	public PerspectiveViewport(int x, int y, int width, int height, float fovy, float near, float far) 
	{
		super(x, y, width,height);
		this.fovy = fovy;
		this.far = far;
		this.near = near;
	}

	public PerspectiveViewport(int x, int y, Dimension d, float fovy, float near, float far) 
	{
		this(x, y, d.width,d.height, fovy,near, far);
	}
	
	@Override
	public void init()
	{
		gluPerspective(fovy, (float)getWidth() / (float)getHeight(), near, far);
	}
	
	@Override
	public void apply()
	{
		super.apply();
	}
}
