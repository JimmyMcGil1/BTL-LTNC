package demo;
import java.io.IOException;

import itemmodel.*;
import marketmodel.*;
import view.*;
public class Main {
	public static void main(String[] args) {
		StockManager.init();
		Stock a = new Stock(), b = new Stock(), c = new Stock();
		StockMarket HOSE = new StockMarket("HOSE");
		IndividualInvestor P1 = new IndividualInvestor(":D"), P2 = new IndividualInvestor(":P");
		HOSE.subscribe(P1);
		HOSE.subscribe(P2);
		a.init("ABC", "abc", 100, HOSE);
		b.init("BCD", "bDe", 100, HOSE);
		//System.out.println(HOSE.itemCount());
		//StockManager x = new StockManager();
		UserView uv = new UserView(P1);
		UserView uv2 = new UserView(P2);
		//uv2.setVisible(false);
		//AdminView av = new AdminView(x);
		StockMarketView smv = new StockMarketView(HOSE);
		 
	}
}
