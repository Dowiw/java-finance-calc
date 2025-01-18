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