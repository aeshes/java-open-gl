package aoizora.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils
{
	public static String readFile(String filePath) {
		try
		{
			return new String(Files.readAllBytes(Paths.get(filePath)));
		}
		catch (IOException ex)
		{
			throw new RuntimeException("Error reading file [" + filePath + "]", ex);
		}
	}
}
