package aoizora;

import aoizora.gl.Lines;
import aoizora.glfw.Window;

import static org.lwjgl.glfw.GLFW.glfwInit;

public class Main
{
	public static void main(String[] args)
	{
		new Main().run();
	}

	private void run()
	{
		if (!glfwInit())
			throw new RuntimeException("Failed to initialize GLFW.");

		var lines = new Lines();
		var window = new Window(lines);

		lines.init();

		while (!window.windowShouldClose())
		{
			lines.render();

			window.pollEvents();
			window.update();
		}
	}
}
