public class YearInfo {

    public YearlyReport yearlyReport;
    public MonthlyReport monthlyReport;

    public YearInfo(YearlyReport yearlyReport, MonthlyReport monthlyReport) {
        this.yearlyReport = yearlyReport;
        this.monthlyReport = monthlyReport;
    }

    public int getPerMonthIncome(int month) {
        int monthIncome = 0;
        for (DataByYearReports data : yearlyReport.dataByYearReports) {
            if (data.month == month && !data.isExpense) {
                monthIncome = data.amount;
            }
        }
        return monthIncome;
    }

    public int getPerMonthConsumption(int month) {
        int monthConsumption = 0;
        for (DataByYearReports data : yearlyReport.dataByYearReports) {
            if (data.month == month && data.isExpense) {
                monthConsumption = data.amount;
            }
        }
        return monthConsumption;
    }

    public int getMonthProfit(int month) {
        return getPerMonthIncome(month) - getPerMonthConsumption(month);
    }

    public int getAverageIncome() {
        int averageIncome = 0;
        for (int i = 1; i <= monthlyReport.monthsData.size(); i++) {
            averageIncome += getPerMonthIncome(i);
        }
        return averageIncome / monthlyReport.monthsData.size();
    }

    public int getAverageConsumption() {
        int averageConsumption = 0;
        for (int i = 1; i <= monthlyReport.monthsData.size(); i++) {
            averageConsumption += getPerMonthConsumption(i);
        }
        return averageConsumption / monthlyReport.monthsData.size();
    }

    public void getYearInfo() {

        System.out.println("Год: " + yearlyReport.dataByYearReports.get(0).year);
        for (int i = 1; i <= monthlyReport.monthsData.size(); i++) {
            System.out.println("Прибыль за " + MonthInfo.getMonthName(i) + " составила " + getMonthProfit(i) + ".");
        }
        System.out.println("Средний доход за всем месяцы составил " + getAverageIncome());
        System.out.println("Средний расход за всем месяцы составил " + getAverageConsumption());
    }
}
