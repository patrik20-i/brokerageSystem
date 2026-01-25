public class Order {
    String stockID;
    int quantity;
    OrderType type;

    public Order(String id, int quantity, OrderType type){
        this.stockID = id;
        this.quantity = quantity;
        this.type = type;
    }

    public String getStockID() {
        return stockID;
    }

    public void setStockID(String stockID) {
        this.stockID = stockID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }
}
