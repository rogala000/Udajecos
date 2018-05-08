    import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.rmi.*;
    import java.rmi.server.*;
import java.util.ArrayList;
import java.util.List;
     
public class Addition extends UnicastRemoteObject implements AdditionInterface {
	public static List<Packet> ramka_thi = new ArrayList<Packet>();
	public static List<Packet> ramka_spc = new ArrayList<Packet>();


	public Addition () throws RemoteException {   }
     
		public int add(int a, int b) throws RemoteException {
			int result=a+b+b+b+b+b+b;
			return result;
		}
		
		
		public void zapis_do_ramki(Packet packet) throws RemoteException{
//			Addition addition = new Addition();
//			byte[] dane = addition.serialize(packet);
			if (packet instanceof TimeHistory)
			{
			ramka_thi.add(packet);
			Addition.serialize(packet, "TimeHistory_" + /*packet.toFileNameRMI() + */ ".thi");
			}
			else if (packet instanceof Spectrum)
			{
				ramka_spc.add(packet);
				Addition.serialize(packet, "Spectrum_" + /* packet.toFileNameRMI() +  */".spc");
			}
			else{
				System.out.println("Nieznany pakiet");
			}
		}
		/*
		private byte[] serialize(Object obj) {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutput out = null;
			try {
			  out = new ObjectOutputStream(bos);   
				out.writeObject(obj);
			  out.flush();
			  return bos.toByteArray();
			}
			catch(IOException e) {
				e.printStackTrace();
				return null;
			}
			finally {
			  try {
			    bos.close();
			  } catch (IOException e) {
				  e.printStackTrace();
			  }
		  }
		}
		*/
	    private static boolean serialize(Object obj, String path) {
			try {
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
				out.writeObject(obj);
				out.close();
				System.out.println("Serialized data is saved in " + path);
				return true;
			} catch (IOException i) {
				i.printStackTrace();
				return false;
			}
		}
}