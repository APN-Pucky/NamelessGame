package de.neuwirthinformatik.Alexander.gl.obejct.GL;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import de.neuwirthinformatik.Alexander.gl.obejct.Object;

public class LLSphereLineGL extends SphereGL
{
	public final static ArrayList<Float> x = new ArrayList<Float>();
	public final static ArrayList<Float> y = new ArrayList<Float>();
	public final static ArrayList<Float> z = new ArrayList<Float>();
	public LLSphereLineGL(Object o) 
	{
		super(o);
	}
	
	@Override
	public void render() 
	{
		super.render();
		GL11.glColor3f(0, 100, 0);
		GL11.glBegin(GL11.GL_LINE_STRIP);
			int length = z.size();
			for(int i = 0; i< length;i++)
			{
				GL11.glVertex2f(x.get(i), y.get(i));
			}
		GL11.glEnd();
	}

}
