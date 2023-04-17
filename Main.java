import itemmodel.Stock;
import itemmodel.StockManager;
import marketmodel.AMarket;
import marketmodel.IInvestor;
import marketmodel.IndividualInvestor;
import marketmodel.InvesmentFund;
import marketmodel.StockMarket;

public class Main {
    public static void main(String[] args) {
        StockMarket SSE = new StockMarket(); 
        IInvestor Nam = new IndividualInvestor("Pham Nhat Vuong");
        IInvestor ACB_Funds = new InvesmentFund("ACB Fund");
        SSE.subscribe(Nam);
        SSE.subscribe(ACB_Funds);
        StockManager event = new StockManager();
        StockManager.init();
        Stock NVL = new Stock();
        NVL.init("NVL",  "0", 1, SSE);
        StockManager.add(NVL);
        event.inflate(50f);
    }
}
