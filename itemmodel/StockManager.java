package itemmodel;
import java.io.IOException;
import java.util.ArrayList;

public class StockManager implements ItemManager {
	//Attributes:
	private static ArrayList<Stock> list;
	
	//Methods:
	public static void init() {
		StockManager.list = new ArrayList<Stock>();
	}
	public static void add(Stock stock) {
		list.add(stock);
	}
	public static void remove(Stock stock) {
		list.remove(stock);
	}
	public static void clear() {
		list.clear();
	}
	
	@Override
	public void inflate(float percentage) {
		// TODO Auto-generated method stub
		//TODO: insert pop up text
		if(percentage > 0) {
			for(int i = 0; i < list.size(); i++) {
				list.get(i).setPrice(list.get(i).getPrice() * (1 - percentage / 100));
				//list.get(i).notifyMarket("" + percentage);
			}
		}
	}

	public void GovernmenGrant (float amoutOfMoney) {
		for(int i = 0; i < list.size(); i++) {
			//gia co phieu tang them 1 dola / 1000000 dola chinh phu tro cap
			list.get(i).setPrice(list.get(i).getPrice() + amoutOfMoney / 1000000); 
			//list.get(i).notifyMarket("" + percentage);
		}
	}
	public void DelistingStock(Item stock) {
		System.out.println(stock.name + " has been delisted");
		list.remove((stock));
	}
	@Override
	public void changeBy(String id, float percentage) throws Exception  {
		// TODO Auto-generated method stub
		int pos = indexOf(id);
		if(pos == -1) {
			System.out.println("catch in func");
			throw new IOException("Invalid");
		}
		//change data
		if(percentage != 0) {
			list.get(pos).setPrice(list.get(pos).getPrice() * (1 + percentage / 100));
			///list.get(pos).notifyMarket("" +  percentage);
		}	
	}
	public static int indexOf(String s) {
		//check empty
		String tmp = s;
		if(tmp.isBlank()) return -1;
		if(tmp.length() <= 3) {
			tmp = tmp.toLowerCase();
			int pos = 0;
			for(pos = 0; pos < list.size(); pos++) {
				if(list.get(pos).getID().equals(tmp)) return pos;
			}
		}
		else {
			int pos = 0;
			for(pos = 0; pos < list.size(); pos++) {
				if(list.get(pos).getName().equals(tmp)) return pos;
			}
		}
		return -1;
	}
}
