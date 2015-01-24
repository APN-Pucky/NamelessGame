package de.neuwirthinformatik.Alexander.gl.obejct.D3;

import org.lwjgl.input.Keyboard;

import de.neuwirthinformatik.Alexander.gl.GLGlobal;
import de.neuwirthinformatik.Alexander.gl.obejct.Object3D;
import de.neuwirthinformatik.Alexander.gl.obejct.GL.SimulationGL;

public class Simulation3D extends Object3D
{
	public Simulation3D(float pHeight)
	{
		super(SimulationGL.class);
		SimulationGL.pHeight = pHeight;
	}

	@Override
	public void update(float delta) 
	{
        if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE))GLGlobal.stop();
	}
}
