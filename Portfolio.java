import java.util.concurrent.ConcurrentHashMap;
public class Portfolio {
    int portfolioId;
    ConcurrentHashMap<Integer, Integer> stocks;
    User user;
    Double balance;
    public Portfolio(int id, User user, double balance){
        this.portfolioId = id;
        this.user = user;
        stocks = new ConcurrentHashMap<>();
        this.balance = balance;
    }

    public int getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(int portfolioId) {
        this.portfolioId = portfolioId;
    }

    public ConcurrentHashMap<Integer, Integer> getStocks() {
        return stocks;
    }

    public void setStocks(ConcurrentHashMap<Integer, Integer> stocks) {
        this.stocks = stocks;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    //add exception to add and removeStock functions
    void addStock(int stockId, int quantity){
        int exitingQuantity = stocks.get(stockId);
        int totalQuantity = exitingQuantity+quantity;
        stocks.put(stockId, totalQuantity);
    }

    void removeStock(int stockID, int quantity){
        int exitingQuantity = stocks.get(stockID);
        if(exitingQuantity>=quantity){
            int leftQuantity = exitingQuantity-quantity;
            if(leftQuantity==0){
                stocks.remove(stockID);
            }
            else{
                stocks.put(stockID, leftQuantity);
            }
        }
    }   
}
