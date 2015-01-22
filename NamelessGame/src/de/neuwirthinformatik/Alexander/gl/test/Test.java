package de.neuwirthinformatik.Alexander.gl.test;

import de.neuwirthinformatik.Alexander.gl.GLGlobal;
import de.neuwirthinformatik.Alexander.gl.obejct.Updateable;
import de.neuwirthinformatik.Alexander.gl.obejct.D3.Player3D;
import de.neuwirthinformatik.Alexander.gl.obejct.D3.Sphere3D;


public class Test 
{
	public static void main(String[] args)
	{
		Player3D p = new Player3D(40, 1);
		Sphere3D c = new Sphere3D();
		GLGlobal.init(new Updateable[]{p,c});
		GLGlobal.start();
	}
}
