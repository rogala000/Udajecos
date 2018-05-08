

public abstract class Sequence<T> extends Packet {
	protected int channelNr;
	protected String unit;
	protected double resolution;
	protected T[]	buffer;
	
	public Sequence(String device, String description, long date, String unit, int channelNr, double resolution, T[] buffer){
		super(device, description,date);
		this.channelNr = channelNr;
		this.unit = unit;
		this.resolution = resolution;
		this.buffer = buffer;

		
	}
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public int getChannelNr() {
		return channelNr;
	}

	public void setChannelNr(int channelNr) {
		this.channelNr = channelNr;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getResolution() {
		return resolution;
	}

	public void setResolution(double resolution) {
		this.resolution = resolution;
	}

	public T[] getBuffer() {
		return buffer;
	}

	public void setBuffer(T[] buffer) {
		this.buffer = buffer;
	}
	
	
}



