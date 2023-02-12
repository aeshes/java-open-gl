package aoizora;

public class GameLoop
{
	public static void main(String[] args)
	{
		new GameLoop().run();
	}

	private void run()
	{
		double secsPerFrame = 1.0d / 50.0d;
		boolean running = true;

		while (running)
		{
			double now = getTime();

			handleInput();
			updateGameState();
			render();
			sleep(secsPerFrame - (getTime() - now));
		}
	}

	private double getTime()
	{
		return System.currentTimeMillis();
	}

	private void handleInput()
	{
		System.out.println("Handle input");
	}

	private void updateGameState()
	{
		System.out.println("Update game state");
	}

	private void render()
	{
		System.out.println("Render");
	}

	private void sleep(double time)
	{
		if (time < 0) return;
		try
		{
			Thread.sleep((long)time);
		}
		catch (InterruptedException e) {}
	}
}
