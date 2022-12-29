public class DataByYearReports {
    public int month;
    public int amount;
    public boolean isExpense;

    public int year;

    public DataByYearReports(int month, int amount, boolean isExpense, int year) {
        this.month = month;
        this.amount = amount;
        this.isExpense = isExpense;
        this.year = year;
    }
}
