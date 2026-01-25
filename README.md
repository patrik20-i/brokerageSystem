# Brokerage System

A low-level detailed design for an online brokerage system implementing core trading functionalities with proper design patterns and exception handling.

## 🏗️ Architecture Overview

This brokerage system follows a modular architecture with singleton pattern repositories, command pattern for orders, and facade pattern for system integration.

## 📋 Requirements Status

### ✅ **Implemented Features**

#### Account Management
- ✅ Account ID management
- ✅ User association with accounts
- ✅ Stock portfolio tracking
- ✅ Balance management
- ✅ User repository for centralized user management

#### Stock Management
- ✅ Stock repository with singleton pattern
- ✅ Stock quantity tracking
- ✅ Add/Remove stock operations
- ✅ Thread-safe stock operations using ConcurrentHashMap

#### Order Management
- ✅ Buy order processing
- ✅ Sell order processing
- ✅ Order validation and execution
- ✅ Custom exception handling (InvalidOrderException)
- ✅ Order type enumeration (BUY/SELL)

#### System Integration
- ✅ Centralized brokerage system facade
- ✅ Repository pattern for data management
- ✅ Strategy pattern for order processing

### 🔄 **Pending Features**

#### Portfolio Management
- ⏳ Portfolio value calculation
- ⏳ Profit/Loss tracking
- ⏳ Portfolio performance analytics

#### Trading Rules
- ⏳ Balance validation for buy orders
- ⏳ Stock price management
- ⏳ Transaction history logging
- ⏳ Market hours validation

## 🎯 **Core Entities**

### **BrokerageSystem** 
- **Pattern**: Singleton, Facade
- **Purpose**: Central coordinator for all trading operations
- **Methods**: `buyStock()`, `sellStock()`

### **Account**
- **Purpose**: Manages user's trading account
- **Properties**: Account ID, balance, stock holdings
- **Methods**: `addStock()`, `removeStock()`, `getStockCount()`

### **User**
- **Purpose**: Represents system users
- **Properties**: User details and account linking
- **Integration**: Managed through UserRepository

### **Stock**
- **Purpose**: Represents tradeable securities
- **Properties**: Stock ID, symbol, price information
- **Management**: Centralized through StockRepository

### **Order**
- **Pattern**: Command Pattern
- **Purpose**: Encapsulates buy/sell requests
- **Properties**: Stock ID, quantity, order type
- **Types**: BUY_ORDER, SELL_ORDER

### **ProcessOrder**
- **Pattern**: Strategy Pattern
- **Purpose**: Executes different order types
- **Methods**: `executeOrder()`, `processBuyOrder()`, `processSellOrder()`

### **OrderType (enum)**
- **Values**: `BUYORDER`, `SELLORDER`
- **Purpose**: Type-safe order classification

## 🎨 **Design Patterns Implemented**

1. **Singleton Pattern**
   - `StockRepository`
   - `UserRepository` 
   - `BrokerageSystem`

2. **Repository Pattern**
   - Centralized data access for stocks and users
   - Thread-safe operations

3. **Strategy Pattern**
   - Different processing strategies for buy/sell orders

4. **Command Pattern**
   - Orders as command objects
   - ProcessOrder as command executor

5. **Facade Pattern**
   - BrokerageSystem provides simplified interface

## 🚀 **Getting Started**

### Basic Usage Example

```java
// Get brokerage system instance
BrokerageSystem broker = BrokerageSystem.getInstance();

// Execute buy order
try {
    broker.buyStock(userId, "AAPL", 100);
    System.out.println("Buy order executed successfully");
} catch (InvalidOrderException e) {
    System.err.println("Order failed: " + e.getMessage());
}

// Execute sell order
try {
    broker.sellStock(userId, "AAPL", 50);
    System.out.println("Sell order executed successfully");
} catch (InvalidOrderException e) {
    System.err.println("Order failed: " + e.getMessage());
}
```

## 🧪 **Exception Handling**

### InvalidOrderException
- **Purpose**: Handles order validation and execution failures
- **Features**: Detailed error information with stock ID, quantities, and order type
- **Usage**: Thrown for insufficient stocks, invalid users, or processing errors

## 📁 **File Structure**

```
brokerageSystem/
├── Account.java              # User account management
├── BrokerageSystem.java      # Main system facade
├── InvalidOrderException.java # Custom exception handling
├── Order.java                # Order command objects
├── OrderType.java            # Order type enumeration
├── ProcessOrder.java         # Order processing strategy
├── Stock.java                # Stock entity
├── StockRepository.java      # Stock data management
├── User.java                 # User entity
├── UserRepository.java       # User data management
└── README.md                 # This file
```

## 🔜 **Next Steps**

1. Add stock price management system
2. Implement transaction history tracking  
3. Add balance validation for buy orders
4. Create portfolio analytics features
5. Add authentication and security layers
6. Implement market data integration