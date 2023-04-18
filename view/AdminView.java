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
	private JTextField error_msg;
	private JTextField inflateTF;
	private JTextField nameTF;
	private JTextField ggTF;
	private JTextField percentageTF;
	private static boolean show = false;
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
		//initialize title panel
		this.titlePanelSet();
		//initialize command panel
		this.commandPanelSet();
					
		this.setLayout(new BorderLayout());
		this.add(titlePanel, BorderLayout.NORTH);
		this.add(commandPanel, BorderLayout.CENTER);
		//initialize error log
		this.add(this.errorLogSet(), BorderLayout.SOUTH);
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
		//GovermentGrant
		JLabel ggTitle = new JLabel("Goverment grant:");
		this.ggTF = new JTextField();
		JButton ggChange = new JButton("Change");
		ggAction ga = new ggAction(this);
		ggChange.addActionListener(ga);
		commandPanel.add(ggTitle);
		commandPanel.add(ggTF);
		commandPanel.add(ggChange);
		//
		GroupLayout gl = new GroupLayout(commandPanel);
		commandPanel.setLayout(gl);
		gl.setAutoCreateGaps(true);
		gl.setAutoCreateContainerGaps(true);
		gl.setHorizontalGroup(
				gl.createSequentialGroup()
					.addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(inflateTitle)
							.addComponent(ggTitle)
							.addComponent(changeByTitle))
							//add new command name here
					.addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(inflateTF)
							.addComponent(ggTF)
							.addGroup(gl.createSequentialGroup()
									.addComponent(nameTF)
									.addComponent(percentageTF))
							//add new command arguments here
							)
					.addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(inflateChange)
							.addComponent(ggChange)
							.addComponent(changeByChange))
							//add new command button here
		);
		gl.setVerticalGroup(
				gl.createSequentialGroup()
					.addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(inflateTitle)
							.addComponent(inflateTF)
							.addComponent(inflateChange))
					.addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(ggTitle)
							.addComponent(ggTF)
							.addComponent(ggChange))
					.addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(changeByTitle)
							.addComponent(nameTF)
							.addComponent(percentageTF)
							.addComponent(changeByChange))
					//add new command config here
		);
	}
	private JPanel errorLogSet() {
		JPanel errorPanel = new JPanel();
		this.error_msg = new JTextField();
		this.error_msg.setEditable(false);
		errorPanel.setLayout(new BorderLayout());
		//add empty panel
		errorPanel.add(new JPanel(), BorderLayout.NORTH);
		errorPanel.add(new JPanel(), BorderLayout.WEST);
		errorPanel.add(new JPanel(), BorderLayout.EAST);
		errorPanel.add(new JPanel(), BorderLayout.SOUTH);
		//add error log
		errorPanel.add(this.error_msg, BorderLayout.CENTER);
		return errorPanel;
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
			this.error_msg.setHorizontalAlignment(0);
			this.error_msg.setFont(new Font("Arial", Font.BOLD, 13));
			this.error_msg.setBackground(Color.red);
			return;
		}
		this.stck.inflate(percentage);
	}
	public void changeBy() {
		this.error_msg.setText(null);
		this.error_msg.setBackground(null);
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
			this.error_msg.setHorizontalAlignment(0);
			this.error_msg.setFont(new Font("Arial", Font.BOLD, 13));
			this.error_msg.setBackground(Color.red);
			return;
		}
	}
	public void GovermentGrant() {
		this.error_msg.setText("");
		String tmp = this.ggTF.getText();
		this.ggTF.setText(null);
		float amountOfMoney = 0;
		if(tmp.isBlank()) return;
		try {
			amountOfMoney = Float.parseFloat(tmp);
		}
		catch(Exception e) {
			this.error_msg.setText("Invalid input!");
			this.error_msg.setHorizontalAlignment(0);
			this.error_msg.setFont(new Font("Arial", Font.BOLD, 13));
			this.error_msg.setBackground(Color.red);
			return;
		}
		this.stck.GovernmenGrant(amountOfMoney);
	}
	public void view() {
		if(!show) this.setVisible(true);
		this.show = true;
	}
	
	
}
