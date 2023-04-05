
import java.util.ArrayList;

//IMarket

interface IMarket{
   
    abstract void Subcribe(IInvestor investor);
    abstract void UnSubcribe(IInvestor investor);
    abstract void NotifyInvestor(String stock, float newPrice);
    abstract void AddStock(Stock stock);
}
interface IInvestor {
    public void Update(String mess);
}
abstract class Stock {
    protected String name;
    protected float price;
    protected IMarket market;
    abstract void ChangePrice(float priceChange);
    abstract float getPrice();
}
class SaiGonMarket implements IMarket {
    ArrayList<IInvestor> investors;
    ArrayList<Stock> stocks;
    public SaiGonMarket() {
        investors = new ArrayList<IInvestor>();
        stocks = new ArrayList<Stock>();
    }
    public void Subcribe(IInvestor investor) {
        investors.add(investor);
    }
    public void UnSubcribe(IInvestor investor) {
        investors.remove(investor);
    }
    public void NotifyInvestor(String stock, float newPrice) {
        String mess = "Stock name \'"+ stock + "\' has changed its price, the new price: " + newPrice;
        for (var inves : investors) {
            inves.Update(mess);
        }
    }
    public void AddStock(Stock stock) {
        stocks.add(stock);
    }
}
class NovaLandStock extends Stock {
    public NovaLandStock(IMarket _market, String _name, Event event, float initPrice) {
        this.market = _market;
        this.name = _name;
        event.Add(this);
        price = initPrice;
    }
    public void ChangePrice(float priceChange)  {
        price += priceChange;
        market.NotifyInvestor(name, price);
    }
    public float getPrice() {return price;} 
}
class IndividualInvestor implements IInvestor {
    String name;
    public IndividualInvestor(String _name) {
        name = _name;
    }
    public void Update(String mess){
        System.out.println(name +": " + mess);
    }
}
class QuyDauTu implements IInvestor {
    String name;
    public QuyDauTu(String _name) {
        name = _name;
    }
    public void Update(String mess){
        System.out.println(name + ": " + mess);
    }
}
 class Event{
    ArrayList<Stock> stocks;
    public Event() {
        stocks = new ArrayList<Stock>();
    }
    
    public void LamPhat(float percent) {
        System.out.println("Lam phat: " + percent + " phan tram!");
        for (var s : stocks) {
            s.ChangePrice(-s.getPrice() * percent);
        }
    }
    public void InThemTien(float percent) {
        System.out.println("Chinh phu in them tien!");
        for (var s : stocks) {
            s.ChangePrice(s.getPrice() * percent);
        }
    }
    public void Add(Stock stock) {
        stocks.add(stock);
    }
}

public class MarketStock {
    public static void main(String[] args) {
        IMarket saigonMarket = new SaiGonMarket();
        Event event = new Event();
        Stock nova = new NovaLandStock(saigonMarket, "NVL", event, 10f);
        saigonMarket.AddStock(nova);
        IInvestor Kduy = new IndividualInvestor("Khuong Duy");
        saigonMarket.Subcribe(Kduy);
        IInvestor Bin = new QuyDauTu("Bin Group");
        saigonMarket.Subcribe(Bin);
        event.LamPhat((0.05f));
        event.InThemTien(0.1f);
    }
}
