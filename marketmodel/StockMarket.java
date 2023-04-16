package marketmodel;

import itemmodel.Stock;

public class StockMarket extends AMarket {
	//Attributes:
		/*
		 * investorList: ArrayList<IInvestor>
		 * itemList    : ArrayList<Item>
		 */
		
		//Methods:
		public StockMarket(){
			super();
		}
		public void add(Stock s) {
			this.itemList.add(s);
		}
		public void remove(Stock s) {
			this.itemList.remove(s);
		}
		@Override
		public int search(String ID) {
			// TODO Auto-generated method stub
			String tmp = ID;
			//check empty
			if(ID.isBlank()) return -1; 
			if(tmp.length() <= 3) {
				tmp = tmp.toLowerCase();
				int pos = 0;
				for(pos = 0; pos < this.itemList.size(); pos++) {
					if(this.itemList.get(pos).getID().equals(tmp)) return pos;
				}
				return -1;
			}
			else {
				int pos = 0;
				for(pos = 0; pos < this.itemList.size(); pos++) {
					if(this.itemList.get(pos).getName().equals(tmp)) return pos;
				}
				return -1;
			}
		}
}
