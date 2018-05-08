    import java.rmi.*;
     
    public class AdditionClient {
    	public static void main (String[] args) {
    		AdditionInterface hello;
    		try {
    			hello = (AdditionInterface)Naming.lookup("rmi://localhost/ABC");
    			
    			Integer[] arr = new Integer[3];
    			Spectrum<Integer> spektrum = new Spectrum<Integer>(true, 5, "km", 3.0,  arr, "device1", "Opis1", 435345);
//    			Spectrum<Integer> spektrum2 = new Spectrum<Integer>(true, 5, "km", 3.0,  arr, "device2", "Opis2", 435345);
//    			Spectrum<Integer> spektrum3 = new Spectrum<Integer>(true, 5, "km", 3.0,  arr, "device3", "Opis3", 435345);
//
//    			TimeHistory<Integer> time_history = new TimeHistory<Integer>(5, 5, "km", 3.0,  arr, "Device4", "Opis4", 435345);
//    			TimeHistory<Integer> time_history2 = new TimeHistory<Integer>(5, 5, "km", 3.0,  arr, "Device5", "Opis5", 435345);
//    			TimeHistory<Integer> time_history3 = new TimeHistory<Integer>(5, 5, "km", 3.0,  arr, "Device6", "Opis6", 435345);

    			hello.zapis_do_ramki(spektrum);
//    			hello.zapis_do_ramki(spektrum2);
//    			hello.zapis_do_ramki(spektrum3);
//
//    			hello.zapis_do_ramki(time_history);
//    			hello.zapis_do_ramki(time_history2);
//    			hello.zapis_do_ramki(time_history3);

    			
    			int result=hello.add(9,10);
    			System.out.println("Result is :"+result);
     
    			}catch (Exception e) {
    				System.out.println("HelloClient exception: " + e);
    				}
    		}
    }