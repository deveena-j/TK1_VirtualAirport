package virtualAirport;


import java.awt.EventQueue;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import virtualAirport.loginPage;
import virtualAirport.ObjectInterfaceClient;
import virtualAirport.ClientGUI;

import javax.swing.*;

public class Client extends UnicastRemoteObject implements ObjectInterfaceClient{
	
	//mandatory default serialization ID
	private static final long serialVersionUID = 1L;
	public static String globalusername = "";


	public Client() throws RemoteException {};
	
	/*this is a test method implementation. To be removed*/
	
	public void testDistribute(String test) {
		
		System.out.println("This was passed " + test);
		
	}
	
	
	
	/*implementation of callback method to distribute updated flight list*/
	
	public void receiveUpdatedFlightList(ArrayList<String> uptlist) {
		System.out.println("Reached");
		ClientGUI newcall = new ClientGUI("User");
		newcall.setVisible(true);
	}

	
	public static void main(String args[]) {
	//looking up the server in the registry
	//interface_lookup = (ObjectInterfaceServer) Naming.lookup("//localhost/FlightInterface");
	
		
		
			String host = (args.length < 1) ? null : args[0];
		try {
            Registry registry = LocateRegistry.getRegistry(host);
            ObjectInterfaceServer stub = (ObjectInterfaceServer) registry.lookup("ObjectInterfaceServer");
            
            /*declaring client interface object*/
            ObjectInterfaceClient newclient = new Client();
            
            
       //calling the loginPage.java page
            EventQueue.invokeLater(new Runnable() {
    			public void run() {
    				try {
    					loginPage frame = new loginPage();
    					frame.setVisible(true);
    					String txt = frame.doLoginPage();
    					System.out.println(txt);
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
    			}
    		});

      
     
	
	
	stub.login(newclient);
	
	/*stub.addFlight(flightdetail);
	 * Uncomment the above to use it to call addFlight
	 */
	
	/*stub.deleteFlight(flnum);
	 * Uncomment the above to use it to call deleteFlight
	 */
	
	
	/*stub.updateFlight(changes, flightnum);
	 * Uncomment the above to use it to call updateFlight
	 */
	
	/*stub.logout(newClient);
	 * Uncomment this to use the logout function
	 */
	
	
	
	}catch (Exception e) {
        System.err.println("Server exception: " + e.toString());
        e.printStackTrace();
	}
	}}
