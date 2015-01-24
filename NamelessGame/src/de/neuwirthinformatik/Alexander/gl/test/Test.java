package de.neuwirthinformatik.Alexander.gl.test;

import de.neuwirthinformatik.Alexander.gl.GLGlobal;
import de.neuwirthinformatik.Alexander.gl.obejct.Updateable;
import de.neuwirthinformatik.Alexander.gl.obejct.Vektor;
import de.neuwirthinformatik.Alexander.gl.obejct.D3.Simulation3D;
import de.neuwirthinformatik.Alexander.gl.obejct.D3.Cube3D;
import de.neuwirthinformatik.Alexander.gl.obejct.D3.Sphere3D;


public class Test 
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
		Sphere3D s = new Sphere3D();
		Cube3D c1 = new Cube3D();
		Cube3D c2 = new Cube3D();
		Cube3D c3 = new Cube3D();
		Cube3D c4 = new Cube3D();
		c1.move(new Vektor(5,-5,0));
		c2.move(new Vektor(5,5,0));
		c3.move(new Vektor(-5,-5,0));
		c4.move(new Vektor(-5,5,0));
		p.move(new Vektor(0,0,-100));
		GLGlobal.init(new Updateable[]{p,c1,c2,c3,c4,s});
		GLGlobal.start();
	}
}
