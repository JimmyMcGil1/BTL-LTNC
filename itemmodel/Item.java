package itemmodel;
import marketmodel.AMarket;

public abstract class Item {
	//Attributes:
	/*
	 * name  : String
	 * id 	 : String
	 * price : float
	 * market: AMarket
	 */
	protected String name;
	protected String id;
	protected float price;
	protected AMarket market;
	//Methods:
	public void setName(String name) {
		this.name = name;
	}
	public abstract void setID(String id) throws Exception;
	public abstract void setInitialPrice(float initPrice);
	public void setPrice(float price) {
		float tmp_price = (price <= 0) ? 0 : price;
		float change = tmp_price - this.price;
		if(change < 0) {
			this.price = tmp_price;
			market.notifyInvestor(name + "(" + id +"): has decreased by " + Math.abs(change));
			market.updateView(id, false);
		}
		else if(change > 0) {
			this.price = tmp_price;
			market.notifyInvestor(name + "(" + id + "): has increased by " + change);
			market.updateView(id, true);
		}
		
	}
	public String getName() {
		return this.name;
	}
	public String getID() {
		return this.id;
	}
	public float getPrice() {
		return this.price;
	}
}
