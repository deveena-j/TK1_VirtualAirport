import java.rmi.*;
import java.util.*;

public interface ObjectInterface extends Remote{
	
		//login method
		void login(String uname) throws RemoteException;
		//logout method
		void logout(String uname) throws RemoteException;
		//add flight method
		String addFlight(String flightdetail) throws RemoteException;
		//update flight method
		String updateFlight(ArrayList<String> changes, String flightnum) throws RemoteException;
		//delete flight method
		String deleteFlight(String flnum) throws RemoteException;
		//receive list of flights method
		ArrayList<String> flightDetails() throws RemoteException;


}
