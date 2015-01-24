package de.neuwirthinformatik.Alexander.gl.test.ph;

import de.neuwirthinformatik.Alexander.gl.obejct.Vektor;
import de.neuwirthinformatik.Alexander.gl.obejct.D3.LLSphereLine3D;
import de.neuwirthinformatik.Alexander.gl.obejct.D3.Sphere3D;

public class TestObj extends LLSphereLine3D
{
	Vektor speed = new Vektor(0,0,0);//	m/s
	Vektor force = new Vektor(0,0,0);//	N
	Vektor pB;//	T
	Vektor pE;//	N/C
	double pm;//	kg
	double pq;//	C
	
	public TestObj(Vektor pB, Vektor pE, double pm, double pq) {
		super();
		this.pE = pE;
		this.pB = pB;
		this.pm = pm;
		this.pq = pq;
	}
	
	public void setSpeed(Vektor pSpeed) 
	{
		this.speed = pSpeed;
	}
	
	public void setForce(Vektor pForce) 
	{
			this.force = pForce;
	}
	public void calcSpeed(double time) 
	{
		Vektor pForce = new Vektor(force);
		pForce.mult((float) (time/pm));
		speed.add(pForce);
		
		float l = Math.round(speed.length()*10)/(float)10;
		speed.div(speed.length());
		speed.mult(l);
		//System.out.println(speed.length() + "   |--Delta: " + time);
	}
	
	public void move(double time) {
		Vektor pSpeed = new Vektor(speed);
		pSpeed.mult((float) time*100);//mult 100 -> 1m = 100p
		move(pSpeed);
	}
	public void calcForce() 
	{
		Vektor pEforce = new Vektor(pE);
		pEforce.mult((float)pq);
		
		Vektor pBforce = new Vektor(speed);
		pBforce.cross(pB);
		pBforce.negate();
		pBforce.mult((float) pq);
		
		Vektor.add(pEforce, pBforce, force);
		//System.out.println("X:" + force.x);
		//System.out.println("Y:" + force.y);
		//System.out.println("Z:" + force.z);
	}
	@Override
	public void update(float delta) 
	{
		super.update(delta);
		if(delta < 100)
		{
			calcForce();
			calcSpeed(delta/1000);
			move(delta/1000);
		}
	}
}
