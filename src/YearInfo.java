public class YearInfo {

    public YearlyReport yearlyReport;

    public YearInfo(YearlyReport yearlyReport) {
        this.yearlyReport = yearlyReport;
    }

    public int getPerMonthIncome(int month) {
        int monthIncome = 0;
        for (DataByYear data : yearlyReport.datasByYear) {
            if (data.month != month || data.isExpense) {
                continue;
            }
            monthIncome = data.amount;
        }
        return monthIncome;
    }

    public int getPerMonthConsumption(int month) {
        int monthConsumption = 0;
        for (DataByYear data : yearlyReport.datasByYear) {
            if (data.month != month || !data.isExpense) {
                continue;
            }
            monthConsumption = data.amount;
        }
        return monthConsumption;
    }

    public int getMonthProfit(int month) {
        return getPerMonthIncome(month) - getPerMonthConsumption(month);
    }

    public int getAverageIncome(){
        int averageIncome = 0;
        for (int i = 1; i <= DataByMonth.numberOfMonthReports; i++) {
            averageIncome += getPerMonthIncome(i);
        }
        return averageIncome / DataByMonth.numberOfMonthReports;
    }

    public int getAverageConsumption(){
        int averageConsumption = 0;
        for (int i = 1; i <= DataByMonth.numberOfMonthReports; i++) {
            averageConsumption += getPerMonthConsumption(i);
        }
        return averageConsumption / DataByMonth.numberOfMonthReports;
    }

    public void getYearInfo(){

        System.out.println("Год: " + yearlyReport.datasByYear.get(0).year);
        for (int i = 1; i <= DataByMonth.numberOfMonthReports ; i++) {
            System.out.println("Прибыль за " + MonthInfo.getMonthName(i) + " составила " + getMonthProfit(i) + ".");
        }
        System.out.println("Средний доход за всем месяцы составил " + getAverageIncome());
        System.out.println("Средний расход за всем месяцы составил " + getAverageConsumption());
    }
}
