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

import java.util.ArrayList;
import java.util.Random;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import de.neuwirthinformatik.Alexander.gl.obejct.D3.Cube3D;
import de.neuwirthinformatik.Alexander.gl.obejct.D3.Player3D;
import de.neuwirthinformatik.Alexander.gl.threads.RenderThread;
import de.neuwirthinformatik.Alexander.gl.viewport.PerspectiveViewport;


public class Game
{

	
	private DisplayMode dm = Display.getDesktopDisplayMode();
	private long lastFrame;
	private World world;
	//private Player player;
	private Random r = new Random();
	private PerspectiveViewport vp0 = new PerspectiveViewport(0,0,dm.getWidth(),dm.getHeight(),30,0.001f,200);
	private PerspectiveViewport vp1 = new PerspectiveViewport(0,0,dm.getWidth()/2,dm.getHeight()/2,30,0.001f,200);
	private Player3D player;
	private Cube3D q = new Cube3D();
	RenderThread rt;

	public void start() 
	{
		this.init();
		this.loadBuffers();
		while(!Display.isCloseRequested())
		{
			
			long delta = (long) getDelta();
			update(delta);
			//rt.run();
			render();
			Display.update();
            Display.sync(60);
		}
		this.stop();
	}
	
	private void update(long delta) 
	{
		player.update(delta);
		q.update(delta);
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
        vp1.apply();
        player.draw().render();
        //q.draw().render();
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
		//rt = new RenderThread();
		//rt.init();
		try {
            Display.setDisplayMode(dm);
            Display.setTitle("Game");
            Display.create();
            Display.setFullscreen(true);
            Display.setVSyncEnabled(true);
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
      	vp0.init();
      	vp1.init();
      	glMatrixMode(GL_MODELVIEW);
      	glLoadIdentity();
      	glEnable(GL_DEPTH_TEST);
      	
      	
		lastFrame = getTime();
        getDelta();
        
        
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i<10000;i++)
        {
        	list.add(r.nextInt(3));
        }
        world = new World(list,100);
        player = new Player3D(40, 1);
        //player = new Player3D(40, 1);
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
