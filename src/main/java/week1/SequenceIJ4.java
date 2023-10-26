package week1;

import java.text.DecimalFormat;

public class SequenceIJ4 {
    public static void main(String[] args) {
        for (double i = 0; i <= 2; i += 0.2) {
            for (int j = 1; j <= 3; j++) {
                System.out.println("\nI=" + toString(toDouble(i)) + " J=" + toString(toDouble(i + j)));
            }
        }
    }

    public static String toString(double d) {
        if (d == (int) d) {
            return " " + (int) d;
        } else {
            return " " + d;
        }
    }

    public static double toDouble(double d) {
        DecimalFormat decFormat = new DecimalFormat("#0.0");
        return Double.parseDouble(decFormat.format(d).replace(',', '.'));
    }
}
