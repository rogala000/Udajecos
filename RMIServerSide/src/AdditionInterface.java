import java.rmi.*;
     
public interface AdditionInterface extends Remote {
	public int add(int a,int b) throws RemoteException;
	public void zapis_do_ramki(Packet packet) throws RemoteException;
}