package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.StockMarketView;

public class adminAction implements ActionListener {
	private StockMarketView smv;
	public adminAction(StockMarketView smv) {
		this.smv = smv;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		smv.showAdminSession();
	}

}
