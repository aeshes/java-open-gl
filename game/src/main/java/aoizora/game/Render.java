package aoizora.game;

import static org.lwjgl.opengl.GL11.*;

public class Render
{
	public Render()
	{
	}

	public void init() throws Exception
	{

	}

	public void clear()
	{
		glClearColor(1.0f, 0.0f, 0.0f, 0.0f);
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	}
}
