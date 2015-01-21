package de.neuwirthinformatik.Alexander.gl.obejct.GL;

import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glScalef;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.util.glu.GLU.gluPerspective;

import org.lwjgl.opengl.Display;

import de.neuwirthinformatik.Alexander.gl.obejct.InitLevel;
import de.neuwirthinformatik.Alexander.gl.obejct.Object;
import de.neuwirthinformatik.Alexander.gl.obejct.ObjectGL;

public class PlayerGL extends ObjectGL
{
	private static boolean init = false;
	
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

	
	@Override
	public void init() 
	{
		if(!init)
		{
			init = true;
			//code
			gluPerspective(30, (float)Display.getDesktopDisplayMode().getWidth() / (float)Display.getDesktopDisplayMode().getHeight(), 0.002F, 200F);
		}
	}
	@Override
	public int getInitLevel()
	{
		return InitLevel.PERSPECTIVE;
	}
}
