

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UDPClient<T> {
	public static void main(String[] args) {
		
		
		Integer[] arr = new Integer[3];
		Spectrum<Integer> spektrum = new Spectrum<Integer>(true, 5, "km", 3.0,  arr, "device2", "Opis2", 435345);
		UDPClient client = new UDPClient();
		client.serialize(spektrum, "file.txt");
		byte [] dane = client.serialize(spektrum);
		//client.serialize(spektrum.toString(), "file.txt");

		try {
			byte[] data = Files.readAllBytes(new File("file.txt").toPath());
			InetAddress aHost = InetAddress.getByName(null);
			int serverPort = 9876;

			DatagramPacket pakiet = new DatagramPacket(dane, dane.length, aHost, serverPort);
			DatagramSocket aSocket = null;
			Scanner scanner = null;

			aSocket = new DatagramSocket();
			scanner = new Scanner(System.in);

			aSocket.send(pakiet);

	        byte[] buffer = new byte[1024];
	          DatagramPacket reply = new DatagramPacket(buffer, buffer.length);

			//DatagramPacket reply = new DatagramPacket(data, data.length);
			
			aSocket.receive(reply);
	          String t = new String(reply.getData());
	          System.out.println(t);
			/*
			Files.write(new File("file2.txt").toPath(), reply.getData());
			Packet read;
			try {
				read = (Packet)client.deserialize("file2.txt");
				System.out.println(read.toString());
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			*/
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		/*
		DatagramSocket aSocket = null;
		Scanner scanner = null;
		*/
		
		/*
		try {
			// args contain server hostname
			if (args.length < 1) {
				System.out.println("Usage: UDPClient <server host name>");
				System.exit(-1);
			}
			byte[] buffer = new byte[1024];
			InetAddress aHost = InetAddress.getByName(args[0]);
			int serverPort = 9876;
			aSocket = new DatagramSocket();
			scanner = new Scanner(System.in);
			String line = "";
			while (true) {
				System.out.println("Enter your request (+,-,?,!)|nick|...|");
				if (scanner.hasNextLine())
					line = scanner.nextLine();
				DatagramPacket request = new DatagramPacket(line.getBytes(), line.length(), aHost, serverPort);
				aSocket.send(request);
				DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
				aSocket.receive(reply);
				System.out.println("Reply: " + new String(reply.getData(), 0, reply.getLength()));
			}
		} catch (SocketException ex) {
			Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
		} catch (UnknownHostException ex) {
			Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			aSocket.close();
			scanner.close();
		}
		
		
	
	*/
	}
		private boolean serialize(Object obj, String path) {
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

	private Object deserialize(String path) throws ClassNotFoundException {
		Object obj = null;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
			obj = in.readObject();
			in.close();
			System.out.println("Serialized data is retrieved from " + path);
			return obj;
		} catch (IOException i) {
			i.printStackTrace();
			return obj;
		}
	}
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

}