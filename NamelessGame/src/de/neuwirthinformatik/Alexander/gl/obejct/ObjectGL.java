package de.neuwirthinformatik.Alexander.gl.obejct;

import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glScalef;
import static org.lwjgl.opengl.GL11.glTranslatef;


public abstract class ObjectGL extends Object implements Renderable
{
	
	public ObjectGL()
	{
		super();
	}
	
	public ObjectGL(Object o)
	{
		super(o);
	}
	
	public void applyData()
	{
		glColor3f(data[9],data[10],data[11]);
		glTranslatef(data[0], data[1], data[2]);
		glRotatef(data[3], 1, 0, 0);
        glRotatef(data[4], 0, 1, 0);
        glRotatef(data[5], 0, 0, 1);
        glScalef(data[6],data[7],data[8]);
	}
	
	public abstract void render();
}
