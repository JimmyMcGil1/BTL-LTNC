package controller;
import view.AdminView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class changeAction implements ActionListener {
	private AdminView av;
	
	public changeAction(AdminView av) {
		this.av = av;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		av.changeBy();
	}

}
