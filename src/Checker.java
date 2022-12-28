public class Checker {
    public MonthInfo monthInfo;
    public YearInfo yearInfo;

    public Checker(MonthInfo monthInfo, YearInfo yearInfo) {
        this.monthInfo = monthInfo;
        this.yearInfo = yearInfo;
    }

    public void check(){
        boolean flag = true;
        for (int i = 1; i <=3 ; i++) {
            if (monthInfo.getByMonthIncome(i) != yearInfo.getPerMonthIncome(i)){
                System.out.println("По результатам проверки выявлено расхождение в месяце - " +
                        MonthInfo.getMonthName(i) + ".");
                flag = false;
            }
        }
        if (flag){
            System.out.println("По результатам проверки расхождений не выявлено!");
        }
    }
}
