import java.util.HashMap;

public class MonthInfo {
    public MonthlyReport monthlyReport;


    public MonthInfo(MonthlyReport monthlyReport) {
        this.monthlyReport = monthlyReport;
    }

    public int getByMonthIncome(int month) {
        int sum = 0;
        HashMap<Integer, Integer> incomes = new HashMap<>();
        for (DataByMonth data : monthlyReport.dataByMonths) {
            if (data.month == month && !data.isExpense) {
                incomes.put(month, data.totalTitleSum);
                for (Integer income : incomes.values()) {
                    sum += income;
                }
            }
        }
        return sum;
    }

    public int getByMonthConsumption(int month) {
        int sum = 0;
        HashMap<Integer, Integer> consumptions = new HashMap<>();
        for (DataByMonth data : monthlyReport.dataByMonths) {
            if (data.month == month && data.isExpense) {
                consumptions.put(month, data.totalTitleSum);
                for (Integer consumption : consumptions.values()) {
                    sum += consumption;
                }
            }
        }
        return sum;
    }

    private void getMostValuableTitle(int month) {
        String mostValuableTitle = "";
        int mostIncome = 0;
        HashMap<Integer, Integer> incomes = new HashMap<>();
        for (DataByMonth data : monthlyReport.dataByMonths) {
            if (data.month == month && !data.isExpense) {
                incomes.put(month, data.totalTitleSum);
                for (Integer income : incomes.values()) {
                    if (income > mostIncome) {
                        mostIncome = income;
                        mostValuableTitle = data.title;
                    }
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
        for (DataByMonth data : monthlyReport.dataByMonths) {
            if (data.month == month && data.isExpense) {
                expenses.put(month, data.totalTitleSum);
                for (Integer expense : expenses.values()) {
                    if (expense > mostExpense) {
                        mostExpense = expense;
                        mostExpenseTitle = data.title;
                    }
                }
            }
        }
        System.out.println("Самая большая трата за месяц осуществлена по наименованию - " + mostExpenseTitle + ". " +
                "Общий размер трат по наименованию составил: " + mostExpense + ".");
    }

    public static String getMonthName(int month) {
        String monthName = "";
        switch (month) {
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

    //Метод для получения общего количества считанных помесячных отчетов.
    //Данный метод - альтернатива статической переменной класса DataByMonth.numberOfMonthReports.
    public int numberOfMonthReports() {
        int numberOfMonthReports = 0;
        for (DataByMonth dataByMonth : monthlyReport.dataByMonths) {
            if (numberOfMonthReports != dataByMonth.month) {
                numberOfMonthReports = dataByMonth.month;
            }
        }
        return numberOfMonthReports;
    }

    public void getMonthInfo() {
        for (int i = 1; i <= numberOfMonthReports(); i++) {
            System.out.println(getMonthName(i));
            getMostValuableTitle(i);
            getMostExpenseTitle(i);
        }
    }
}
