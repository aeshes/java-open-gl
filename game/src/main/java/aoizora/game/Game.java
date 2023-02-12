package aoizora.game;

import aoizora.glfw.Window;

public class Game implements Runnable, GameLogic
{
	private Render render;

	@Override
	public void run()
	{
		init();

		try (var window = new Window(640, 480, "Game"))
		{
			window.makeContextCurrent();
			window.show();

			while (!window.shouldClose())
			{
				window.pollEvents();
				render();
				window.swapBuffers();
			}
		}
	}

	@Override
	public void init()
	{
		render = new Render();
	}

	@Override
	public void input()
	{

	}

	@Override
	public void render()
	{
		render.clear();
	}

	@Override
	public void update()
	{

	}
}
