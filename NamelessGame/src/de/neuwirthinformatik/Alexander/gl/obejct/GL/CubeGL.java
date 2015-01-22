package de.neuwirthinformatik.Alexander.gl.obejct.GL;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL15;

import de.neuwirthinformatik.Alexander.gl.GLUtil;
import de.neuwirthinformatik.Alexander.gl.obejct.InitLevel;
import de.neuwirthinformatik.Alexander.gl.obejct.Object;
import de.neuwirthinformatik.Alexander.gl.obejct.ObjectGL;
import de.neuwirthinformatik.Alexander.gl.obejct.Renderable;

public class CubeGL extends ObjectGL implements Renderable
{
	private static boolean init = false;
	private static int vertexid;
	private static int colorid;
	
	public CubeGL(Object o)
	{
		super(o);
	}

	@Override
	public void render() 
	{
		glPushMatrix();
			applyData();
			glEnableClientState(GL_VERTEX_ARRAY);
		    glBindBuffer(GL15.GL_ARRAY_BUFFER, vertexid);
		    glVertexPointer(3, GL_FLOAT, 0, 0);
		    
		    glEnableClientState(GL_COLOR_ARRAY);
		    glBindBuffer(GL15.GL_ARRAY_BUFFER, colorid);
		    glColorPointer(3, GL_FLOAT, 0, 0);
		    
		    glDrawArrays(GL_QUADS, 0, 24);
		glPopMatrix();
	}
	
	@Override
	public void init() 
	{
		if(!init)
		{
			init = true;
			//code
			
			float[] fb = new float[]{	0,0,-1,	    
										-1,0,-1,		    
										-1,-1,-1,		    
										0,-1,-1,
			
										0,0,0,	    
										-1,0,0,		    
										-1,-1,0,		    
										0,-1,0,
    		
										0,-1,0,		    
										-1,-1,0,	
										-1,-1,-1,
										0,-1,-1,	
    		
										0,0,0,		    
										-1,0,0,	
										-1,0,-1,
										0,0,-1,
    		
										-1,0,0,		    
										-1,-1,0,	
										-1,-1,-1,
										-1,0,-1,	
    		
										0,0,0,		    
										0,-1,0,	
										0,-1,-1,
										0,0,-1	};

			vertexid = glGenBuffers();
			GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vertexid);
			GL15.glBufferData(GL15.GL_ARRAY_BUFFER, GLUtil.toFloatBuffer(fb), GL15.GL_STATIC_DRAW);
			
			
			
			fb = new float[]{			0,0,255,	    
										255,0,255,		    
										255,255,255,		    
										0,255,255,
			
										0,0,0,	    
										255,0,0,		    
										255,255,0,		    
										0,255,0,
    		
										0,255,0,		    
										255,255,0,	
										255,255,255,
										0,255,255,	
    		
										0,0,0,		    
										255,0,0,	
										255,0,255,
										0,0,255,
    		
										255,0,0,		    
										255,255,0,	
										255,255,255,
										255,0,255,	
    		
										0,0,0,		    
										0,255,0,	
										0,255,255,
										0,0,255	};
			colorid = glGenBuffers();
			GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, colorid);
			GL15.glBufferData(GL15.GL_ARRAY_BUFFER, GLUtil.toFloatBuffer(fb), GL15.GL_STATIC_DRAW);
		}
	}
	
	public int getInitLevel()
	{
		return InitLevel.POSTFRAME;
	}
}
