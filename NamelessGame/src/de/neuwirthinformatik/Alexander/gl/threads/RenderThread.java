package de.neuwirthinformatik.Alexander.gl.threads;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_COLOR_MATERIAL;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_DIFFUSE;
import static org.lwjgl.opengl.GL11.GL_FRONT;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glColorMaterial;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.util.glu.GLU.gluPerspective;

import java.util.Queue;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import de.neuwirthinformatik.Alexander.gl.GLGlobal;
import de.neuwirthinformatik.Alexander.gl.obejct.Initable;
import de.neuwirthinformatik.Alexander.gl.obejct.Renderable;

public class RenderThread extends SyncThread  implements Initable
{
	boolean running = true;
	
	public void run()
	{
		init();
		int cur,prev=2;
		while(running)
		{
			while((cur=GLGlobal.getCurrentRenderStatus()) == prev){}
			GLGlobal.setRenderRenderStatus(cur);
			Queue<Renderable> rs = GLGlobal.getRenderStatus(cur);
			preRender();
			int length = rs.size();
			for(int i = 0; i < length;i++)
			{
				Renderable ra = rs.remove();
				ra.render();
			}
			postRender();
			prev = cur;
			Display.update();
			Display.sync(30);
			//sync(30);
		}
	}
	
	public void preRender()
	{
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();
	}
	
	public void postRender()
	{
		
	}

	@Override
	public void init() 
	{
		try {
            Display.setDisplayMode(Display.getDesktopDisplayMode());
            Display.setTitle("Game");
            Display.create();
            Display.setFullscreen(false);
            //Mouse.setGrabbed(true);
        } catch (LWJGLException e) {
            e.printStackTrace();
            Display.destroy();
            System.exit(1);
        }
		
		glEnable(GL_COLOR_MATERIAL);
     	glColorMaterial(GL_FRONT, GL_DIFFUSE);
      	
	  	glMatrixMode(GL_PROJECTION);
	  	glLoadIdentity();
	  	gluPerspective(30, (float)Display.getDesktopDisplayMode().getWidth() / (float)Display.getDesktopDisplayMode().getHeight(), 0.002F, 200F);
      	glMatrixMode(GL_MODELVIEW);
      	glLoadIdentity();
      	glEnable(GL_DEPTH_TEST);
	}
}
