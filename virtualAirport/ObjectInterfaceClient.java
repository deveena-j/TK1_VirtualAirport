package virtualAirport;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


public interface ObjectInterfaceClient extends Remote {
	
	//this method is used to distribute changes on the server to all the clients
	//void clientReceiveUpdatedFlights() throws RemoteException;
	
	void testDistribute(String test) throws RemoteException;
	
	void receiveUpdatedFlightList(ArrayList<String> uptlist) throws RemoteException;
}

