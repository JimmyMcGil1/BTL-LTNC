package itemmodel;

import marketmodel.*;

public class Stock extends Item {
	//Attributes:
		/*
		 * name  : String
		 * id 	 : String
		 * price : float
		 * market: AMarket
		 */
	
	//Methods:
	public Stock() {
		this.name = null;
		this.id = null;
		this.price = 0;
		this.market = null;
	}
	@Override
	public void setID(String id) throws Exception  {
		// TODO Auto-generated method stub
		if(id.isEmpty() || id.length() > 3) throw new Exception("Invalid id!");
		else this.id = id.toLowerCase();
	}

	@Override
	public void setInitialPrice(float initPrice) {
		// TODO Auto-generated method stub
		this.price = (initPrice <= 0) ? 0 : initPrice;
	}
	public void init(String name, String id, float price) {
		this.name = name;
		this.setInitialPrice(price);
		try {
			this.setID(id);
		}
		catch(Exception e) {
			System.out.println("Invalid id!");
		}
		StockManager.add(this);
	}
	public void init(String name, String id, float price, StockMarket market) {
		this.init(name, id, price);
		this.assignMarket(market);
	}
	public void assignMarket(StockMarket market) {
		this.market = market;
		market.add(this);
	}
		
}
