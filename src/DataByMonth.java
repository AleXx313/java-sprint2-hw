public class DataByMonth {
    public String title;
    public boolean isExpense;
    public int quantity;
    public int price;
    public int month;

    public DataByMonth(String title, boolean isExpense, int quantity, int price, int month) {
        this.title = title;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.price = price;
        this.month = month;
    }

    @Override
    public String toString() {
        return "DataByMonth{" +
                "title='" + title + '\'' +
                ", isExpense=" + isExpense +
                ", quantity=" + quantity +
                ", price=" + price +
                ", month=" + month +
                '}'+"\n" ;
    }
}
