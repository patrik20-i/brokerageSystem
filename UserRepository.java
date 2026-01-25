import java.util.concurrent.ConcurrentHashMap;

public class UserRepository {
    private static UserRepository instance;
    
    ConcurrentHashMap<Integer, User> userRepo; // userId -> User
    ConcurrentHashMap<String, Integer> usernameToId; // username -> userId
    ConcurrentHashMap<Integer, Account> userAccounts; // userId -> Account
    private int nextUserId = 1;
    
    private UserRepository() {
        userRepo = new ConcurrentHashMap<>();
        usernameToId = new ConcurrentHashMap<>();
        userAccounts = new ConcurrentHashMap<>();
    }
    
    public static synchronized UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }
    
    public synchronized int addUser(User user) {
        int userId = nextUserId++;
        userRepo.put(userId, user);
        usernameToId.put(user.getName(), userId); // Assuming User has getUsername()
        return userId;
    }
    
    public User getUserById(int userId) {
        return userRepo.get(userId);
    }
    
    public User getUserByUsername(String username) {
        Integer userId = usernameToId.get(username);
        return userId != null ? userRepo.get(userId) : null;
    }
    
    public void linkAccountToUser(int userId, Account account) {
        userAccounts.put(userId, account);
    }
    
    public Account getAccountForUser(int userId) {
        return userAccounts.get(userId);
    }
    
    public boolean userExists(int userId) {
        return userRepo.containsKey(userId);
    }
    
    public boolean usernameExists(String username) {
        return usernameToId.containsKey(username);
    }
    
    public void removeUser(int userId) {
        User user = userRepo.remove(userId);
        if (user != null) {
            usernameToId.remove(user.getName());
            userAccounts.remove(userId);
        }
    }
}