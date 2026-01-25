// Updated BrokerageSystem example
class BrokerageSystem {
    private static BrokerageSystem instance;
    private UserRepository userRepo;
    
    private BrokerageSystem() {
        userRepo = UserRepository.getInstance();
        StockRepository.getInstance();
    }
    
    public static synchronized BrokerageSystem getInstance() {
        if (instance == null) {
            instance = new BrokerageSystem();
        }
        return instance;
    }
    
    public void buyStock(int userId, String stockID, int quantity) throws InvalidOrderException {
        User user = userRepo.getUserById(userId);
        Account account = userRepo.getAccountForUser(userId);
        
        if (user == null || account == null) {
            throw new InvalidOrderException("User or account not found");
        }
        
        Order order = new Order(stockID, quantity, OrderType.BUYORDER);
        ProcessOrder processor = new ProcessOrder(order, account);
        processor.executeOrder();
    }
    
    public void sellStock(int userId, String stockID, int quantity) throws InvalidOrderException {
        // Similar implementation for sell
        User user = userRepo.getUserById(userId);
        Account account = userRepo.getAccountForUser(userId);

        if (user == null || account == null) {
            throw new InvalidOrderException("User or account not found");
        }

        Order order = new Order(stockID, quantity, OrderType.SELLORDER);
        ProcessOrder processor = new ProcessOrder(order, account);
        processor.executeOrder();
    }
}