package aoizora;

import java.nio.CharBuffer;

public class Buffers
{
	public static void main(String[] args)
	{
		CharBuffer buffer = CharBuffer.allocate(10);
		char[] text = "hello".toCharArray();

		for (int i = 0; i < text.length; i++)
		{
			buffer.append(text[i]);
			System.out.println("capacity: " + buffer.capacity());
			System.out.println("limit: " + buffer.limit());
			System.out.println("position: " + buffer.position());
		}

		buffer.flip();
		System.out.println(buffer);
	}
}
