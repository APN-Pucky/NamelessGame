package de.neuwirthinformatik.Alexander.gl.obejct.GL;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glVertex3f;
import static org.lwjgl.opengl.GL11.*;

import de.neuwirthinformatik.Alexander.gl.obejct.Object;
import de.neuwirthinformatik.Alexander.gl.obejct.ObjectGL;
import de.neuwirthinformatik.Alexander.gl.obejct.Renderable;

public class CubeGL extends ObjectGL implements Renderable
{
	
	public CubeGL(Object o)
	{
		super();
		setArray(o.toArray());
		this.store(getFloatBuffer());
		getFloatBuffer().rewind();
	}

	@Override
	public void render() 
	{
		glPushMatrix();
			glMultMatrix(getFloatBuffer());
			
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
}
