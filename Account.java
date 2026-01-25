import java.util.concurrent.ConcurrentHashMap;
public class Account {
    int accountId;
    ConcurrentHashMap<String, Integer> stocksBought;
    User user;
    Double balance;
    public Account(int id, User user, double balance){
        this.accountId = id;
        this.user = user;
        stocksBought = new ConcurrentHashMap<>();
        this.balance = balance;
    }

    public int getaccountId() {
        return accountId;
    }
    public int getStockCount(String stockId){
        return stocksBought.get(stockId);
    }
    public void setaccountId(int portfolioId) {
        this.accountId = portfolioId;
    }

    public ConcurrentHashMap<String, Integer> getStocks() {
        return stocksBought;
    }

    public void setStocks(ConcurrentHashMap<String, Integer> stocks) {
        this.stocksBought = stocks;
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
    void addStock(String stockId, int quantity){
        int exitingQuantity = stocksBought.get(stockId);
        int totalQuantity = exitingQuantity+quantity;
        stocksBought.put(stockId, totalQuantity);
    }

    void removeStock(String stockID, int quantity){
        int exitingQuantity = stocksBought.get(stockID);
        if(exitingQuantity>=quantity){
            int leftQuantity = exitingQuantity-quantity;
            if(leftQuantity==0){
                stocksBought.remove(stockID);
            }
            else{
                stocksBought.put(stockID, leftQuantity);
            }
        }
    }   
}
