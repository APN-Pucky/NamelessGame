package de.neuwirthinformatik.Alexander.gl.obejct.D3;

import de.neuwirthinformatik.Alexander.gl.obejct.Object3D;
import de.neuwirthinformatik.Alexander.gl.obejct.GL.LLSphereLineGL;


public class LLSphereLine3D extends Object3D
{
	public LLSphereLine3D()
	{
		super(LLSphereLineGL.class);
	}

	@Override
	public void update(float delta) 
	{
		LLSphereLineGL.x.add(data[0]);
		LLSphereLineGL.y.add(data[1]);
		LLSphereLineGL.z.add(data[2]);
	}

}
