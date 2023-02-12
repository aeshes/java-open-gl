package aoizora.shader;

import static org.lwjgl.opengl.GL20.*;

public class ShaderProgram
{
	private final int programId;
	private int vertexShaderId;
	private int fragmentShaderId;

	public ShaderProgram() throws Exception
	{
		programId = glCreateProgram();
		if (programId == 0)
			throw new Exception("Failed to create shader.");
	}

	public void createVertexShader(String code) throws Exception
	{
		vertexShaderId = createShader(code, GL_VERTEX_SHADER);
	}

	public void createFragmentShader(String code) throws Exception
	{
		fragmentShaderId = createShader(code, GL_FRAGMENT_SHADER);
	}

	protected int createShader(String code, int type) throws Exception
	{
		int shaderId = glCreateShader(type);
		if (shaderId == 0)
			throw new Exception("Error creating shader. Type: " + type);

		glShaderSource(shaderId, code);
		glCompileShader(shaderId);

		if (glGetShaderi(shaderId, GL_COMPILE_STATUS) == 0)
			throw new Exception("Error compiling shader code: " + glGetShaderInfoLog(shaderId, 1024));

		glAttachShader(programId, shaderId);

		return shaderId;
	}

	public void link() throws Exception
	{
		glLinkProgram(programId);

		if (glGetProgrami(programId, GL_LINK_STATUS) == 0)
			throw new Exception("Error linking shader code: " + glGetProgramInfoLog(programId, 1024));

		if (vertexShaderId != 0)
			glDetachShader(programId, vertexShaderId);
		if (fragmentShaderId != 0)
			glDetachShader(programId, fragmentShaderId);

		glValidateProgram(programId);

		if (glGetProgrami(programId, GL_VALIDATE_STATUS) == 0)
			System.err.println("Warning validating shader code: " + glGetProgramInfoLog(programId, 1024));
	}

	public void bind()
	{
		glUseProgram(programId);
	}

	public void unbind()
	{
		glUseProgram(0);
	}

	public void cleanup()
	{
		unbind();
		if (programId != 0)
			glDeleteProgram(programId);
	}
}
