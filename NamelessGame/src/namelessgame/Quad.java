package namelessgame;
import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.util.vector.Vector3f;


public class Quad 
{
	private Vector3f angel;
	private Vector3f position;
	private Vector3f scale;
	private float red,green,blue;
	private int quadlist;
	private int linelist;
	private Vector3f[] points;
	
	public Quad(float x, float y , float z, float sizex, float sizey ,float sizez, float angelx, float angely, float angelz, float red, float green, float blue)
	{
		position = new Vector3f(x,y,z);
		angel = new Vector3f(angelx, angely, angelz);
		scale = new Vector3f(sizex, sizey, sizez);
		this.red = red;
		this.blue = blue;
		this.green = green;
		points = new Vector3f[8];
		points[0] = new Vector3f(-0.5F, -0.5F, -0.5F);
		points[1] = new Vector3f(-0.5F, 0.5F, -0.5F);
		points[2] = new Vector3f(0.5F, 0.5F, -0.5F);
		points[3] = new Vector3f(0.5F, -0.5F, -0.5F);
		
		points[4] = new Vector3f(-0.5F, -0.5F, 0.5F);
		points[5] = new Vector3f(-0.5F, 0.5F, 0.5F);
		points[6] = new Vector3f(0.5F, 0.5F, 0.5F);
		points[7] = new Vector3f(0.5F, -0.5F, 0.5F);
		
	}
	
	public void init()
	{
		quadlist = glGenLists(1);
		linelist = glGenLists(1);
		glNewList(linelist, GL_COMPILE);
	    {
	    	glColor3f(0,0,0);
	    		
	    	glBegin(GL_LINE_STRIP);
	    		glVertex3f(points[0].x,points[0].y,points[0].z);	    
	    		glVertex3f(points[1].x,points[1].y,points[1].z);	    	
	    		glVertex3f(points[2].x,points[2].y,points[2].z);		    
		    	glVertex3f(points[3].x,points[3].y,points[3].z);
		    	glVertex3f(points[0].x,points[0].y,points[0].z);
		    glEnd();
		    glBegin(GL_LINE_STRIP);
    			glVertex3f(points[4].x,points[4].y,points[4].z);	    
    			glVertex3f(points[5].x,points[5].y,points[5].z);	    	
    			glVertex3f(points[6].x,points[6].y,points[6].z);		    
	    		glVertex3f(points[7].x,points[7].y,points[7].z);
	    		glVertex3f(points[4].x,points[4].y,points[4].z);
	    	glEnd();
	    	glBegin(GL_LINE_STRIP);
				glVertex3f(points[0].x,points[0].y,points[0].z);	    
				glVertex3f(points[3].x,points[3].y,points[3].z);	    	
				glVertex3f(points[7].x,points[7].y,points[7].z);		    
    			glVertex3f(points[4].x,points[4].y,points[4].z);
    			glVertex3f(points[0].x,points[0].y,points[0].z);
    		glEnd();
	    	glBegin(GL_LINE_STRIP);
				glVertex3f(points[1].x,points[1].y,points[1].z);	    
				glVertex3f(points[2].x,points[2].y,points[2].z);	    	
				glVertex3f(points[6].x,points[6].y,points[6].z);		    
    			glVertex3f(points[5].x,points[5].y,points[5].z);
    			glVertex3f(points[1].x,points[1].y,points[1].z);
    		glEnd();
	    	glBegin(GL_LINE_STRIP);
				glVertex3f(points[0].x,points[0].y,points[0].z);	    
				glVertex3f(points[1].x,points[3].y,points[3].z);	    	
				glVertex3f(points[5].x,points[7].y,points[7].z);		    
    			glVertex3f(points[4].x,points[4].y,points[4].z);
    			glVertex3f(points[0].x,points[0].y,points[0].z);
    		glEnd();
	    	glBegin(GL_LINE_STRIP);
				glVertex3f(points[2].x,points[2].y,points[2].z);	    
				glVertex3f(points[3].x,points[3].y,points[3].z);	    	
				glVertex3f(points[7].x,points[7].y,points[7].z);		    
    			glVertex3f(points[6].x,points[6].y,points[6].z);
    			glVertex3f(points[2].x,points[2].y,points[2].z);
    		glEnd();
	    		
	    }
	    glEndList();
        glNewList(quadlist, GL_COMPILE);
        {
        	glBegin(GL_QUADS);
		 	        	       	
		    	glVertex3f(points[0].x,points[0].y,points[0].z);	    
		    	glVertex3f(points[1].x,points[1].y,points[1].z);		    
		    	glVertex3f(points[2].x,points[2].y,points[2].z);		    
		    	glVertex3f(points[3].x,points[3].y,points[3].z);

		    
		    	glVertex3f(points[4].x,points[4].y,points[4].z);	    
		    	glVertex3f(points[5].x,points[5].y,points[5].z);		    
		    	glVertex3f(points[6].x,points[6].y,points[6].z);		    
		    	glVertex3f(points[7].x,points[7].y,points[7].z);		   	
		    
		    	glVertex3f(points[0].x,points[0].y,points[0].z);		    
		    	glVertex3f(points[3].x,points[3].y,points[3].z);	    
		    	glVertex3f(points[7].x,points[7].y,points[7].z);	    
				glVertex3f(points[4].x,points[4].y,points[4].z);			
			
				glVertex3f(points[1].x,points[1].y,points[1].z);
				glVertex3f(points[2].x,points[2].y,points[2].z);			    
				glVertex3f(points[6].x,points[6].y,points[6].z);		    
				glVertex3f(points[5].x,points[5].y,points[5].z);
			
				glVertex3f(points[0].x,points[0].y,points[0].z);		    
				glVertex3f(points[1].x,points[1].y,points[1].z);	    
				glVertex3f(points[5].x,points[5].y,points[5].z);	    
				glVertex3f(points[4].x,points[4].y,points[4].z);
		   
				glVertex3f(points[2].x,points[2].y,points[2].z);	   
				glVertex3f(points[3].x,points[3].y,points[3].z);	   
				glVertex3f(points[7].x,points[7].y,points[7].z);	   
				glVertex3f(points[6].x,points[6].y,points[6].z);
		    
		    glEnd();
        }
        glEndList();
		
	}
	
	public void draw()
	{
		glPushMatrix();
		glColor3f(red,green,blue);
		glTranslatef(-position.x, -position.y, -position.z);
		glRotatef(angel.x, 1, 0, 0);
        glRotatef(angel.y, 0, 1, 0);
        glRotatef(angel.z, 0, 0, 1);
        glTranslatef(position.x, position.y, position.z);
        glTranslatef(position.x, position.y, position.z);
        glScalef(scale.x,scale.y,scale.z);
        glCallList(quadlist);
        glCallList(linelist);
        glPopMatrix();
	}
	
	public void destruct()
	{
		glDeleteLists(linelist, 1);
		glDeleteLists(quadlist, 1);
	}
}
