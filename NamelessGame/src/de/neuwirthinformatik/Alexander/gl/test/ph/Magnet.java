package de.neuwirthinformatik.Alexander.gl.test.ph;

import de.neuwirthinformatik.Alexander.gl.obejct.Vektor;

public class Magnet {
	Vektor pos, nord, sued;
	float strength;
	public Magnet(float x, float y, float z, float laenge, float strength) {
		pos = new Vektor(x,y,z);
		nord = new Vektor(x,y+laenge/2,z);
		sued = new Vektor(x,y-laenge/2,z);
		this.strength = strength;
	}
	public Field generateField() {
		return new Field() {
			public Vektor getField(Vektor pos) {
				Vektor entfernung1 = new Vektor(pos);
				entfernung1.sub(nord);
				Vektor entfernung2 = new Vektor(sued);
				entfernung2.sub(pos);
				
				if(entfernung1.length() > 0 || entfernung2.length() > 0) {
					float distance = entfernung1.length();
					entfernung1.normalise();
					entfernung1.mult(strength/distance);
					
					distance = entfernung2.length();
					entfernung2.normalise();
					entfernung2.mult(strength/distance);
					
					entfernung1.add(entfernung2);
				return entfernung1;
				} else {
					return new Vektor(0,0,0);
				}
			}
		};
	}
}