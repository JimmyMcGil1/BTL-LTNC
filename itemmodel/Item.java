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
		this.price = (price <= 0) ? 0 : price;
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
	public void notifyMarket(String msg) {
		this.market.notifyInvestor();
	}
}
