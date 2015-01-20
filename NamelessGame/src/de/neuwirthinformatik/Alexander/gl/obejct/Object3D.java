package de.neuwirthinformatik.Alexander.gl.obejct;


public abstract class Object3D extends Object implements Drawable
{
	public Object3D()
	{
		super();
	}
	
	public Object3D(Object o)
	{
		super(o);
	}
	
	public abstract Renderable draw();
	

	
	public void setPosition(Vektor v)
	{
		data[0] = v.x;
		data[1] = v.y;
		data[2] = v.z;
	}
	
	public void move(Vektor v)
	{
		data[0] += v.x;
		data[1] += v.y;
		data[2] += v.z;
	}
	
	public Vektor getPosition()
	{
		return new Vektor(data[0],data[1],data[2]);
	}
	
	public void rotate(double a, Vektor m, Vektor p)
	{
		//...
	}
}
