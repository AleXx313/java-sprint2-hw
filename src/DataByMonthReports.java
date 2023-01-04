
public class DataByMonthReports {
    public String title;
    public boolean isExpense;
    public int quantity;
    public int price;
    public int totalTitleSum;// общая сумма по наименованию quantity * price. Получается через конструктор.

    public DataByMonthReports(String title, boolean isExpense, int quantity, int price) {
        this.title = title;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.price = price;
        this.totalTitleSum = this.price * this.quantity;

    }
}
