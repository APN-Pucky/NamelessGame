package de.neuwirthinformatik.Alexander.gl.test;

import de.neuwirthinformatik.Alexander.gl.GLGlobal;
import de.neuwirthinformatik.Alexander.gl.obejct.Updateable;
import de.neuwirthinformatik.Alexander.gl.obejct.D3.Cube3D;
import de.neuwirthinformatik.Alexander.gl.obejct.D3.Player3D;


public class Test 
{
	public static void main(String[] args)
	{
		Player3D p = new Player3D(40, 1);
		Cube3D c = new Cube3D();
		GLGlobal.init(new Updateable[]{p,c});
		GLGlobal.start();
	}
}
