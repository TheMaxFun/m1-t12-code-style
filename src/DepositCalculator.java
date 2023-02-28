import java.util.Scanner;

public class DepositCalculator {
    double CalculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow ((1 + yearRate / 12), 12 * depositPeriod);
        return round (pay, 2);
    }

    double CalculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return round (amount + amount * yearRate * depositPeriod, 2);
    }

    double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calculateDeposit() {
        int period;
        int action;
        int amount;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        double out = 0;

        if (action == 1) {
            out = CalculateSimplePercent (amount, 0.06, period);
        } else if (action == 2) {
            out = CalculateComplexPercent (amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }
    public static void main(String[] args) {
        new DepositCalculator().calculateDeposit();
    }
}