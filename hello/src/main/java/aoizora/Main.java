package aoizora;

import org.lwjgl.Version;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.system.MemoryStack;

import java.nio.IntBuffer;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryStack.stackPush;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Main
{
	private long window;
	private Render render;

	public static void main(String[] args)
	{
		new Main().run();
	}

	public void run()
	{
		System.out.println("OpenGL " + Version.getVersion() + "!");

		init();
		loop();
	}

	private void init()
	{
		GLFWErrorCallback.createPrint(System.err).set();

		if (!glfwInit())
			throw new IllegalStateException("Unable to initialize GLFW");

		glfwDefaultWindowHints();
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
		glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);

		window = glfwCreateWindow(300, 300, "OpenGL", NULL, NULL);

		glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
			if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
				glfwSetWindowShouldClose(window, true); // We will detect this in the rendering loop
		});

		try (MemoryStack stack = stackPush())
		{
			IntBuffer width = stack.mallocInt(1);
			IntBuffer height = stack.mallocInt(1);

			glfwGetWindowSize(window, width, height);

			GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

			glfwSetWindowPos(
					window,
					(vidmode.width() - width.get(0)) / 2,
					(vidmode.height() - height.get(0)) / 2
			);

			glfwMakeContextCurrent(window);
			glfwSwapInterval(1);
			glfwShowWindow(window);

			render = new Render();
		}
	}

	private void loop()
	{
		while (!glfwWindowShouldClose(window))
		{
			render.clear();

			glfwSwapBuffers(window);
			glfwPollEvents();
		}
	}
}
