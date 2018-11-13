package virtualAirport;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.util.ArrayList;

import javax.swing.JButton;


public class editFlight extends JFrame {
	ArrayList<String> flightlist = new ArrayList<String>();
	String values = "";
	String[] valuelist;

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_4;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JComboBox comboBox;
	private JLabel lblFlightStatus;
	
	int position = 0;
	
	String IATAcode="";
	String ModelName = "";
	String FlightNumber = "";
	String DepartureAirport = "";
	String OriginDate = "";
	String ScheduledDeparture = "";
	String DepartureTerminal = "";
	String DepartureGates = "";
	String EstimatedDeparture = "";
	String CheckInLocation = "";
	String OperatingAirlines = "";
	String CheckInCounter = "";
	String CheckInStart = "";
	String ArrivalAirport = "";
	String ScheduledArrival = "";
	String ArrivalTerminal = "";
	String Arrivalgate = "";
	String EstimatedArrival = "";
	String CheckInEnd = "";
	String FlightStatusVar = "";
	
	

	/**
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rowData frame = new rowData();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 */
	
	public editFlight(String flightnum) 
	{
		//calling the add flight function
		try{
			ObjectInterfaceServer stub = (ObjectInterfaceServer)Naming.lookup("ObjectInterfaceServer");
			flightlist = stub.justCall();
		}catch(Exception ex){
	        System.err.println("Server exception: " + ex.toString());
	        ex.printStackTrace();
		}
		
		//looping through all flights on the list
		for(int i=0; i<flightlist.size(); i++) {
			valuelist = flightlist.get(i).split(";");
			if(valuelist[0].equals(flightnum)) {
				//if passed flightnumber is matched
				position  = i;
				IATAcode = valuelist[2];
			    ModelName = valuelist[4];
			    FlightNumber = valuelist[0];
			    DepartureAirport = valuelist[5];
			    OriginDate = valuelist[7];
			    ArrivalAirport = valuelist[6];
			    OperatingAirlines = valuelist[3];
			    //ScheduledDeparture = 
			    ScheduledArrival = valuelist[8];
			    ArrivalTerminal = valuelist[9];
			    Arrivalgate = valuelist[10];
			    EstimatedArrival = valuelist[11];
			    ScheduledDeparture = valuelist[12];
			    DepartureTerminal = valuelist[13];
			    DepartureGates = valuelist[14];
			    EstimatedDeparture = valuelist[15];
			    CheckInLocation = valuelist[16];
			    CheckInCounter = valuelist[17];
			    CheckInStart = valuelist[18];
			    CheckInEnd = valuelist[19];
			    
			    
			    
			}
		}
		
		setTitle("Editing flight");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1022, 606);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("IATA Code");
		
		JLabel lblNewLabel_1 = new JLabel("Model Name");
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setText(IATAcode);
		//System.out.println(textField.getText());
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setText(DepartureAirport);
		
		JLabel lblNewLabel_2 = new JLabel("Flight Number");
		
		JLabel lblDepartureAirport = new JLabel("Departure Airport");
		
		JLabel lblOriginData = new JLabel("Origin Date");
		
		JLabel lblScheduledDeparture = new JLabel("Scheduled Departure");
		
		JLabel lblDepartureTerminal = new JLabel("Departure Terminal");
		
		JLabel lblDepartureGates = new JLabel("Departure Gates");
		
		JLabel lblEstimatedDeparture = new JLabel("Estimated Departure");
		
		JLabel lblCheckInLocation = new JLabel("Check In Location");
		
		JLabel lblNewLabel_3 = new JLabel("Operating Airlines");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setText(OperatingAirlines);
		
		JLabel lblCheckInCounter = new JLabel("Check In Counter");
		
		JLabel lblCheckInTime = new JLabel("Check In Start");
		
		JLabel lblArrivalAirport = new JLabel("Arrival Airport");
		
		JLabel lblScheduledArrival = new JLabel("Scheduled Arrival");
		
		JLabel lblArrivalTerminal = new JLabel("Arrival Terminal");
		
		JLabel lblArrivalGate = new JLabel("Arrival Gate");
		
		JLabel lblEstimatedArrival = new JLabel("Estimated Arrival");
		
		JLabel lblCheckInEnd = new JLabel("Check In End");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setText(OriginDate);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setText(ScheduledDeparture);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setText(ModelName);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setText(FlightNumber);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setText(DepartureTerminal);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setText(DepartureGates);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setText(EstimatedDeparture);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setText(CheckInLocation);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setText(CheckInCounter);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setText(CheckInStart);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setText(ArrivalAirport);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setText(ScheduledArrival);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setText(ArrivalTerminal);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setText(Arrivalgate);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setText(EstimatedArrival);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setText(CheckInEnd);
		
		
		
		comboBox = new JComboBox();
		comboBox.addItem("B");
		comboBox.addItem("D");
		comboBox.addItem("I");
		comboBox.addItem("L");
		comboBox.addItem("M");
		comboBox.addItem("S");
		comboBox.addItem("X");
		comboBox.addItem("Y");
		comboBox.addItem("Z");
		
		//for flight status
		String comboinput = comboBox.getEditor().getItem().toString();
		
		lblFlightStatus = new JLabel("Flight Status");
		lblFlightStatus.setBackground(new Color(204, 204, 204));
		lblFlightStatus.setForeground(new Color(204, 0, 51));
		lblFlightStatus.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
				
				/*creating string to add to flightlist*/
				//flight number
				values = values + textField_7.getText() +";";
				//direction marker (HAVE TO MAKE DYNAMIC
				values = values + "1;";
				//IATA code
				values = values + textField.getText() + ";";
				//Operator
				values = values + textField_2.getText() + ";";
				//Model name
				values = values + textField_6.getText() + ";";
				//departure airport
				values = values + textField_1.getText() + ";";
				//arrival airport
				values = values + textField_13.getText() + ";";
				//origin date
				values = values + textField_3.getText() + ";";
				//scheduled arrival
				values = values + textField_14.getText() + ";";
				//arrival terminal
				values = values + textField_15.getText() + ";";
				//arrival gate
				values = values + textField_16.getText() + ";";
				//estimated arrival
				values = values + textField_17.getText() + ";";
				//scheduled departure
				values = values + textField_14.getText() + ";";	
				//departure terminal
				values = values + textField_5.getText() + ";";
				//departure gate
				values = values + textField_18.getText() + ";";
				//estimated departure
				values = values + textField_9.getText() + ";";
				//check in location
				values = values + textField_10.getText() + ";";
				//check in counter
				values = values + textField_11.getText() + ";";
				//check in start
				values = values + textField_12.getText() + ";";
				//check in end
				values = values + textField_18.getText() + ";";
				//fight status
				values = values + comboinput;
				
				
				
				//calling the add flight function
				try{
					ObjectInterfaceServer stub = (ObjectInterfaceServer)Naming.lookup("ObjectInterfaceServer");
					stub.updateFlight(values, position, flightnum);
				}catch(Exception ex){
			        System.err.println("Server exception: " + e.toString());
			        ex.printStackTrace();
				}
				
				//Call the receive function to update the server and then show the updated list back
				/*ClientGUI mainpg = new ClientGUI(username);
				mainpg.setVisible(true);*/
			}});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_contentPane.createSequentialGroup()
															.addComponent(lblNewLabel)
															.addPreferredGap(ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
															.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
														.addGroup(gl_contentPane.createSequentialGroup()
															.addComponent(lblNewLabel_1)
															.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
															.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
														.addGroup(gl_contentPane.createSequentialGroup()
															.addComponent(lblNewLabel_2)
															.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
															.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
													.addPreferredGap(ComponentPlacement.UNRELATED))
												.addGroup(gl_contentPane.createSequentialGroup()
													.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(lblDepartureAirport)
														.addComponent(lblCheckInTime)
														.addComponent(lblCheckInCounter)
														.addComponent(lblCheckInLocation))
													.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
													.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
													.addGap(11)))
											.addGap(121))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblOriginData)
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblScheduledDeparture)
										.addPreferredGap(ComponentPlacement.RELATED)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblDepartureTerminal)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblDepartureGates)
								.addPreferredGap(ComponentPlacement.RELATED)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblEstimatedDeparture)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblArrivalTerminal)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblScheduledArrival)
									.addComponent(lblNewLabel_3))
								.addComponent(lblArrivalAirport)
								.addComponent(lblArrivalGate)
								.addComponent(lblEstimatedArrival)
								.addComponent(lblCheckInEnd))
							.addGap(33)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_18, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(344, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(302, Short.MAX_VALUE)
					.addComponent(lblFlightStatus)
					.addGap(18)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addGap(521))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(885, Short.MAX_VALUE)
					.addComponent(btnConfirm)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_3)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblArrivalAirport)
								.addComponent(lblDepartureAirport)
								.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblOriginData)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblScheduledDeparture)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblScheduledArrival)
								.addComponent(textField_14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblArrivalTerminal)
								.addComponent(lblDepartureTerminal)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(7)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDepartureGates)
						.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblArrivalGate)
						.addComponent(textField_16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEstimatedDeparture)
								.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEstimatedArrival))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblCheckInLocation)
								.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCheckInCounter)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addComponent(textField_18, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCheckInTime)
						.addComponent(lblCheckInEnd)
						.addComponent(textField_17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(55)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFlightStatus))
					.addGap(84)
					.addComponent(btnConfirm)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
