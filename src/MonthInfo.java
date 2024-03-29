import java.util.HashMap;

public class MonthInfo {
    public MonthlyReport monthlyReport;

    public MonthInfo(MonthlyReport monthlyReport) {
        this.monthlyReport = monthlyReport;
    }

    public int getByMonthIncome(int month) {
        int sum = 0;
        for (DataByMonthReports data : monthlyReport.monthsData.get(month)) {
            if (!data.isExpense) {
                sum += data.totalTitleSum;
            }
        }
        return sum;
    }

    public int getByMonthConsumption(int month) {
        int sum = 0;
        for (DataByMonthReports data : monthlyReport.monthsData.get(month)) {
            if (data.isExpense) {
                sum += data.totalTitleSum;
            }
        }
        return sum;
    }

    private void getMostValuableTitle(int month) {
        String mostValuableTitle = "";
        int mostIncome = 0;
        for (DataByMonthReports data : monthlyReport.monthsData.get(month)) {
            if (!data.isExpense) {
                if (data.totalTitleSum > mostIncome) {
                    mostIncome = data.totalTitleSum;
                    mostValuableTitle = data.title;
                }
            }
        }
        System.out.println("Самое прибыльное наименование по отчету за месяц - "+mostValuableTitle +". "+
                "Общая сумма по наименованию составила: "+mostIncome +".");
    }



    private void getMostExpenseTitle(int month) {
        String mostExpenseTitle = "";
        int mostExpense = 0;
        HashMap<Integer, Integer> expenses = new HashMap<>();
        for (DataByMonthReports data : monthlyReport.monthsData.get(month)) {
            if (data.isExpense) {
                if (data.totalTitleSum > mostExpense) {
                    mostExpense = data.totalTitleSum;
                    mostExpenseTitle = data.title;
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

    public void getMonthInfo() {
        for (int i = 1; i <= monthlyReport.monthsData.size(); i++) {
            System.out.println(getMonthName(i));
            getMostValuableTitle(i);
            getMostExpenseTitle(i);
        }
    }
}
