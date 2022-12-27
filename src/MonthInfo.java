import java.util.HashMap;

public class MonthInfo {
    public MonthlyReport monthlyReport;


    public MonthInfo(MonthlyReport monthlyReport) {
        this.monthlyReport = monthlyReport;
    }

    public int incomeByMonth(int month) {
        int sum = 0;
        HashMap<Integer, Integer> incomes = new HashMap<>();
        for (DataByMonth data : monthlyReport.datasByMonths) {
            if (data.month != month || data.isExpense) {
                continue;
            }
            incomes.put(month, data.totalTitleSum);
            for (Integer income : incomes.values()) {
                sum += income;
            }
        }
        return sum;
    }

    public int consumptionByMonth(int month) {
        int sum = 0;
        HashMap<Integer, Integer> consumptions = new HashMap<>();
        for (DataByMonth data : monthlyReport.datasByMonths) {
            if (data.month != month || !data.isExpense) {
                continue;
            }
            consumptions.put(month, data.totalTitleSum);
            for (Integer consumption : consumptions.values()) {
                sum += consumption;
            }
        }
        return sum;
    }

    private void getMostValuableTitle(int month) {
        String mostValuableTitle = "";
        int mostIncome = 0;
        HashMap<Integer, Integer> incomes = new HashMap<>();
        for (DataByMonth data : monthlyReport.datasByMonths) {
            if (data.month != month || data.isExpense) {
                continue;
            }
            incomes.put(month, data.totalTitleSum);
            for (Integer income : incomes.values()) {
                if (income > mostIncome) {
                    mostIncome = income;
                    mostValuableTitle = data.title;
                }
            }
        }
        System.out.println("Самое прибыльное наименование по отчету за месяц - " + mostValuableTitle + ". " +
                "Общая сумма по наименованию составила: " + mostIncome + ".");
    }

    private void getMostExpenseTitle(int month) {
        String mostExpenseTitle = "";
        int mostExpense = 0;
        HashMap<Integer, Integer> expenses = new HashMap<>();
        for (DataByMonth data : monthlyReport.datasByMonths) {
            if (data.month != month || !data.isExpense) {
                continue;
            }
            expenses.put(month, data.totalTitleSum);
            for (Integer expense : expenses.values()) {
                if (expense > mostExpense) {
                    mostExpense = expense;
                    mostExpenseTitle = data.title;
                }
            }
        }
        System.out.println("Самая большая трата за месяц осуществлена по наименованию - " + mostExpenseTitle + ". " +
                "Общий размер трат по наименованию составил: " + mostExpense + ".");
    }

    public static String getMonthName(int month){
        String monthName = "";
        switch (month){
            case 1:
                monthName = "Январь";
                break;
            case 2:
                monthName = "Февраль";
                break;
            case 3:
                monthName = "Март";
                break;
            default:
                System.out.println("Отчет за месяц № " + month + "не предоставлен!");
        }
        return monthName;
    }

    public void getMonthInfo(int month){
        System.out.println(getMonthName(month));
        getMostValuableTitle(month);
        getMostExpenseTitle(month);
    }
}
