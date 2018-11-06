import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import java.io.*;


public class Server extends UnicastRemoteObject implements ObjectInterface, Serializable {
	
	//ArrayList for constructor initilization
	private ArrayList<String> flightlist;
	private String stringreturn;
	private ArrayList<String> userlist;
	
	//mandatory serilization ID
	private static final long serialVersionUID = 1L;
	
	
	protected Server(ArrayList<String> list) throws RemoteException {
		super();
		this.flightlist = list;
		// explicit constructor declaration
		//now flightlist will contain the first two dummy flights
	}

public ArrayList<String> flightDetails() {
	//this function returns a list of all flights

	return flightlist;
	}

public static ArrayList<String> initializeFlights() {
	
			//this function intializes the list with a couple of flights
			//adding a couple of predefined flight entries
			//List to store flight info. Flight details stored as semi-colon delimited line
			ArrayList<String> flightDetail = new ArrayList<String>();
			//entry number 1 (arrival)
			flightDetail.add(0, "LH591;1;LH;Lufthansa;A380;FRA;TK;2018-10-30;2018-10-30T01:00:00Z;T1;5;2018-10-30T02:00:00Z;X");
			//entry number 2 (arrival)
			flightDetail.add(1, "LH592;1;LH;Lufthansa;A380;FRA;TK;2018-10-30;2018-10-30T01:00:00Z;T1;5;2018-10-30T02:00:00Z;X");
			//return initilaized list of flights
			return(flightDetail);
}

public String deleteFlight(String flnum) throws RemoteException {
	//this method deletes the flight requested by the client
	//takes as input Flight Number
	String[] values;
	//flightlist contains current list of flights
	//iterate through all flights and compare the Flight Code to locate the one to delete
	for(int i=0; i<flightlist.size(); i++){
		//obtain the Flight Code by accessing the first value of the semi-colon separated string
		values = flightlist.get(i).split(";");
		if (flnum.equals(values[0])) {
			flightlist.remove(i);
			stringreturn = "Modification Successful";
		}
		
	}
	
	//return status of delete
	return(stringreturn);
	
}

public String updateFlight(ArrayList<String> changes, String flightnum) throws RemoteException {
	//takes as input a list of changes. Each change is a string consisting of three values.
	//separated by a semi-colon. First value - Flight code. Second value - updated field value
	//Third value is the position of the field in the string
	
	String[] updatevalues_1 = null;
	String[] updatevalues_2 = null;
	String updatefinal = "";
	//flightlist contains current list of flights
	//nested for loops to make the changes
	for(int i=0; i<flightlist.size(); i++) {
		updatevalues_1 = flightlist.get(i).split(";");
		if(flightnum.equals(updatevalues_1[0])) {
			//if the flightnumber is matched, then perform update on this list entry
			for(int j=0; j<changes.size(); j++) {
				updatevalues_2 = changes.get(j).split(";");}
				//first value will contain the updated field value
				//second value will the index position within the flight list entry
				updatevalues_1[Integer.parseInt(updatevalues_2[0])] = updatevalues_2[1];
				//convert the array back to string
				for(int k=0; k<updatevalues_1.length; k++) {
					updatefinal = updatefinal + updatevalues_1[0] + ";" ;
				}
				//adding updated string back to list
				//substring function used to remove the last ';' character
				flightlist.add(i, updatefinal.substring(0, updatefinal.length() - 1));
				
			}
		}
	return stringreturn;
	
	}


public String addFlight(String flightdetail) throws RemoteException {
	//this method enables user to add flight with details. Accepts String as input
	flightlist.add(flightdetail);
	stringreturn = "Flight added successfully";
	return stringreturn;
}


public void login(String uname) throws RemoteException {
	
	userlist.add(uname);
}


public void logout(String uname) throws RemoteException {
	
	userlist.remove(uname);
}


public static void main(String args[]) {
	
	    try{
	    
	   Naming.rebind("FlightInterface", new Server(initializeFlights()));
		} catch(Exception e) {
			System.err.println("System Exception :" + e.toString());
			e.printStackTrace();
		}
		
		
	
}




}
