package de.neuwirthinformatik.Alexander.gl.test.ph;

import javax.swing.JOptionPane;

public class GUI 
{
	public static void main(String[] args)
	{	
		System.out.println("Physik Q1.1: Wien-Filter-Simulation <=> Alexander Puck Neuwirth");
		float u = Float.parseFloat(JOptionPane.showInputDialog("Updates (pro Sekunde): "));
		float sec = Float.parseFloat(JOptionPane.showInputDialog("Vorberechnete Sekunden (schneller): "));
		float d = Float.parseFloat(JOptionPane.showInputDialog("Skalierung (Y-Achse in Meter) (0 -> 2m): "));
		if(d == 0) d=2;
		float pm = Float.parseFloat(JOptionPane.showInputDialog("Teilchenmasse (0 -> 6.64465675e-27kg): "));
		if(pm == 0) pm=6.64465675e-27F;
		float pq = Float.parseFloat(JOptionPane.showInputDialog("Ladung (0 -> 3.204e-19C): "));
		if(pq == 0) pq=3.204e-19F;
		float B = Float.parseFloat(JOptionPane.showInputDialog("Magnetfeldstärke (positiv -> aus Anzeige, in T): "));
		float E = Float.parseFloat(JOptionPane.showInputDialog("Elektrische Feldstärke (positiv -> nach oben, in N/C): "));
		float r = Float.parseFloat(JOptionPane.showInputDialog("Radius des Objekts (0->0.05m): "));
		if(r ==0)r = 0.05F;
		float s = Float.parseFloat(JOptionPane.showInputDialog("Geschwindigkeit (nach rechts, in m/s): "));
		PhSim.startSimulation(u,sec,d, pm, pq, B, E, r, s, true);
	}
}
