
import java.io.Serializable;

public abstract class Packet implements Serializable{
	protected String device;
	protected String description;
	protected long date;
	
	public Packet(String device, String description, long date)
	{
		this.device = device;
		this.description = description;
		this.date = date;
	}
	
	public String toFileNameRMI()
	{
		String fileName;
		fileName = device +"_" + description + "_" + date;
		return fileName;
		
	}
	
	public String toFileName()
	{
		String fileName;
		fileName = device +"_" + description + ".txt";
		return fileName;
		
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public int getChannelNr() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
