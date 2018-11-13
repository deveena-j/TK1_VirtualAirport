package virtualAirport;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;



public class loginPage extends JFrame {

	private JPanel contentPane;
	public JTextField username;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginPage frame = new loginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public void loginPage() {}
	
	public String doLoginPage() 
	{
		//setting the title and frame data
		setTitle("Log in TK1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 311, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel userlabel = new JLabel("Please enter your username:");
		userlabel.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		contentPane.add(userlabel);
		
		username = new JTextField();
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		username.setColumns(20);
		contentPane.add(username);
	
		btnNewButton = new JButton("Login!");
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnNewButton.setBounds(10, 50, 90, 70);
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
				ClientGUI mainpg = new ClientGUI(username.getText());
				mainpg.setVisible(true);		
			}
		});
		contentPane.add(btnNewButton);
		
		//returning username to Client.java
	      return username.getText();
	
	}
	

}
