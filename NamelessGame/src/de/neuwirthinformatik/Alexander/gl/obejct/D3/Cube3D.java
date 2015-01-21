package de.neuwirthinformatik.Alexander.gl.obejct.D3;

import de.neuwirthinformatik.Alexander.gl.obejct.Drawable;
import de.neuwirthinformatik.Alexander.gl.obejct.Object3D;
import de.neuwirthinformatik.Alexander.gl.obejct.Renderable;
import de.neuwirthinformatik.Alexander.gl.obejct.Vektor;
import de.neuwirthinformatik.Alexander.gl.obejct.GL.CubeGL;

public class Cube3D extends Object3D implements Drawable
{

	public Cube3D()
	{
		super();
	}
	
	@Override
	public Renderable draw() 
	{
		return new CubeGL(this);
	}

	@Override
	public void update(long delta) 
	{
		this.move(new Vektor(0,0,-0.00010F*delta));
	}

}
