package de.neuwirthinformatik.Alexander.gl.obejct;

import org.lwjgl.util.vector.Vector3f;

public class Vektor extends Vector3f
{
	public Vektor(float x,float y,float z)
	{
		super(x,y,z);
	}
	
	public Vektor(Vektor v)
	{
		super(v.x,v.y,v.z);
	}
}
