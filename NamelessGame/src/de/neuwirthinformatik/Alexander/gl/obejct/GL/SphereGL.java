package de.neuwirthinformatik.Alexander.gl.obejct.GL;

import java.util.ArrayList;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL11.*;

import de.neuwirthinformatik.Alexander.gl.GLUtil;
import de.neuwirthinformatik.Alexander.gl.obejct.InitLevel;
import de.neuwirthinformatik.Alexander.gl.obejct.ObjectGL;
import de.neuwirthinformatik.Alexander.gl.obejct.Object;

public class SphereGL extends ObjectGL
{

	private static boolean init = false;
	private static int vertexid;
	private static int quality = 100;
	private static int size;
	
	public SphereGL(Object o)
	{
		super(o);
	}

	@Override
	public void render() 
	{
		glPushMatrix();
			applyData();
			glEnableClientState(GL_VERTEX_ARRAY);
		    glBindBuffer(GL_ARRAY_BUFFER, vertexid);
		    glVertexPointer(3, GL_FLOAT, 0, 0);
		    
		    glDrawArrays(8, 0, size/3);
		glPopMatrix();
	}
	
	@Override
	public void init() 
	{
		if(!init)
		{
			init = true;
			//code
			Float[] fb = new Float[1];
			ArrayList<Float> fa = new ArrayList<Float>();
			for (int i = 0; i < quality; i++) {
			      float lY1 = (float)Math.sin((90 - i * 180 / quality) * 3.141592653589793D / 180.0D);
			      float lY2 = (float)Math.sin((90 - (i + 1) * 180 / quality) * 3.141592653589793D / 180.0D);

			      float lRT1 = (float)Math.cos((90 - i * 180 / quality) * 3.141592653589793D / 180.0D);
			      float lRT2 = (float)Math.cos((90 - (i + 1) * 180 / quality) * 3.141592653589793D / 180.0D);
			      for (int j = 0; j <= quality; j++) {
			        float lX = (float)Math.cos(j * 360 / quality * 3.141592653589793D / 180.0D);
			        float lZ = (float)Math.sin(j * 360 / quality * 3.141592653589793D / 180.0D);

			        fa.add(lX * 1 * lRT1);
			        fa.add( lZ * 1 * lRT1);
			        fa.add(lY1 * 1);
			        
			        fa.add(lX * 1 * lRT2);
			        fa.add(lZ * 1 * lRT2);
			        fa.add(lY2 * 1);
			      }
			    }
			fb = fa.toArray(fb);
			//
			size = fb.length;
			vertexid = glGenBuffers();
			glBindBuffer(GL_ARRAY_BUFFER, vertexid);
			
			glBufferData(GL_ARRAY_BUFFER, GLUtil.toFloatBuffer(fb), GL_STATIC_DRAW);
			
		}
	}
	
	public int getInitLevel()
	{
		return InitLevel.POSTFRAME;
	}
}
