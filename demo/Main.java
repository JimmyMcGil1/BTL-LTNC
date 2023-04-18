package demo;
import java.io.IOException;

import javax.swing.UIManager;

import itemmodel.*;
import marketmodel.*;
import view.*;
public class Main {
	public static void main(String[] args) {
		StockManager.init();
		Stock[] s = new Stock[10];
		for(int i = 0; i < 10; i++) s[i] = new Stock();
		StockMarket HOSE = new StockMarket("HOSE");
		IndividualInvestor P1 = new IndividualInvestor(":D"), P2 = new IndividualInvestor(":P");
		BotAutoTradeInvestor t1 = new BotAutoTradeInvestor("Bot1");
		InvesmentFund f1 = new InvesmentFund("Berkshire Hathaway");
		//Khoi tao cac loai investor khac:
		//IIinvestor fund1 = new InvesmentFund(name:"Berkshire Hathaway");
		//IInvestor bot1 = new BotAutoTradeInvestor(name:"Bot1");
		

		HOSE.subscribe(P1);
		HOSE.subscribe(P2);
		HOSE.subscribe(f1);
		HOSE.subscribe(t1);
		
		//acording to 18/4/2023
		s[0].init("MobileWorld", "MWG", 40000, HOSE);
		s[1].init("Novaland", "NVL", 14850, HOSE);
		s[2].init("Petrolimex", "PLX", 36550, HOSE);
		s[3].init("Vietcombank", "VCB", 88200, HOSE);
		s[4].init("Vinamilk", "VNM", 72100, HOSE);
		s[5].init("Vingroup", "VIC", 52400, HOSE);
		
		//System.out.println(HOSE.itemCount());
		//StockManager x = new StockManager();
		/*try {
		    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch(Exception e){

		}*/
		
		UserView uv = new UserView(P1);
		UserView uv2 = new UserView(P2);
		BotTraderView btv = new BotTraderView(t1);
		InvestmentFundView ifv = new InvestmentFundView(f1);
		//uv2.setVisible(false);
		//AdminView av = new AdminView(x);
		StockMarketView smv = new StockMarketView(HOSE);
		 
	}
}
