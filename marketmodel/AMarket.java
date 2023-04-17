package marketmodel;
import java.util.ArrayList;
import itemmodel.*;

public abstract class AMarket {
	//Attributes:
	protected ArrayList<IInvestor> investorList;
	protected ArrayList<Item> itemList;
	//Methods:
	public AMarket() {
		this.investorList = new ArrayList<IInvestor>();
		this.itemList = new ArrayList<Item>();
	}
	public void subscribe(IInvestor investor) {
		//check exist then add
		if(this.investorList.indexOf(investor) != -1) return;
		this.investorList.add(investor);
	}
	public void unsubscribe(IInvestor investor) {
		this.investorList.remove(investor);
	}
	public void notifyInvestor(String msg) {
		for(int i = 0; i < investorList.size(); i++) {
			investorList.get(i).update(msg);
		}
	}
	public Item getItem(int pos) {
		return this.itemList.get(pos);
	}
	public int itemCount() {
		return this.itemList.size();
	}
	public abstract void updateView(String ID, boolean color);
	public abstract int search(String ID);
}
