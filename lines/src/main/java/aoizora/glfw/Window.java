package aoizora.glfw;

import aoizora.gl.Lines;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Window
{
	private long handle;
	private Lines lines;

	public Window(Lines lines)
	{
		this.lines = lines;

		create();
	}

	private void create()
	{
		glfwDefaultWindowHints();
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);

		handle = glfwCreateWindow(800, 600, "Lines", NULL, NULL);

		glfwSetWindowSizeCallback(handle, ((window, width, height) -> resize(width, height)));
		glfwMakeContextCurrent(handle);
		glfwSwapInterval(1);
		GL.createCapabilities();

		glfwShowWindow(handle);
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

	private void resize(int width, int height)
	{
		lines.reshape(width, height);
	}
}