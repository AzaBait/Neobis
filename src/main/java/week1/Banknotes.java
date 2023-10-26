package week1;

import java.util.Scanner;

public class Banknotes {
    public static void main(String[] args) {
        // SIMPLE WAY

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter amount  ");
//        int money = sc.nextInt();
//        System.out.println(money);
//
//        int hundreds = money / 100;
//        System.out.println(hundreds + " nota (s) de R$ 100,00");
//        money = money % 100;
//
//        int fifties = money / 50;
//        System.out.println(fifties +" nota (s) de R$ 50,00");
//        money %= 50;
//
//        int  twenties = money / 20;
//        System.out.println(twenties + " nota (s) de R$ 20,00");
//        money %= 20;
//
//        int tens = money / 10;
//        System.out.println(tens + " nota (s) de R$ 10,00");
//        money %= 10;
//
//        int fives = money / 5;
//        System.out.println(fives + " nota (s) de R$ 5,00");
//        money %= 5;
//
//        int twos = money / 2;
//        System.out.println(twos + " nota (s) de R$ 2,00");
//        money %= 2;
//
//        System.out.println(money + " nota (S) de R$ 1,00");

        // USING LOOP
     Scanner sc = new Scanner(System.in);
     int n = sc.nextInt();
     if (n > 0 && n < 1000000){
         int notes[] = {100,50,20,10,5,2,1};
         System.out.println(n);
         for (int i = 0; i < notes.length; i++) {
             System.out.println(n/notes[i] + "nota (s) de R$ " + notes[i]+",00");
             n%=notes[i];
         }
     }

    }
}
