package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AdminView;

public class ggAction implements ActionListener {
	private AdminView av;
	
	public ggAction(AdminView av) {
		this.av = av;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		av.GovermentGrant();
	}

}
