package de.neuwirthinformatik.Alexander.gl.viewport;

import static org.lwjgl.util.glu.GLU.gluOrtho2D;

import java.awt.Dimension;

public class OrthoViewport extends Viewport
{
	private float left,right,bottom,top;
	public OrthoViewport(int x, int y, int width, int height, float left, float right, float bottom, float top) 
	{
		super(x, y, width,height);
		this.left =left;
		this.right = right;
		this.top = top;
		this.bottom = bottom;
	}

	public OrthoViewport(int x, int y, Dimension d, float left, float right, float bottom, float top) 
	{
		this(x, y, d.width,d.height, left,right,bottom,top);
	}
	
	@Override
	public void apply()
	{
		super.apply();
		gluOrtho2D(left,right,top,bottom);
	}

}
