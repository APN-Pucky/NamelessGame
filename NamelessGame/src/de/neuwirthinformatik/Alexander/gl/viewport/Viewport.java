package de.neuwirthinformatik.Alexander.gl.viewport;

import static org.lwjgl.opengl.GL11.glViewport;

import java.awt.Dimension;

import de.neuwirthinformatik.Alexander.gl.obejct.Initable;

public class Viewport implements Initable
{
	private int x,y,height,width;

	public Viewport(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public Viewport(int x, int y, Dimension d)
	{
		this(x,y,d.width,d.height);
	}
	
	public void init()
	{
		
	}
	
	public void apply()
	{
		glViewport(x,y,width,height);
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
}
