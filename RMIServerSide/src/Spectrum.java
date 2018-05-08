
import java.util.Arrays;

public class Spectrum<T> extends Sequence {
	boolean scale;
	
	public Spectrum(boolean scale, int channelNr, String unit, double resolution, T[] buffer, String device, String description, long date)
	{
		super(device, description, date, unit, channelNr,  resolution, buffer);
		this.scale = scale;
		
		

	}
	
	public String toString()
	{
		String temp;
		temp = " device = " + device + "\n description = " + description + "\n date = " + date + "\n scale = " + scale + "\n channelNr = " + channelNr + 
				"\n unit = " + unit + "\n resolution = " + resolution + "\n buffer = " + Arrays.toString(buffer);
		
		return temp;
	}

}
