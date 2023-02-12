package aoizora;

import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;
import static org.lwjgl.util.glu.GLU.gluOrtho2D;

public class Main
{
	public static void main(String[] args)
	{
		new Main().run();
	}

	public void run()
	{
		if (!glfwInit())
			throw new RuntimeException("Failed to initialize GLFW.");

		long window = createWindow();

		init();

		while (!glfwWindowShouldClose(window))
		{
			glfwPollEvents();;
			render();
			glfwSwapBuffers(window);
		}
	}

	private long createWindow()
	{
		long handle = glfwCreateWindow(800, 600, "Edges", NULL, NULL);

		glfwSetWindowSizeCallback(handle, ((window, width, height) -> resize(width, height)));
		glfwMakeContextCurrent(handle);
		glfwSwapInterval(1);
		GL.createCapabilities();

		glfwShowWindow(handle);

		return handle;
	}

	private void resize(int width, int height)
	{
		glViewport(0,0, width, height);
	}

	private void init()
	{
		glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		gluOrtho2D(0.0f,400.0f,0.0f,150.0f);
	}

	private void render()
	{
		glClear(GL_COLOR_BUFFER_BIT);
		glColor3f(0.0f, 0.0f, 0.0f);
		glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
		glBegin(GL_POLYGON);
			glEdgeFlag(true);
			glVertex3f(10.0f, 50.0f, 0.0f);
			glEdgeFlag(false);
			glVertex3f(10.0f, 100.0f, 0.0f);
			glEdgeFlag(true);
			glVertex3f(150.0f, 50.0f, 0.0f);
		glEnd();
		glFlush();
	}
}
