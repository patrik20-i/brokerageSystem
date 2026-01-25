public class InvalidOrderException extends Exception{
    private String stockId;
    private int requestQuantity;
    private int availableQuantity;
    private OrderType orderType;
    public InvalidOrderException(String message){
        super(message);
    }
    public InvalidOrderException(String message, String stockId, int requestedQuantity, int availableQuantity, OrderType orderType){
        super(message);
        this.stockId = stockId;
        this.requestQuantity = requestedQuantity;
        this.availableQuantity = availableQuantity;
        this.orderType = orderType;
    }

    @Override
    public String toString() {
        return "InvalidOrderException{" +
                "message='" + getMessage() + '\'' +
                ", stockId='" + stockId + '\'' +
                ", requestedQuantity=" + requestQuantity +
                ", availableQuantity=" + availableQuantity +
                ", orderType='" + orderType + '\'' +
                '}';
    }
    
}
