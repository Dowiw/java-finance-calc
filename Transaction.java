// Transaction.java

public class Transaction {
    private double amount;
    private String description;
    private String category;
    private LocalDateTime date;
    private TransactionType type;

    public enum TransactionType {
        INCOME, EXPENSE
    }

    public Transaction(double amount, String description, String category, TransactionType type) {
        this.amount = amount;
        this.description = description;
        this.category = category;
        this.date = LocalDateTime.now();
        this.type = type;
    }

    // Getters and setters
    public double getAmount() { return amount; }
    public String getDescription() { return description; }
    public String getCategory() { return category; }
    public LocalDateTime getDate() { return date; }
    public TransactionType getType() { return type; }

    @Override
    public String toString() {
        return String.format("%s: $%.2f - %s (%s) on %s", 
            type, amount, description, category, 
            date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
    }
}

// FinanceManager.java


public class FinanceManager {

    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        FinanceManager manager = new FinanceManager();
        
        // Example usage
        Transaction salary = new Transaction(
            5000.0,
            "Monthly Salary",
            "Income",
            Transaction.TransactionType.INCOME
        );
        
        Transaction rent = new Transaction(
            1200.0,
            "Monthly Rent",
            "Housing",
            Transaction.TransactionType.EXPENSE
        );
        
        manager.addTransaction(salary);
        manager.addTransaction(rent);
        
        System.out.println("Current Balance: $" + manager.getBalance());
        System.out.println("\nAll Transactions:");
        for (Transaction t : manager.getAllTransactions()) {
            System.out.println(t);
        }
        
        System.out.println("\nTotal Income: $" + manager.getTotalIncome());
        System.out.println("Total Expenses: $" + manager.getTotalExpenses());
    }
}