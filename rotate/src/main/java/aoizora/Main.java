package aoizora;

import aoizora.glfw.Window;

import static org.lwjgl.glfw.GLFW.glfwInit;

public class Main
{
	private float spin = 0.0f;

	public static void main(String[] args)
	{
		new Main().run();
	}

	private void run()
	{
		if (!glfwInit())
			throw new RuntimeException("Failed to initialize GLFW.");

		var render = new Render();
		var window = new Window(render);

		render.init();

		while (!window.windowShouldClose())
		{
			render.render(spin);

			window.update();
			window.pollEvents();

			update();
		}
	}

	private void update()
	{
		spin += 1.0;

		if (spin >= 360.0)
			spin -= 360.0;
	}

}
