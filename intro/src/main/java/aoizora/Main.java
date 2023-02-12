package aoizora;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL15.*;

public class Main
{
	public static void main(String[] args)
	{
		if (!glfwInit())
			throw new RuntimeException("Can't initialize GLFW");

		var window = createWindow();

		init();

		while (!window.windowShouldClose())
		{
			render();

			window.update();
			window.pollEvents();
		}

		glfwTerminate();
	}

	private static Window createWindow()
	{
		return new Window();
	}

	private static void init()
	{
		glClearColor(0.0f, 1.0f, 0.0f, 0.0f);
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0.0f, 1.0f, 0.0f, 1.0f, -1.0f, 1.0f);
	}

	private static void render()
	{
		glClear(GL_COLOR_BUFFER_BIT);
		glColor3f(1.0f, 0.0f, 0.0f);
		glBegin(GL_POLYGON);
		glVertex3f(0.25f,0.25f,0.0f);
		glVertex3f(0.75f,0.25f,0.0f);
		glVertex3f(0.75f,0.75f,0.0f);
		glVertex3f(0.25f,0.75f,0.0f);
		glEnd();
		glFlush();
	}
}
