package aoizora;

import static org.lwjgl.opengl.GL11.*;

public class Render
{
	public void init()
	{
		glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		glShadeModel(GL_FLAT);
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(-50.0f,50.0f,-50.0f,50.0f,-1.0f,1.0f);
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
	}

	public void render(float spin)
	{
		glClear(GL_COLOR_BUFFER_BIT);
		glPushMatrix();
		glRotatef(spin, 0.0f, 0.0f, 1.0f);
		glColor3f(1.0f, 0.0f, 1.0f);
		glRectf(-25.0f, -25.0f, 25.0f, 25.0f);
		glPopMatrix();
	}

	public void reshape(int width, int height)
	{
		glViewport(0, 0, width, height);
	}
}
