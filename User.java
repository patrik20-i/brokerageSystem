public class User{
    int id;
    String name;
    Portfolio portfolio;
    
    public User(int id, String name, Portfolio portfolio){
        this.id = id;
        this.name = name;
        this.portfolio = portfolio;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }
}