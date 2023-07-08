package com.jdbc.practice;
import java.awt.Font;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jdbc.practice.ConnectionProvider;

public class DisplayImage {

	private JFrame frame;
	private JTextField field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayImage f = new DisplayImage();
//					f.setLocationRelativeTo(null);
					f.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DisplayImage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 748, 576);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		field = new JTextField();
		field.setBounds(221, 68, 136, 48);
		field.setFont(new Font("Arial", Font.PLAIN, 16)); 
		frame.getContentPane().add(field);
		field.setColumns(10);
		
		JLabel imageLabel = new JLabel("");
		imageLabel.setBounds(82, 190, 561, 319);
		frame.getContentPane().add(imageLabel);
		
		JButton button = new JButton("Show Image");
		button.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try {
					String str=field.getText();
					int id =Integer.parseInt(str);
					ImageIcon icon = Helper.getImageIconById(id, ConnectionProvider.getConnection());
					if(icon==null) {
						JOptionPane.showMessageDialog(null, "no image is found of your id");
					}
					else {
						imageLabel.setIcon(icon);
					}
					
				} catch (Exception n) {
					n.printStackTrace();
				}
				
				
			}
		});
		button.setBounds(382, 67, 136, 48);
		button.setFont(new Font("Arial", Font.PLAIN, 16)); 
		frame.getContentPane().add(button);
		
		
	}
}
