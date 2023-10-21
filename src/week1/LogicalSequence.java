package week1;

import java.util.Scanner;

public class LogicalSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if (a >1 && a < 20 && a < b && b < 100000){
            for (int i = 1; i <= b; i++) {
                System.out.print(i);
                if (i % a == 0){
                    System.out.println("");
                }else {
                    System.out.print(" ");
                }
            }
        }
    }
}
