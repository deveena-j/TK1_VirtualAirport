package virtualAirport;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Deleteflight extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblPleaseEnterThe;
	private JTextField textField;

	/**
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deleteflight frame = new Deleteflight();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 */
	public Deleteflight()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		lblPleaseEnterThe = new JLabel("Please enter the flight number that needs to be deleted: ");
		lblPleaseEnterThe.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPleaseEnterThe.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblPleaseEnterThe, BorderLayout.NORTH);
		
		JButton btnDelete = new JButton("Delete!");
		btnDelete.setBackground(UIManager.getColor("Button.focus"));
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(btnDelete, BorderLayout.SOUTH);
		
		btnDelete.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
				//call the delete function here and show the main page with updated deletion
				ClientGUI mainpg = new ClientGUI("Updated List");
				mainpg.setVisible(true);
				
			}
		});
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setMargin(new Insets(1, 1, 1, 1));
		textField.setForeground(new Color(0, 0, 128));
		textField.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(textField, BorderLayout.CENTER);
		textField.setColumns(1);
	}

}
