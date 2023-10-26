package week1;

import java.util.Scanner;

public class GameTimeWithMinutes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int startH= sc.nextInt();
        int startM= sc.nextInt();
        int endH= sc.nextInt();
        int endM= sc.nextInt();

        int startMin = startH * 60 + startM;
        int endMin = endH * 60 - endM;
        int duration;

        if (startMin < endMin){
            duration = endMin - startMin;
        }else {
            duration = (24 * 60 - startMin) + endMin;
        }
        int hours = duration / 60;
        int minutes = duration % 60;
        System.out.printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)%n", hours, minutes);
    }
}
