
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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