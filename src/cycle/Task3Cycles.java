package cycle;

/**
 * Задание 3
 * Программист Ваня сразу после окончания курсов dmdev устроился в IT компанию на позицию Junior Java Developer с зарплатой 600$ в месяц.
 * Ему обещали, что будут поднимать зарплату на 400$ каждые 6 месяцев.
 * 300$ в месяц Ваня тратит на еду и развлечения.
 * 10% от зарплаты Ваня ежемесячно переводит на счет брокера, чтобы инвестировать в акции с доходностью 2% в месяц.
 * <p>
 * Посчитать, сколько Ваня будет иметь средств на своем счету и на счету брокера за 3 года и 2 месяца.
 * <p>
 * Для интереса: попробовать увеличить процент, которые Ваня инвестирует из своей зарплаты
 */
public class Task3Cycles{
    private static double salary = 600;
    private static double salaryIncrease = 400;
    private static int period = 6;
    private static int month = convertingYearToMonth(3, 2);
    private static double percentBroker = 10;
    private static double percentageStock = 2;
    private static double expensesMoth = 300;

    public static void main(String[] args) {

        /**
         * Зарплата Васи за период времени
         */
        double sumSalaryForPeriod = incomeForPeriod(salary, salaryIncrease, period, month);
        /**
         * Траты Васи на еду и развечения за период времени
         */
        double expensesPeriod = calculationOfExpenses(expensesMoth, month);


        /**
         * Средства на счету Васи
         */
        double sumMoneyAccount = countMoneyYourAccount(sumSalaryForPeriod, expensesPeriod, percentBroker);
        System.out.println(sumMoneyAccount);

        /**
         * Средства на счету брокера Васи
         */
        double brokerAccount = calculationAmountBrokerAccount(salary, period, month, salaryIncrease, percentBroker, percentageStock);
        System.out.println(brokerAccount);

    }

    public static int convertingYearToMonth(int year, int month) {

        return (year * 12) + month;
    }

    /**
     * Расчет повышения зарплаты каждые 6 месяцев
     */
    public static double incomeForPeriod(double salary, double salaryIncrease, int period, int month) {
        double sum = 0;
        int countMonth = 0;
        for (int i = 1; i <= month; i++) {
            countMonth += 1;
            if (countMonth <= period) {
                sum += salary;
            } else {
                salary = salary + salaryIncrease;
                countMonth = 1;
                sum += salary;
            }

        }
        return sum;
    }

    /**
     * Расчет средств на счету брокера
     */
    public static double calculationAmountBrokerAccount(double salary, int period, int month, double salaryIncrease, double percentBroker, double percentageStock) {
        double sumAccountBroker = 0;
        int countMonth = 0;
        for (int i = 1; i <= month; i++) {
            countMonth += 1;

            if (countMonth <= period) {
                sumAccountBroker += salary * percentBroker / 100;
                sumAccountBroker += sumAccountBroker * percentageStock / 100;

            } else {
                salary = salary + salaryIncrease;
                countMonth = 1;
                sumAccountBroker += salary * percentBroker / 100;
            }
        }
        return sumAccountBroker;
    }


    public static double calculationOfExpenses(double expensesMonth, double month) {
        return month * expensesMonth;
    }

    /**
     * Расчет средств на счету Васи
     */
    public static double countMoneyYourAccount(double sumSalaryFromPeriod, double expensesPeriod, double percentBroker) {
        double sumPercentBrokerFromSalary = sumSalaryFromPeriod * percentBroker / 100;
        return sumSalaryFromPeriod - expensesPeriod - sumPercentBrokerFromSalary;
    }


}

