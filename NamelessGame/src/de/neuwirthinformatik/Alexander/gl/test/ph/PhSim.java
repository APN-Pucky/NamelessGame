package de.neuwirthinformatik.Alexander.gl.test.ph;

import de.neuwirthinformatik.Alexander.gl.GLGlobal;
import de.neuwirthinformatik.Alexander.gl.obejct.Updateable;
import de.neuwirthinformatik.Alexander.gl.obejct.Vektor;
import de.neuwirthinformatik.Alexander.gl.obejct.D3.Simulation3D;
import de.neuwirthinformatik.Alexander.gl.obejct.D3.Cube3D;
import de.neuwirthinformatik.Alexander.gl.obejct.D3.Sphere3D;
import de.neuwirthinformatik.Alexander.gl.obejct.GL.LLSphereLineGL;

public class PhSim 
{
	public static void main(String[] args)
	{
		//Player3D p = new Player3D(40, 1);
		/*Cube3D c1 = new Cube3D();
		Cube3D c2 = new Cube3D();
		Cube3D c3 = new Cube3D();
		Cube3D c4 = new Cube3D();
		c1.move(new Vektor(10,0,0));
		c2.move(new Vektor(10,10,0));
		c3.move(new Vektor(0,0,0));
		c4.move(new Vektor(0,10,0));
		GLGlobal.init(new Updateable[]{p,c1,c2,c3,c4});
		GLGlobal.start();*/
		
		Simulation3D p = new Simulation3D();
		
		Cube3D c1 = new Cube3D();
		c1.move(new Vektor(0,300,0));
		c1.setScale(new Vektor(500,5,1));
		c1.setColor(255, 0, 0);
		
		Cube3D c2 = new Cube3D();
		c2.move(new Vektor(0,-300,0));
		c2.setScale(new Vektor(500,5,1));
		c2.setColor(0, 0, 255);
		//FL<FEL	: -0.25e-10		0.5e-12
		//FL>FEL	: -0.25e-10		1e-12
		//
		Alpha a = new Alpha(new Vektor(0,0,0e-10F), new Vektor(0,0e-12F,0));
		a.setScale(new Vektor(10,10,10));
		a.setPosition(new Vektor(-390,0,-100));
		
		a.setSpeed(new Vektor(10F,0,0));
		
		//s.move(new Vektor(-20,0,0));
		//p.move(new Vektor(0,0,-10));
		GLGlobal.init(new Updateable[]{p,c1,c2,a});
		GLGlobal.start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		a.setSpeed(new Vektor(0,0,0));
		System.out.println(LLSphereLineGL.x.get(0));
		System.out.println(LLSphereLineGL.x.get(LLSphereLineGL.x.size()-1));
		
		/**
		 * scale
		 *	10m/s
		 *	1s -> 10m
		 *	---> d15
		 */
	}
}
