package aoizora;

import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Window
{
	private long handle;

	public Window()
	{
		glfwDefaultWindowHints();
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
		glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);

		handle = glfwCreateWindow(800, 600, "Intro", NULL, NULL);

		glfwMakeContextCurrent(handle);
		glfwSwapInterval(1);
		GL.createCapabilities();

		glfwShowWindow(handle);
	}

	public long handle()
	{
		return handle;
	}

	public boolean windowShouldClose()
	{
		return glfwWindowShouldClose(handle);
	}

	public void update()
	{
		glfwSwapBuffers(handle);
	}

	public void pollEvents()
	{
		glfwPollEvents();
	}
}
