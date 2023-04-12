package view;
import java.awt.*;
import javax.swing.*;

import controller.*;
import itemmodel.StockManager;

public class AdminView extends JFrame {
	/**
	 * 
	 */
	//Attributes:
	/*
	 * provide gui for admin user
	 */
	private StockManager stck;
	private JPanel titlePanel;
	private JPanel commandPanel;
	private JLabel error_msg;
	private JTextField inflateTF;
	private JTextField nameTF;
	private JTextField percentageTF;
	
	//Methods:
	public AdminView(StockManager stck) {
		this.stck = stck;
		init();
		view();
	}
	
	public void init() {
		this.setTitle("Admin window");
		this.setSize(500,300);
		this.setLocationRelativeTo(null);
		
		this.titlePanelSet();
		this.commandPanelSet();
					
		this.error_msg = new JLabel("");
		this.setLayout(new BorderLayout());
		this.add(titlePanel, BorderLayout.NORTH);
		this.add(commandPanel, BorderLayout.CENTER);
		this.add(error_msg, BorderLayout.SOUTH);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	private void titlePanelSet() {
		this.titlePanel = new JPanel();
		JLabel title = new JLabel("Command:");
		titlePanel.add(title);
	}
	private void commandPanelSet() {
		this.commandPanel = new JPanel();
		//Inflate
		JLabel inflateTitle = new JLabel("Inflate:");
		this.inflateTF = new JTextField();
		JButton inflateChange = new JButton("Change");
		InflateAction ia = new InflateAction(this);
		inflateChange.addActionListener(ia);
		commandPanel.add(inflateChange);
		commandPanel.add(inflateTF);
		commandPanel.add(inflateTitle);
		//ChangeBy
		JLabel changeByTitle = new JLabel("Change stock x by:");
		this.nameTF = new JTextField();
		this.percentageTF = new JTextField();
		JButton changeByChange = new JButton("Change");
		changeAction ca = new changeAction(this);
		changeByChange.addActionListener(ca);
		commandPanel.add(changeByTitle);
		commandPanel.add(nameTF);
		commandPanel.add(percentageTF);
		commandPanel.add(changeByChange);
		//
		GroupLayout gl = new GroupLayout(commandPanel);
		commandPanel.setLayout(gl);
		gl.setAutoCreateGaps(true);
		gl.setAutoCreateContainerGaps(true);
		gl.setHorizontalGroup(
				gl.createSequentialGroup()
					.addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(inflateTitle)
							.addComponent(changeByTitle))
					.addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(inflateTF)
							.addGroup(gl.createSequentialGroup()
								.addComponent(nameTF)
								.addComponent(percentageTF)))
					.addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(inflateChange)
							.addComponent(changeByChange))
		);
		gl.setVerticalGroup(
				gl.createSequentialGroup()
					.addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(inflateTitle)
							.addComponent(inflateTF)
							.addComponent(inflateChange))
					.addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(changeByTitle)
							.addComponent(nameTF)
							.addComponent(percentageTF)
							.addComponent(changeByChange))
		);
	}
	public void inflate() {
		this.error_msg.setText("");
		String tmp = this.inflateTF.getText();
		this.inflateTF.setText(null);
		float percentage = 0;
		if(tmp.isBlank()) return;
		try {
			percentage = Float.parseFloat(tmp);
		}
		catch(Exception e) {
			this.error_msg.setText("Invalid input!");
			return;
		}
		this.stck.inflate(percentage);
	}
	public void changeBy() {
		this.error_msg.setText("");
		String id = this.nameTF.getText();
		String tmp = this.percentageTF.getText();
		this.nameTF.setText(null);
		this.percentageTF.setText(null);
		float percentage = 0;
		try {
			percentage = Float.parseFloat(tmp);
			this.stck.changeBy(id, percentage);
		}
		catch(Exception e) {
			this.error_msg.setText("Invalid input!");
			return;
		}
	}
	public void view() {
		this.setVisible(true);
	}
	
}
