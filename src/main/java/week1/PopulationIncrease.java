package week1;

import java.util.Scanner;

public class PopulationIncrease {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {
            int PA = sc.nextInt();
            int PB = sc.nextInt();
            double G1 = sc.nextDouble();
            double G2 = sc.nextDouble();
            int years = 0;

            while (PA <= PB) {
                PA += (int) (PA * (G1 / 100));
                PB += (int) (PB * (G2 / 100));
                years++;
                if (years > 100) {
                    System.out.println("Mais de 1 seculo.");
                    break;
                }
            }
            if (years <= 100) {
                System.out.println(years + " anos.");
            }
        }

    }
}
