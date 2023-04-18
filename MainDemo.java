import itemmodel.Stock;
import itemmodel.StockManager;
import marketmodel.IInvestor;
import marketmodel.IndividualInvestor;
import marketmodel.InvesmentFund;
import marketmodel.StockMarket;

public class MainDemo {
    public static void main(String[] args) {
        StockManager.init();
        StockMarket SSE = new StockMarket("SSE");
        IInvestor Nam = new IndividualInvestor("Pham Nhat Vuong");
        IInvestor ACB_Funds = new InvesmentFund("ACB Fund");
        SSE.subscribe(Nam);
        SSE.subscribe(ACB_Funds);
        StockManager event = new StockManager();
        StockManager.init();
        Stock NVL = new Stock();
        NVL.init("NVL",  "0", 1, SSE);
        Stock VGI = new Stock();
        VGI.init("VGI",  "1", 4, SSE);
        StockManager.add(NVL);
        event.inflate(50f);
        event.GovernmenGrant(2000000);
        event.DelistingStock(NVL);
    }
}
