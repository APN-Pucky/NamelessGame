package de.neuwirthinformatik.Alexander.gl.obejct;

import de.neuwirthinformatik.Alexander.gl.GLGlobalParam;

public interface Initable extends GLGlobalParam
{
	public void init();
	public int getInitLevel();
}
