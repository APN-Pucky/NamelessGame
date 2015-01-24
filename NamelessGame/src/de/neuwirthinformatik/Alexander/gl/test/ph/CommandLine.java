package de.neuwirthinformatik.Alexander.gl.test.ph;

import java.util.Scanner;

public class CommandLine 
{
	public static void main(String[] args)
	{	
		System.out.println("Physik Q1.1: Wien-Filter-Simulation <=> Alexander Puck Neuwirth");
		Scanner sc = new Scanner(System.in);
		System.out.println("Zum Stoppen STRG+C drücken.");
		System.out.println("---------------------------------------------------------------");
		System.out.println("Skalierung (Y-Achse in Meter) (0 -> 2m): ");
		float d = sc.nextFloat();
		if(d == 0) d=2;
		System.out.println("Teilchenmasse (0 -> 6.64465675e-27kg): ");
		float pm = sc.nextFloat();
		if(pm == 0) pm=6.64465675e-27F;
		System.out.println("Ladung (0 -> 3.204e-19C): ");
		float pq = sc.nextFloat();
		if(pq == 0) pq=3.204e-19F;
		System.out.println("Magnetfeldstärke (positiv -> aus Anzeige, in T): ");
		float B = sc.nextFloat();
		System.out.println("Elektrische Feldstärke (positiv -> nach oben, in N/C): ");
		float E = sc.nextFloat();
		System.out.println("Radius des Objekts (0->0.05m): ");
		float r = sc.nextFloat();
		if(r ==0)r = 0.05F;
		System.out.println("Geschwindigkeit (nach rechts, in m/s): ");
		float s = sc.nextFloat();
		PhSim.startSimulation(d, pm, pq, B, E, r, s);
		System.out.println("---------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------");
	}
}
