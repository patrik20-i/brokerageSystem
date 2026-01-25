public class User{
    int id;
    String name;
    Account account;
    
    public User(int id, String name, Account portfolio){
        this.id = id;
        this.name = name;
        this.account = portfolio;
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

    public Account getaccount() {
        return account;
    }

    public void setaccount(Account portfolio) {
        this.account = portfolio;
    }
}