package aoizora.glfw;

import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Window implements AutoCloseable
{
	private long window;
	private GLCapabilities capabilities;
	public Window(int width, int height, CharSequence title)
	{
		if (!glfwInit())
			throw new IllegalStateException("GLFW was ot initialized");

		GLFWErrorCallback.createPrint(System.err).set();

		glfwDefaultWindowHints();
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
		glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);

		window = glfwCreateWindow(width, height, title, NULL, NULL);

		glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
			if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE)
				glfwSetWindowShouldClose(window, true);
		});

		makeContextCurrent();
		capabilities = GL.createCapabilities();
		glfwSwapInterval(1);
	}

	public boolean isKeyPressed(int keyCode)
	{
		return glfwGetKey(window, keyCode) == GLFW_PRESS;
	}

	public void setClearColor(float red, float green, float blue, float depth)
	{
		glClearColor(red, green, blue, depth);
	}

	public void show()
	{
		glfwShowWindow(window);
	}

	public void swapBuffers()
	{
		glfwSwapBuffers(window);
	}

	public void makeContextCurrent()
	{
		glfwMakeContextCurrent(window);
		GL.setCapabilities(capabilities);
	}

	public boolean shouldClose()
	{
		return glfwWindowShouldClose(window);
	}

	public void pollEvents()
	{
		glfwPollEvents();
	}

	@Override
	public void close()
	{
		glfwFreeCallbacks(window);
		glfwDestroyWindow(window);
		glfwTerminate();
		glfwSetErrorCallback(null).free();
	}
}
