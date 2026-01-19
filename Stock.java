public class Stock {
    String stockID;
    double price;
    String name;

    public Stock(String id, double price, String name){
        this.stockID = id;
        this.price = price;
        this.name = name;
    }

    public String getStockID() {
        return stockID;
    }

    public void setStockID(String stockID) {
        this.stockID = stockID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
