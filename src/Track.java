import java.io.*;
public class Track {
	
	private String name;
	private ByteArrayOutputStream audio;
	
	public Track( String name, ByteArrayOutputStream audio )
	{	
		this.name = name;
		this.audio = audio;
	}
	
	public String getName()
	{
		return name;
	}
	
}

