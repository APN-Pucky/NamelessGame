package de.neuwirthinformatik.Alexander.gl.test.ph;

import de.neuwirthinformatik.Alexander.gl.GLGlobal;
import de.neuwirthinformatik.Alexander.gl.obejct.Updateable;
import de.neuwirthinformatik.Alexander.gl.obejct.Vektor;
import de.neuwirthinformatik.Alexander.gl.obejct.D3.Cube3D;
import de.neuwirthinformatik.Alexander.gl.obejct.D3.Simulation3D;


public class PhSim 
{
	public static void main(String[] args)
	{
		float d = 0.155F;//m
		float pm = 9.109e-31F;//	kg
		float pq = -1.602e-19F;//	C
		
		float B = -8.0e-3F;//T	
		float E = -2.56e4F;//N/C
		float s = 4.2e7F;//m/s
		
		float r = 0.0001F;//m
		float sec = 0.00000004F;
		float u = 0.5e15F;
		PhSim.startSimulation(u,sec,d, pm, pq, B, E, r, s);
	}
	
	public static void startSimulation(float u,float sec,float d, float pm, float pq, float B, float E, float r, float s)
	{
		//FL<FEL	: -0.25e-10		0.5e-12
		//FL>FEL	: -0.25e-10		1e-12
		//
		Simulation3D p = new Simulation3D(d);
		
		/*Cube3D c1 = new Cube3D();
		c1.move(new Vektor(0, (d*50),0));
		c1.setScale(new Vektor( (d*60*100),d*100/60,1));
		c1.setColor(211, 211, 211);
		
		Cube3D c2 = new Cube3D();
		c2.move(new Vektor(0, (-d*50),0));
		c2.setScale(new Vektor( (d*60*100),d*100/60,1));
		c2.setColor(211, 211, 211);*/
		
		Cube3D c3 = new Cube3D();
		c3.move(new Vektor(-(d*50), 0,-10));
		c3.setScale(new Vektor(100,0.5F,0.5F));
		c3.setColor(255, 140, 0);
		
		Cube3D c4 = new Cube3D();
		c4.move(new Vektor(-(d*50), 0,-10));
		c4.setScale(new Vektor(100,0.5F,0.5F));
		c4.setColor(255, 140, 0);
		c4.rotate(new Vektor(0,0,-90));
		
		Cube3D c5 = new Cube3D();
		c5.move(new Vektor(-(d*50), 0,0));
		c5.setScale(new Vektor(1,0.25F,0.25F));
		c5.setColor(255, 0, 0);
		
		Cube3D c6 = new Cube3D();
		c6.move(new Vektor(-(d*50), 0,0));
		c6.setScale(new Vektor(1,0.25F,0.25F));
		c6.setColor(255, 0, 0);
		c6.rotate(new Vektor(0,0,-90));
		
		
		TestObj a = new TestObj(new Vektor(0,0,-B), new Vektor(0,E,0),pm,pq,u);
		a.setScale(new Vektor(r*100,r*100,r*100));
		a.setPosition(new Vektor(-(d*50),0,-100));
		
		a.setSpeed(new Vektor(s,0,0));
		for(int i =0;i < sec*u;i++)
		{
			a.update(0);
			
		}
		
		//s.move(new Vektor(-20,0,0));
		//p.move(new Vektor(0,0,-10));
		
		GLGlobal.init(new Updateable[]{p,c3,c4,c5,c6,a});
		GLGlobal.start();
		/**
		 * scale 1.5p = 1m			100p ?= 1m
		 * 1440.8154 == 1000m
		 * 1433.9834 ==
		 * 1432.8835 ==
		 * 100000m   == 148796.7
		 * ----------------
		 * 100m = 14.192541p    1m = 0.14
		 * 100m = 21524p		1m = 215p
		 * 100m = 10789.028		1m = 107.89p
		 * 		  1058.15
		 * 1m	= 75.870926p
		 */
	}
}
