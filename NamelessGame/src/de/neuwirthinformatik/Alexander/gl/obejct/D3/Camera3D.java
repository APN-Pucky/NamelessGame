package de.neuwirthinformatik.Alexander.gl.obejct.D3;

import org.lwjgl.input.Keyboard;

import de.neuwirthinformatik.Alexander.gl.GLGlobal;
import de.neuwirthinformatik.Alexander.gl.obejct.Object3D;
import de.neuwirthinformatik.Alexander.gl.obejct.GL.CameraGL;

public class Camera3D extends Object3D
{
	public Camera3D()
	{
		super(CameraGL.class);
	}

	@Override
	public void update(long delta) 
	{
        if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE))GLGlobal.stop();
	}
}
