
public class DataByMonthReports {
    public String title;
    public boolean isExpense;
    public int quantity;
    public int price;
    public int totalTitleSum;// общая сумма по наименованию quantity * price. Получается через конструктор.
    public int month;

    public static int numberOfMonthReports;// статическая переменная, инкрементирующаяся каждый раз при прочтении месячного отчета.


    public DataByMonthReports(String title, boolean isExpense, int quantity, int price, int month) {
        this.title = title;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.price = price;
        this.month = month;
        this.totalTitleSum = this.price * this.quantity;

    }
}
