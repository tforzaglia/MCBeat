import java.util.Vector;

public class Track {
	
	//private ByteArrayOutputStream audio;
	
	private Vector<Byte> data = new Vector<Byte>();
	private boolean enable = false;
	private String name;
	
	public Track( Vector<Byte> data, boolean enable, String name )
	{
		this.data = data;
		this.setEnable(false);
		this.name = name;
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
		this.setEnable(true);
	}
	
	public String getName()
	{
		return name;
	}

	public void setEnable(boolean enable) 
	{
		this.enable = enable;
	}

	public boolean isEnable() 
	{
		return enable;
	}
		
}

//get set data 
//get set volume
//set enabled
