package week1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class WeightedAverages {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = 2, b = 3, c = 5;
        for (int i = 0; i < n; i++) {
            double k = sc.nextDouble();
            double l = sc.nextDouble();
            double m = sc.nextDouble();
            System.out.println(toDouble(((k * a) + (l * b) + (m * c)) / (a + b + c)));
        }
    }
    public static double toDouble(double v) {
        DecimalFormat decFormat = new DecimalFormat("#0.0");
        return Double.parseDouble(decFormat.format(v).replace(',', '.'));
    }
}
