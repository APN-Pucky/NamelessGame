package namelessgame;

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

import java.util.ArrayList;
import java.util.Random;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;


public class Game
{

	
	private DisplayMode displaymode = Display.getDesktopDisplayMode();
	private long lastFrame;
	private Quad quad;
	private Quad quad2;
	private World world;
	private Player player;
	private Random r = new Random();


	public void start() 
	{
		this.init();
		this.loadBuffers();
		while(!Display.isCloseRequested())
		{
			
			long delta = (long) getDelta();
			update(delta);
			render();
			Display.update();
            Display.sync(60);
		}
		this.stop();
	}
	
	private void update(long delta) 
	{
		player.update(delta);
	}

	private void loadBuffers() 
	{
		//quad.init();
		//quad2.init();
	}

	private void render() 
	{
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();
        player.changeMatrix();
        //quad.draw();
        //quad2.draw();
        world.draw();
	}

	private double getDelta() 
	{
		long currentTime = getTime();
		double delta = (double) currentTime - (double) lastFrame;
		lastFrame = getTime();
		return delta;
	}

	private void init()
	{
		try {
            Display.setDisplayMode(displaymode);
            Display.setTitle("QuadShooter");
            Display.create();
            Display.setFullscreen(true);
            Mouse.setGrabbed(true);
            
          
            
        } catch (LWJGLException e) {
            e.printStackTrace();
            Display.destroy();
            System.exit(1);
        }
	 
		glEnable(GL_COLOR_MATERIAL);
     	glColorMaterial(GL_FRONT, GL_DIFFUSE);
	 
	  	glMatrixMode(GL_PROJECTION);
      	glLoadIdentity();           
      	gluPerspective((float) 30, (float)displaymode.getWidth() / (float)displaymode.getHeight(), 0.001f, 200);
      	//glFrustum(-10,10,-10* displaymode.getWidth() / displaymode.getHeight(),10 * displaymode.getWidth() / displaymode.getHeight(),0.001,200);
      	glMatrixMode(GL_MODELVIEW);
      	glLoadIdentity();
      	glEnable(GL_DEPTH_TEST);	
		lastFrame = getTime();
        getDelta();
        //quad = new Quad(0,0,-20,1,1,1,0,0,0,0,0,5);
        //quad2 = new Quad(0,1F,-20,1,1,1,0,0,0,0,5,0);
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i<100;i++)
        {
        	list.add(r.nextInt(10));
        }
        world = new World(list,3);
        player = new Player(40, 1);
	}
	
	private void stop()
	{
		Display.destroy();
	    System.exit(0);
	}
	
	private long getTime() 
	{
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}

}
