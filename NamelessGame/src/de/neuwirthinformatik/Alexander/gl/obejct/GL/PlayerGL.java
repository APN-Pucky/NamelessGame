package de.neuwirthinformatik.Alexander.gl.obejct.GL;

import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslatef;
import de.neuwirthinformatik.Alexander.gl.obejct.Object;
import de.neuwirthinformatik.Alexander.gl.obejct.ObjectGL;

public class PlayerGL extends ObjectGL
{
	public PlayerGL(Object o)
	{
		super();
		setArray(o.toArray());
	}
	
	@Override
	public void render() 
	{
		 glRotatef(m30, 1, 0, 0);
	     glRotatef(m31, 0, 1, 0);
	     glRotatef(m32, 0, 0, 1);
	     glTranslatef(m03,m13,m23);
	}

}
