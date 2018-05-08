
import java.util.Arrays;

public class TimeHistory<T> extends Sequence {
	double sensitivity;
	
	
	
	
	public TimeHistory(double sensitivity, int channelNr, String unit, double resolution, T[] buffer, String device, String description, long date)
	{
		super(device, description, date, unit, channelNr,  resolution, buffer);
		this.sensitivity = sensitivity;
	}
	
	public String toString()
	{
		String temp;
		temp = " device = " + device + "\n description = " + description + "\n date = " + 
		date + "\n sensitivity = " + sensitivity + "\n channelNr = " + channelNr + 
		"\n unit = " + unit + "\n resolution = " + resolution + "\n buffer = " + Arrays.toString(buffer);
		
		return temp;
	}

}
