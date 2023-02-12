package aoizora.gl;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluOrtho2D;

public class Lines
{
	public void init()
	{
		glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
		glShadeModel(GL_FLAT);
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		gluOrtho2D(0.0f,400.0f,0.0f,150.0f);
	}

	public void render()
	{
		glClear(GL_COLOR_BUFFER_BIT);
		glColor3f(0.0f, 0.0f, 0.0f);
		glEnable(GL_LINE_STIPPLE);

		glLineWidth(5.0f);
		glLineStipple(1, (short) 0x1C47);

		glBegin(GL_LINE_STRIP);
		for (int i = 0; i < 7; i++)
			glVertex2f(50.0f + i*50.0f, 75.0f);
		glEnd();

		glDisable(GL_LINE_STIPPLE);
		glFlush();
	}

	public void reshape(int width,int height)
	{
		glViewport(0,0, width, height);
	}
}
