package controller;
import view.AdminView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InflateAction implements ActionListener {
	private AdminView av;
	
	public InflateAction(AdminView av) {
		this.av =av;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		av.inflate();
	}

}
