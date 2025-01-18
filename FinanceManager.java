import java.util.ArrayList;
import java.util.List;

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
