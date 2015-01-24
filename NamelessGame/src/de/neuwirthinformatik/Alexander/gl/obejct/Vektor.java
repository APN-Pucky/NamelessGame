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
	
	public void cross(Vektor v)
	{
		Vektor.cross(this, v, this);
	}
	
	public void add(Vektor v)
	{
		Vektor.add(this, v, this);
	}
	
	public void sub(Vektor v)
	{
		Vektor.sub(this, v, this);
	}
	
	public void mult(float p)
	{
		scale(p);
	}
	
	public void div(float p)
	{
		scale(1/p);
	}
}
