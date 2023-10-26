package week1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class BanknotesAndCoins {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();
        if (n >= 0 && n <= 1000000){
            int notes[] = {100,50,20,10,5,2};
            double coins[] = {1.00, 0.50, 0.25, 0.10, 0.05, 0.01};
            System.out.println("NOTAS");
            for (int i = 0; i < notes.length; i++) {
                int t = (int) (n / notes[i]);
                System.out.printf("%d nota(s) de R$ %2f\n", t, (double)notes[i]);
                n = toDouble(n - notes[i] * t);
            }
            System.out.println("MOEDAS");
            for (int i = 0; i < coins.length; i++) {
                int t = (int) (n / coins[i]);
                System.out.printf("%d moeda(s) de R$ %2f\n", t, coins[i]);
                n = toDouble(n - coins[i]* t);
            }
        }
    }

    private static double toDouble(double v) {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        return Double.parseDouble(decimalFormat.format(v).replace(',','.'));
    }
}
