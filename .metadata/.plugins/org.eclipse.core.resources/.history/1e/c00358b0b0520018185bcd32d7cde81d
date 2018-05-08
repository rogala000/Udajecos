


import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UdpServer {
    public static void main(String[] args) {
    	DatagramSocket aSocket = null;
      try {
        // args contain message content and server hostname
        aSocket = new DatagramSocket(9876);
        byte[] buffer = new byte[1024];
        while(true) {
          DatagramPacket request = new DatagramPacket(buffer, buffer.length);
          System.out.println("Waiting for request...");
          aSocket.receive(request);
          String t = new String(request.getData());
          
          
          System.out.println("Received: " + t);
          Packet read;
          
          byte[] b = t.getBytes();
			try {
				read = (Packet) deserialize(b);
				System.out.println("Dzia³a!!" + read.toString());
				UdpServer.serialize(read, read.toFileName());
				System.out.println("Zapisano w pliku: " + read.toFileName());
		          String urz_kan = "Urzadzenie: " + read.getDevice() + "\n Nr kanalu: " + read.getChannelNr();
		          byte[] wiadomosc = urz_kan.getBytes();
		          DatagramPacket reply = new DatagramPacket(wiadomosc, wiadomosc.length, 
		            		request.getAddress(), request.getPort());
		            aSocket.send(reply); 



			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Nie dzia³a!!!");
			}
System.out.println("Wysz³o z pêtli!!!");
          
        }
      } catch (SocketException ex) {
        Logger.getLogger(UdpServer.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IOException ex) {
        Logger.getLogger(UdpServer.class.getName()).log(Level.SEVERE, null, ex);
      } finally {
				aSocket.close();
			}
      
    }
    
    
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
    
	private static Object deserialize(byte[] bytes) throws ClassNotFoundException {
		Object obj = null;
		try {
			ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
			ObjectInputStream in = new ObjectInputStream(bis);
			obj = in.readObject();
			in.close();
			System.out.println("Serialized data is retrieved from bytes array");
			return obj;
		} catch (IOException e) {
			e.printStackTrace();
			return obj;
		}
	}

}

