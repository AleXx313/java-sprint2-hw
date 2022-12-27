
public class DataByMonth {
    public String title;
    public boolean isExpense;
    public int quantity;
    public int price;
    public int totalTitleSum;// общая сумма по наимнованию quantity * price. Получается через конструктор.
    public int month;


    public DataByMonth(String title, boolean isExpense, int quantity, int price, int month) {
        this.title = title;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.price = price;
        this.month = month;
        this.totalTitleSum = this.price * this.quantity;
    }
}
