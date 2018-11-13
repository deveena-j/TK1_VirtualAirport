package virtualAirport;

import java.awt.*;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.KeyStroke;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import virtualAirport.rowData;
import virtualAirport.Deleteflight;


public class ClientGUI extends JFrame
{

	private JPanel contentPane;
	public String username;
	private JTable table;
	ArrayList<String> flightlist = new ArrayList<String>();
	String[] values;
	String IATACode = "";
	String CarrierName = "";
	String FlightNum = "";
	String DepartureAirport = "";
	String ArrivalAirport = "";
	
	
	/* 
	public static void main(String[] args)
	 {
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					ClientGUI frame = new ClientGUI("1234");
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		);
	}
	*/
	
		
	
	
	 // Create the frame.
	 
	public ClientGUI(final String username)
	{
		/*logic to retrieve flight list */
		
		try{
			ObjectInterfaceServer stub = (ObjectInterfaceServer)Naming.lookup("ObjectInterfaceServer");
			flightlist = stub.justCall();
		}catch(Exception e){
	        System.err.println("Server exception: " + e.toString());
	        e.printStackTrace();
		}
		
		

		this.username=username;
		setTitle("TK1 Schedule - "+ username);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 442, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		//populates the schedule page at run time from the flight list 
		
		JTable table = new JTable(new DefaultTableModel(new Object[]{ "IATA Code", "Name", "Flight No:", "Departure" , "Arrival" }, flightlist.size()));
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		System.out.println("Size of the flightlist array: "+ flightlist.size());
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.LEFT );
		table.setDefaultRenderer(String.class, centerRenderer);
		table.setShowGrid(false);
		table.setBorder(null);
		table.setFont(new Font("Arial", Font.PLAIN, 14));

		contentPane.add(table.getTableHeader(), BorderLayout.NORTH);
		contentPane.add(table); 
		
		//adding refresh button
		
		final JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setLocation(20,20);
		btnRefresh.setVerticalAlignment(SwingConstants.BOTTOM);
		btnRefresh.setBackground(UIManager.getColor("Button.background"));
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRefresh.setForeground(new Color(0, 0, 255));
		
		GridBagConstraints gbc_btnRefresh = new GridBagConstraints();
		gbc_btnRefresh.insets = new Insets(0, 0, 0, 5);
		gbc_btnRefresh.gridx = 2;
		gbc_btnRefresh.gridy = 8;
		contentPane.add(btnRefresh, gbc_btnRefresh);
		
		//action on hitting refresh
		
		btnRefresh.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
				ClientGUI refreshdata = new ClientGUI(username);
				refreshdata.setVisible(true);
			}});
		
		
		final JButton btnAdd = new JButton("Add");
		btnAdd.setLocation(20,20);
		btnAdd.setVerticalAlignment(SwingConstants.BOTTOM);
		btnAdd.setBackground(UIManager.getColor("Button.background"));
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdd.setForeground(new Color(0, 0, 255));
		
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdd.gridx = 2;
		gbc_btnAdd.gridy = 8;
		contentPane.add(btnAdd, gbc_btnAdd);
	
		/*get arraylist of flight*/
		for(int i=0; i<flightlist.size(); i++) {
			values = flightlist.get(i).split(";");
			IATACode = values[2];
			CarrierName = values[3];
			FlightNum = values[0];
			DepartureAirport = values[5];
			ArrivalAirport = values[6];
			model.addRow(new Object[]{IATACode,CarrierName,FlightNum,DepartureAirport,ArrivalAirport});
		}
		
		btnAdd.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
				rowData mainpg = new rowData(btnAdd.getText(),username);
				mainpg.setVisible(true);
			}});
		
		//edit button
		
		final JButton btnEdit = new JButton("Edit");
		btnEdit.setForeground(Color.BLUE);
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.insets = new Insets(0, 0, 0, 5);
		gbc_btnEdit.gridx = 3;
		gbc_btnEdit.gridy = 8;
		contentPane.add(btnEdit, gbc_btnEdit);
		
		btnEdit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
				//getting flight number from click
				int srow = table.getSelectedRow();
				int scolumn = table.getSelectedColumn();
				String extractFlight = table.getValueAt(srow, scolumn).toString();
				editFlight callEdit = new editFlight(extractFlight);
				callEdit.setVisible(true);
			}});
		
		
		//delete button
		
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setForeground(Color.BLUE);
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 0, 5);
		gbc_btnDelete.gridx = 4;
		gbc_btnDelete.gridy = 8;
		contentPane.add(btnDelete, gbc_btnDelete);
		
		
		btnDelete.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
				//getting flight from click
				int srow1 = table.getSelectedRow();
				int scolumn1 = table.getSelectedColumn();
				String extractFlightNum = table.getValueAt(srow1, scolumn1).toString();
				//calling the delete flight function
				try{
					ObjectInterfaceServer stub = (ObjectInterfaceServer)Naming.lookup("ObjectInterfaceServer");
					stub.deleteFlight(extractFlightNum);
				}catch(Exception ex){
			        System.err.println("Server exception: " + e.toString());
			        ex.printStackTrace();
				}
				//Deleteflight mainpg = new Deleteflight();
				//mainpg.setVisible(true);
			}});
		
		JLabel Note= new JLabel("Please select the flight number before trying to edit any information");
		contentPane.add(Note);
		
	}
	
	}
	
