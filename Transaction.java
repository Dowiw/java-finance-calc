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
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FinanceManager {
    private List<Transaction> transactions;
    private double balance;

    public FinanceManager() {
        this.transactions = new ArrayList<>();
        this.balance = 0.0;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        if (transaction.getType() == Transaction.TransactionType.INCOME) {
            balance += transaction.getAmount();
        } else {
            balance -= transaction.getAmount();
        }
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getAllTransactions() {
        return new ArrayList<>(transactions);
    }

    public double getTotalIncome() {
        return transactions.stream()
            .filter(t -> t.getType() == Transaction.TransactionType.INCOME)
            .mapToDouble(Transaction::getAmount)
            .sum();
    }

    public double getTotalExpenses() {
        return transactions.stream()
            .filter(t -> t.getType() == Transaction.TransactionType.EXPENSE)
            .mapToDouble(Transaction::getAmount)
            .sum();
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