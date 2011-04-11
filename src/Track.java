import java.util.Vector;

public class Track {
	
	//private String name;
	//private ByteArrayOutputStream audio;
	
	private Vector<Byte> data = new Vector<Byte>();
	private boolean enable = false;
	
	public Track( Vector<Byte> data, boolean enable)
	{
		this.data = data;
		this.enable = false;
		//volume
	}
	
	public void setData(Vector<Byte> data)
	{
		this.data = data;
	}
	
	public Vector<Byte> getData()
	{
		return this.data; 
	}
	
	public void enableTrack()
	{
		this.enable = true;
	}
	
	/*
	public Track( String name, ByteArrayOutputStream audio )
	{	
		this.name = name;
		this.audio = audio;
	}
	
	public String getName()
	{
		return name;
	}
	*/
	
	
	
	
	
}

//get set data 
//get set volume
//set enabled
//take from each buffer and average 
