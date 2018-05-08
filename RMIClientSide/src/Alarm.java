

public class Alarm extends Packet {

	int channelNr;
	double threshold;
	int direction;
	
	public Alarm (int channelNr, double threshold, int direction, String device, String description, long date)
	{
		super(device, description,date);
		this.channelNr = channelNr;
		this.threshold = threshold;
		this.direction = direction;

	}
	
	public String toString()
	{
		String temp;
		temp = " device = " + device + "\n description = " + description + "\n date = " + date + "\n channelNr = " + channelNr + "\n threshold = " + threshold +  "\n direction = " + direction;
		
		return temp;
	}
	
	
}
