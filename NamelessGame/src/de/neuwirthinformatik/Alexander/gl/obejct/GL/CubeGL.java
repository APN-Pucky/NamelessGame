package de.neuwirthinformatik.Alexander.gl.obejct.GL;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glVertex3f;
import de.neuwirthinformatik.Alexander.gl.obejct.InitLevel;
import de.neuwirthinformatik.Alexander.gl.obejct.Object;
import de.neuwirthinformatik.Alexander.gl.obejct.ObjectGL;
import de.neuwirthinformatik.Alexander.gl.obejct.Renderable;

public class CubeGL extends ObjectGL implements Renderable
{
	private static boolean init = false;
	
	public CubeGL(Object o)
	{
		super(o);
	}

	@Override
	public void render() 
	{
		glPushMatrix();
			applyData();
			glBegin(GL_QUADS);
 	       	
				
				glVertex3f(0,0,-1);	    
				glVertex3f(-1,0,-1);		    
				glVertex3f(-1,-1,-1);		    
				glVertex3f(0,-1,-1);
				
	    		glVertex3f(0,0,0);	    
	    		glVertex3f(-1,0,0);		    
	    		glVertex3f(-1,-1,0);		    
	    		glVertex3f(0,-1,0);
	    		
	    		glVertex3f(0,-1,0);		    
	    		glVertex3f(-1,-1,0);	
	    		glVertex3f(-1,-1,-1);
	    		glVertex3f(0,-1,-1);	
	    		
	    		glVertex3f(0,0,0);		    
	    		glVertex3f(-1,0,0);	
	    		glVertex3f(-1,0,-1);
	    		glVertex3f(0,0,-1);
	    		
	    		glVertex3f(-1,0,0);		    
	    		glVertex3f(-1,-1,0);	
	    		glVertex3f(-1,-1,-1);
	    		glVertex3f(-1,0,-1);	
	    		
	    		glVertex3f(0,0,0);		    
	    		glVertex3f(0,-1,0);	
	    		glVertex3f(0,-1,-1);
	    		glVertex3f(0,0,-1);
	    		
	    	
	    	glEnd();

		glPopMatrix();
	}
	
	@Override
	public void init() 
	{
		if(!init)
		{
			init = true;
			//code
			
		}
	}
	
	@Override
	public int getInitLevel()
	{
		return InitLevel.PREFRAME;
	}
}
