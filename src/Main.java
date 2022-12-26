public class Main {
    public static void main(String[] args) {

        // создание годового отчета
        YearlyReport yearlyReport = new YearlyReport("java-sprint2-hw/resources/y.2021.csv");
        // создание месячных отчетов
        MonthlyReport monthlyReport = new MonthlyReport();
        // необходимо доавить в конструктор MontlyReport поле int month равное i!
        for (int month = 1; month <= 12; month++) {
            String path = "java-sprint2-hw/resources/m.20210" + month + ".csv";
            monthlyReport.loadFile(path, month);
        }

        System.out.println(monthlyReport.datasByMonths.toString());

    }
        // Поехали!
}

