
public class ProcessOrder {
    Order order;
    Account account;
    StockRepository stockRepo;
    public ProcessOrder(Order order, Account account){
        this.order = order;
        this.account = account;
        this.stockRepo = StockRepository.getInstance();
    }

    public boolean executeOrder() throws InvalidOrderException{
        if(order.type == OrderType.SELLORDER){
            return processSellOrder();
        }
        else{
            return processBuyOrder();
        }
    }

    private boolean processBuyOrder() throws InvalidOrderException{
        String stockId = order.stockID;
        int availableQuantity = stockRepo.getAvailableQuantity(stockId);

        if(availableQuantity < order.quantity){
            throw new InvalidOrderException(
                "invalid buy order"
            );
        }
        else{
            account.addStock(stockId, order.quantity);
            stockRepo.removeStock(stockId, order.quantity);
            return true;
        }
    }

    private boolean processSellOrder() throws InvalidOrderException{
        String stockId = order.stockID;
        int availableQuantity = account.getStockCount(stockId);

        if(availableQuantity < order.quantity){
            throw new InvalidOrderException("Insufficient Stock",
                stockId,
                order.quantity,
                availableQuantity,
                OrderType.SELLORDER
            );
        }
        else{
            account.removeStock(stockId, order.quantity);
            stockRepo.addStock(stockId, order.quantity);
            return true;
        }


    }
    
}
