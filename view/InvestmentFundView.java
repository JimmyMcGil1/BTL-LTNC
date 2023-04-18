package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import marketmodel.IndividualInvestor;
import marketmodel.InvesmentFund;

public class InvestmentFundView extends JFrame {
	/*
	 * provide ui for user
	 * provide the mean for user to get message from market
	 */
	//Attributes:
	private InvesmentFund investor;
	private JPanel titlePanel;
	private JPanel logPanel;
	private JTextPane MsgTP;
	
	//Methods:
	public InvestmentFundView(InvesmentFund investor) {
		this.investor = investor;
		investor.setUserView(this);
		init();
		this.setVisible(true);
	}
	
	public void init() {
		this.setTitle("User Window");
		this.setSize(200,200);
		this.setLocationRelativeTo(null);
		
		logPanelSet();
		
		this.add(logPanel);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	private void titlePanelSet() {
		this.titlePanel = new JPanel();
		titlePanel.setLayout(new BorderLayout());
		JLabel title = new JLabel(this.investor.getName());
		this.titlePanel.add(title, BorderLayout.CENTER);
	}
	private void logPanelSet() {
		this.logPanel = new JPanel();
		this.MsgTP = new JTextPane();
		JScrollPane sp = new JScrollPane(MsgTP);
		SimpleAttributeSet as = new SimpleAttributeSet();
		this.MsgTP.setCharacterAttributes(as, true);
		//this.MsgTP.setPreferredSize(new Dimension(100,100));
		GridBagLayout layout = new GridBagLayout();
		this.logPanel.setLayout(layout);
		//Set a grid bag layout with 16x16 grids
		GridBagConstraints gbc = new GridBagConstraints();
		//bottom right corner set
		gbc.gridx = 15;
		gbc.gridy = 15;
		gbc.weightx = 1;
		gbc.weighty = 1;
		this.logPanel.add(new JPanel(), gbc);
		//top left corner set
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.logPanel.add(new JPanel(), gbc);
		//log panel set
		gbc.gridx = 8;
		gbc.gridy = 8;
		gbc.weightx = 6;
		gbc.weighty = 6;
		gbc.fill = GridBagConstraints.BOTH;	
		this.logPanel.add(sp, gbc);
		//title panel set
		titlePanelSet();
		gbc.gridy = 0;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.fill = GridBagConstraints.NONE;
		this.logPanel.add(this.titlePanel, gbc);
	}
	public void msgUpdate() {
		/*
		 * This function's version is almost finished 
		 * However, font is not perfect
		 * So, will change font later.
		 */
		this.MsgTP.setText(null);
		SimpleAttributeSet as;
		Document doc = this.MsgTP.getStyledDocument();
		try {
			for(int i = 0; i < 10; i++) 
				if(this.investor.getMsg(i) != null) {
					String tmp = investor.getMsg(i);
					int partionPoint = tmp.indexOf("(");
					//get name of item
					String part1 = tmp.substring(0, partionPoint);
					//get id of item
					String part2 = tmp.substring(partionPoint+1, partionPoint+4);
					//get message of item from market
					String part3 = tmp.substring(partionPoint+5,tmp.length());
					//modifying text
					as = new SimpleAttributeSet();
					StyleConstants.setBold(as, true);
					StyleConstants.setFontFamily(as, Font.SERIF);
					doc.insertString(doc.getLength(), part1 + "(", as);
					
					as = new SimpleAttributeSet();
					StyleConstants.setItalic(as, true);
					StyleConstants.setForeground(as, Color.red);
					StyleConstants.setFontFamily(as, Font.SERIF);
					doc.insertString(doc.getLength(), part2, as);
					
					as = new SimpleAttributeSet();
					StyleConstants.setFontFamily(as, Font.SANS_SERIF);
					doc.insertString(doc.getLength(), ")" + part3 + "\n", as);
				}
		}
		catch(Exception e) {
			System.out.println("Bad alloc");
		}
	}
}

