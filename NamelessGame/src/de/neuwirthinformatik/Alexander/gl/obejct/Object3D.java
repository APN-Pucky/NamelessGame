package de.neuwirthinformatik.Alexander.gl.obejct;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public abstract class Object3D extends Object implements Drawable, Updateable
{
	private Constructor<? extends ObjectGL> c;
	private Class<? extends ObjectGL> gl;
	
	//Constructors
	public Object3D(Class<? extends ObjectGL> gl)
	{
		super();
		this.gl = gl;
		try 
		{
			c = gl.getConstructor(Object.class);
		} 
		catch (NoSuchMethodException | SecurityException e) 
		{
			e.printStackTrace();
		}
	}
	//abstract
	public abstract void update(long delta);
	
	//normal
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
	
	//final
	public final Renderable draw()
	{
		Renderable r = null;
		try 
		{
			r = (Renderable) c.newInstance(this);
		} 
		catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) 
		{
			e.printStackTrace();
		}
		return r;
	}
	
	@Override
	public final void init()
	{
		try 
		{
			gl.getMethod("init").invoke(draw());
		} 
		catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) 
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public final int getInitLevel()
	{
		try 
		{
			return (int)gl.getMethod("getInitLevel").invoke(draw());
		} 
		catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) 
		{
			e.printStackTrace();
		}
		return -1;
	}
}
