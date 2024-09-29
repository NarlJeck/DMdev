package ATM;

/**
 * Задание 1
 * <p>
 * Создать класс, описывающий банкомат.
 * <p>
 * Банкомат задается тремя свойствами:
 * - количеством купюр номиналом 10, 20 и 50.
 * <p>
 * Создать конструктор с тремя параметрами - количеством купюр каждого номинала.
 * <p>
 * Сделать методы для добавления денег в банкомат.
 * <p>
 * Сделать метод, снимающий деньги: он принимает сумму денег, а возвращает булево значение - успешность выполнения операции.
 * <p>
 * При снятии денег метод должен распечатывать каким количеством купюр какого номинала выдаётся сумма.
 * Сначала банкомат будет пытаться рассчитаться 50, далее добавит недостающие 20, и только затем 10 (не нужно рассматривать
 * более сложные варианты выдачи наличных, чтобы не усложнять алгоритм).
 */

public class Atm {

    private Integer countTen;
    private Integer countTwenty;
    private Integer countFifty;
    private final int ten = 10;
    private final int twenty = 20;
    private final int fifty = 50;

    public Atm(Integer countTen, Integer countTwenty, Integer countFifty) {
        this.countTen = countTen;
        this.countTwenty = countTwenty;
        this.countFifty = countFifty;
    }

    public int amountCashATM() {
        return (getCountFifty() * fifty) + (getCountTwenty() * twenty) + (getCountTen() * ten);
    }

    private int withdrawMoneyFifty(int amountWithdraw) {
        int countRemainder = 0;
        int remainderDivisionFifty = amountWithdraw % fifty;       //остаток от деления на 50
        int countFiftyCash = (amountWithdraw - remainderDivisionFifty) / fifty;//колличество купюр небходимое выдать
        if (getCountFifty() >= countFiftyCash) {            //проверяем количество купюр в банкомате
            setCountFifty(getCountFifty() - countFiftyCash);
            System.out.println("Количество 50 купюр: " + countFiftyCash);
        } else if (getCountFifty() > 0 && getCountFifty() < countFiftyCash) {
            countRemainder = countFiftyCash - getCountFifty();          //остаток если не хватило купюр
            System.out.println("Количество 50 купюр: " + getCountFifty());
            setCountFifty(0);
        }
        int carryOverBalance = remainderDivisionFifty + (countRemainder * fifty);     //переходящаясумма на проверку на 20

        return carryOverBalance;
    }

    private int withdrawMoneyTwenty(int carryOverBalance) {
        int countRemainder = 0;
        int remainderDivisionTwenty = carryOverBalance % twenty;       //остаток от деления на 50
        int countTwentyCash = (carryOverBalance - remainderDivisionTwenty) / twenty;//колличество купюр небходимое выдать
        if (getCountTwenty() >= countTwentyCash) {            //проверяем количество купюр в банкомате
            setCountTwenty(getCountTwenty() - countTwentyCash);
            System.out.println("Количество 20 купюр: " + countTwentyCash);
        } else if (getCountTwenty() > 0 && getCountTwenty() < countTwentyCash) {
            countRemainder = countTwentyCash - getCountTwenty();          //остаток если не хватило купюр
            setCountTwenty(0);
        }
        int carryOver = remainderDivisionTwenty + (countRemainder * twenty);     //переходящая сумма на проверку на 10

        return carryOver;
    }

    private void withdrawMoneyTen(int carryOver) {
        if (getCountTen() != 0) {
            int remainderDivisionTen = carryOver % ten;       //остаток от деления на 50
            int countTenCash = (carryOver - remainderDivisionTen) / ten;//колличество купюр небходимое выдать
            if (getCountTen() >= countTenCash) {            //проверяем количество купюр в банкомате
                setCountTen(getCountTen() - countTenCash);
                System.out.println("Количество 10 купюр: " + countTenCash);
            } else if (getCountTen() > 0 && getCountTen() < countTenCash) {
                System.out.println("В банкомате не достаточно средств");
//
            }
        } else System.out.println("Купюры наминалом 10 закончились ");


    }

    public boolean withdrawMoney(int amountWithdraw) {
        if (amountCashATM() < amountWithdraw || amountWithdraw < ten) {
            System.out.println("Операция не доступна");
            return false;
        }
        if (amountWithdraw > fifty && amountWithdraw % ten == 0) {
            int carryOverBalance = withdrawMoneyFifty(amountWithdraw);
            if (carryOverBalance == 0) {
                System.out.println("Операция успешна завершена");
            } else {
                int carryOver = withdrawMoneyTwenty(carryOverBalance);
                if (carryOver == 0) {
                    System.out.println("Операция успешна завершина");
                } else withdrawMoneyTen(carryOver);
            }
            return true;
        } else if (amountWithdraw < fifty && amountWithdraw >= twenty && amountWithdraw % ten == 0) {
            int carryOver = withdrawMoneyTwenty(amountWithdraw);
            if (carryOver == 0) {
                System.out.println("Операция успешна завершина");
            } else withdrawMoneyTen(carryOver);
            return true;
        } else if (amountWithdraw % ten == 0) {
            withdrawMoneyTen(amountWithdraw);
        }
        System.out.println("Операция не доступна, попробуйте другую сумму");
        return false;

    }

    public void addCashTenATM(int countCashTen) {

        setCountTen(countCashTen);
    }

    public void addCashTwentyATM(int countCashTwenty) {
        setCountTen(countCashTwenty);
    }

    public void addCashFiftyATM(int countCashFifty) {
        setCountTen(countCashFifty);
    }


    public void addCashInATM(int addCash) {
        if (addCash % 10 == 0) {
            int remainderAfterDivisionFifty = addCash % fifty;
            int countFiftyCash = (addCash - remainderAfterDivisionFifty) / fifty;
            setCountFifty(countFiftyCash);

            int remainderAfterDivisionTwenty = remainderAfterDivisionFifty % twenty;
            int countTwentyCash = (remainderAfterDivisionFifty - remainderAfterDivisionTwenty) / twenty;
            setCountTwenty(countTwentyCash);

            int remainderAfterDivisionTen = remainderAfterDivisionTwenty % ten;
            int countTenCash = (remainderAfterDivisionTwenty - remainderAfterDivisionTen) / ten;
            setCountTen(countTenCash);

            System.out.println("Вы добавили в банкомат: " + countFiftyCash + " - купюр наминалом 50");
            System.out.println("Вы добавили в банкомат: " + countTwentyCash + " - купюр наминалом 20");
            System.out.println("Вы добавили в банкомат: " + countTenCash + " - купюр наминалом 10");
        } else System.out.println("Введите сумма которая вмещает в себе только 10, 20, 50");

    }


    public int getCountTen() {
        return countTen;
    }

    public void setCountTen(int countTen) {
        this.countTen = countTen;
    }

    public int getCountTwenty() {
        return countTwenty;
    }

    public void setCountTwenty(int countTwenty) {
        this.countTwenty = countTwenty;
    }

    public int getCountFifty() {
        return countFifty;
    }

    public void setCountFifty(int countFifty) {
        this.countFifty = countFifty;
    }

    @Override
    public String toString() {
        return "Atm{" +
                "countTen=" + countTen +
                ", countTwenty=" + countTwenty +
                ", countFifty=" + countFifty +
                ", ten=" + ten +
                ", twenty=" + twenty +
                ", fifty=" + fifty +
                '}';
    }
}
