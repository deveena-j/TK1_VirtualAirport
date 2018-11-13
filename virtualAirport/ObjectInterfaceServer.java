package virtualAirport;

import java.rmi.*;
import java.util.*;

public interface ObjectInterfaceServer extends Remote{
	
		//login method passes object of client interface for callback
		void login(ObjectInterfaceClient loginobject) throws RemoteException;
		//logout method passes object of client interface for callback
		void logout(ObjectInterfaceClient logoutobject) throws RemoteException;
		//add flight method
		void addFlight(String flightdetail) throws RemoteException;
		//update flight method
		void updateFlight(String changes, int position, String flightnum) throws RemoteException;
		//delete flight method
		void deleteFlight(String flnum) throws RemoteException;
		//receive list of flights method
		void flightDetails() throws RemoteException;
		//just returns a list of flights
		ArrayList<String> justCall() throws RemoteException;


}
