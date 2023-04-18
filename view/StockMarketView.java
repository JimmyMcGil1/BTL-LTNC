package view;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import itemmodel.StockManager;
import marketmodel.*;
import controller.*;

public class StockMarketView extends JFrame {
	//Attributes:
		private StockMarket market;
		private JPanel titlePanel;
		private JPanel tablePanel;
		private JPanel commandPanel;
		private JPanel logPanel;
		private JTable table;
		
		//Methods:
		public StockMarketView(StockMarket market) {
			this.market = market;
			market.setView(this);
			init();
			this.setVisible(true);
		};
		
		private void init() {
			this.setSize(600,300);
			this.setLocationRelativeTo(null);
			this.setTitle("Simple market");
			//initialize
			titleSet();
			tablePanelSet();
			commandPanelSet();
			logSet();
			//
			this.setLayout(new BorderLayout());
			this.add(titlePanel, BorderLayout.NORTH);
			this.add(centerPanel(), BorderLayout.CENTER);
			this.add(logPanel, BorderLayout.SOUTH);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
		private void titleSet() {
			this.titlePanel = new JPanel();
			this.titlePanel.setLayout(new GridLayout(0,3));
			JLabel name = new JLabel(this.market.getName());
			name.setHorizontalAlignment(SwingConstants.CENTER);
			name .setFont(new Font("Arial", Font.BOLD, 15));
			this.titlePanel.add(name);
		}
		private void tablePanelSet() {
			this.tablePanel = new JPanel();
			String[] header = {"Name", "Symbol", "Price"};
			DefaultTableModel tb = new DefaultTableModel(header, 0); 
			DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
			System.out.println(this.market.itemCount());
 			for(int i = 0; i < this.market.itemCount(); i++) {
 				String[] s = {
 						this.market.getItem(i).getName(),
 						this.market.getItem(i).getID(),
 						this.market.getItem(i).getPrice() + ""
 				};
 				tb.addRow(s);
 			}
 			this.table = new JTable(tb);
 			//set center for data
 			cr.setHorizontalAlignment(SwingConstants.CENTER);
 			cr.setFont(new Font("Arial", Font.BOLD, 20));
 			table.getColumnModel().getColumn(1).setCellRenderer(cr);
 			table.getColumnModel().getColumn(2).setCellRenderer(cr);
 			//add scroll pane
 			JScrollPane sp = new JScrollPane(this.table);
			this.tablePanel.add(sp);
		}
		private void commandPanelSet() {
			this.commandPanel = new JPanel();
			this.commandPanel.setLayout(new FlowLayout());
			adminAction ac = new adminAction(this);
			JButton b1 = new JButton("Admin");
			b1.addActionListener(ac);
			this.commandPanel.add(b1);
			
		}
		private JPanel centerPanel() {
			JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout());
			panel.add(this.tablePanel, BorderLayout.WEST);
			panel.add(this.commandPanel, BorderLayout.CENTER);
			return panel;
		}
		private void logSet() {
			this.logPanel = new JPanel();			
		}
		public void showAdminSession() {
			StockManager sm = new StockManager();
			AdminView av = new AdminView(sm);
		}
		public void changeCell(int id, boolean color) {
			//DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
			//cr.setForeground(color ? Color.green : Color.red);
			table.setValueAt(market.getItem(id).getPrice(), id, 2);		
		}
}
