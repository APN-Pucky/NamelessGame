package de.neuwirthinformatik.Alexander.gl.obejct.GL;

import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glScalef;
import static org.lwjgl.opengl.GL11.glTranslatef;
import de.neuwirthinformatik.Alexander.gl.obejct.Object;
import de.neuwirthinformatik.Alexander.gl.obejct.ObjectGL;

public class PlayerGL extends ObjectGL
{
	public PlayerGL(Object o)
	{
		super();
		setArray(o.getArray());
	}
	
	@Override
	public void render() 
	{
		glRotatef(data[3], 1, 0, 0);
        glRotatef(data[4], 0, 1, 0);
        glRotatef(data[5], 0, 0, 1);
		glTranslatef(data[0], data[1], data[2]);
	}

}
