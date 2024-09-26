package ATM;

public class ATMRunner {
    public static void main(String[] args) {
        Atm atm = new Atm(1, 5, 1);
        System.out.println("Сумма средств в банкомате: " + atm.amountCashATM());

        System.out.println(atm.withdrawMoney(40));
        System.out.println("Остаток средств в банкомате после операции: " + atm.amountCashATM());
    }
}
