import java.util.concurrent.ConcurrentHashMap;

public class StockRepository {
    private static StockRepository instance;

    ConcurrentHashMap<String, Integer> stockRepo;
    private StockRepository(){
        stockRepo = new ConcurrentHashMap<>();
    }

    public static synchronized StockRepository getInstance(){
        if(instance == null){
            instance = new StockRepository();
        }
        return instance;
    }

    //function to add stocks to stockRepo

    public void addStock(String stockId, int quantity){
        int existingQuantity = stockRepo.get(stockId);

        int newQuantity = existingQuantity + quantity;
        stockRepo.put(stockId, newQuantity);
    }
    public void removeStock(String stockId, int quantity){
        int existingQuantity = stockRepo.getOrDefault(stockId, 0);
        
        if(existingQuantity >= quantity){
            int newQuantity = existingQuantity - quantity;
            stockRepo.put(stockId, newQuantity);
        } else {
            throw new IllegalArgumentException("Insufficient stock quantity available");
        }
    }

    public int getAvailableQuantity(String stockId){
        return stockRepo.get(stockId);
    }
}
