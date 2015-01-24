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
	public abstract void update(float delta);
	
	//normal
	
	public void setScale(Vektor v)
	{
		data[6] = v.x;
		data[7] = v.y;
		data[8] = v.z;
	}
	
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
	
	public void setRotation(Vektor v)
	{
		data[3] = v.x;
		data[4] = v.y;
		data[5] = v.z;
	}
	
	public void rotate(Vektor v)
	{
		data[3] += v.x;
		data[4] += v.y;
		data[5] += v.z;
	}
	
	public Vektor getRotation(float x, float y, float z)
	{
		return new Vektor(data[3],data[4],data[5]);
	}
	
	public void setColor(float r, float g, float b)
	{
		data[9] = r;
		data[10] = g;
		data[11] = b;
	}
	
	//final
	public Renderable draw()
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
	public void init()
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
	public int getInitLevel()
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
