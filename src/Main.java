import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Здравствуйте!");
        Scanner scanner = new Scanner(System.in);
        MonthlyReport monthlyReport = null;
        YearlyReport yearlyReport = null;
        printMenu();
        int command = scanner.nextInt();
        while (true) {
            if (command == 1) {
                System.out.println("Сколько месячных отчетов у вас имеется?");
                System.out.println("------------------------------------------------");
                int monthCount = scanner.nextInt();
                if (monthlyReport == null) {
                    monthlyReport = new MonthlyReport();
                    for (int i = 1; i <= monthCount; i++) {
                        String path = "resources/m.20210" + i + ".csv";
                        monthlyReport.loadFile(path, i);
                    }
                    System.out.println("------------------------------------------------");
                } else {
                    System.out.println("Все имеющиеся месячные отчеты были считаны, введите другую команду.");
                    System.out.println("------------------------------------------------");
                }
            } else if (command == 2) {
                if (yearlyReport == null) {
                    yearlyReport = new YearlyReport("resources/y.2021.csv");
                    System.out.println("------------------------------------------------");
                } else {
                    System.out.println("Годовой отчет уже был считан, введите другую команду.");
                    System.out.println("------------------------------------------------");
                }
            } else if (command == 3) {
                if (yearlyReport == null || monthlyReport == null) {
                    System.out.println("Данные необходимые для сверки не были считаны! Введите комманду 1 или 2.");
                    System.out.println("------------------------------------------------");

                } else {
                    MonthInfo monthInfo = new MonthInfo(monthlyReport);
                    YearInfo yearInfo = new YearInfo(yearlyReport, monthlyReport);
                    Checker checker = new Checker(monthInfo, yearInfo);
                    checker.check();
                    System.out.println("------------------------------------------------");
                }
            } else if (command == 4) {
                MonthInfo monthInfo = new MonthInfo(monthlyReport);
                monthInfo.getMonthInfo();
                System.out.println("------------------------------------------------");
            } else if (command == 5) {
                YearInfo yearInfo = new YearInfo(yearlyReport, monthlyReport);
                yearInfo.getYearInfo();
                System.out.println("------------------------------------------------");
            } else if (command == 0) {
                break;
            } else {
                System.out.println("Введенная вами команда отсутствует.");
                System.out.println("------------------------------------------------");
            }
            printMenu();
            command = scanner.nextInt();
        }
        System.out.println("Программа завершена. До свидания!");
    }

    public static void printMenu() {
        System.out.println("Введите команду:");
        System.out.println("1. Считать все месячные отчёты.");
        System.out.println("2. Считать годовой отчёт.");
        System.out.println("3. Сверить отчёты.");
        System.out.println("4. Вывести информацию о всех месячных отчётах.");
        System.out.println("5. Вывести информацию о годовом отчёте.");
        System.out.println("0. Выход.");
        System.out.println("------------------------------------------------");
    }
}
