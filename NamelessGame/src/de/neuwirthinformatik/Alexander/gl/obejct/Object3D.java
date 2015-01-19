package de.neuwirthinformatik.Alexander.gl.obejct;


public abstract class Object3D extends Object implements Drawable
{
	public Object3D()
	{
		super();
	}
	
	public abstract Renderable draw();
	

	
	public void setPosition(Vektor v)
	{
		m03 = v.x;
		m13 = v.y;
		m23 = v.z;
	}
	
	public void move(Vektor v)
	{
		m03 += v.x;
		m13 += v.y;
		m23 += v.z;
	}
	
	public Vektor getPosition()
	{
		return new Vektor(m03,m13,m23);
	}
	
	public void rotate(double a, Vektor m, Vektor p)
	{
		float n = (float)Math.sqrt(m.x * m.x + m.y * m.y + m.z * m.z);
	    float x = (float)m.x / n; float y = (float)m.y / n; float z = (float)m.z / n;

	    float[] zML = new float[16];
	    System.arraycopy(toArray(), 0, zML, 0, 16);
	    zML[12] -= m.x;
	    zML[13] -= m.y;
	    zML[14] -= m.z;

	    float[] lD = new float[16];
	    float c = (float)Math.cos(a / 180.0D * 3.141592653589793D);
	    float s = (float)Math.sin(a / 180.0D * 3.141592653589793D);

	    lD[0] = ((y * y + z * z) * c + x * x);
	    lD[1] = (x * y * (1.0F - c) + z * s);
	    lD[2] = (x * z * (1.0F - c) - y * s);

	    lD[4] = (x * y * (1.0F - c) - z * s);
	    lD[5] = ((x * x + z * z) * c + y * y);
	    lD[6] = (y * z * (1.0F - c) + x * s);

	    lD[8] = (x * z * (1.0F - c) + y * s);
	    lD[9] = (y * z * (1.0F - c) - x * s);
	    lD[10] = ((x * x + y * y) * c + z * z);

	    lD[15] = 1.0F;

	    float[] lR = new float[16];
	    for (int i = 0; i <= 3; i++)
	      for (int j = 0; j <= 3; j++)
	        for (int k = 0; k <= 3; k++)
	          lR[(i * 4 + j)] += zML[(i * 4 + k)] * lD[(k * 4 + j)];
	    zML = lR;

	    zML[12] += (float)m.x;
	    zML[13] += (float)m.y;
	    zML[14] += (float)m.z;
	    setArray(zML);
	    
	}
}
