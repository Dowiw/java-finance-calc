public class Main {
    public static void main(String[] args) {
        FinanceManager manager = new FinanceManager();
        
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