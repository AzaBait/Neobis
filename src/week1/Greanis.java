package week1;

import java.util.Scanner;

public class Greanis {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inter = 0, gremio = 0, draw = 0, match = 0;
        int newMatch = 1;
        do {
            if (newMatch == 1){
                match++;
                int in = sc.nextInt();
                int gr = sc.nextInt();
                if (in > gr){
                    inter++;
                } else if (gr > in) {
                    gremio++;
                }else {
                    draw++;
                }
            }
            System.out.println("Novo grenal (1-sim 2-nao)");
            newMatch = sc.nextInt();

        }while(newMatch != 2);
        System.out.println(match + " grenais");
        System.out.println("Inter:" + inter);
        System.out.println("Gremio:" + gremio);
        System.out.println("Empates:" + draw);
        if (inter > gremio) {
            System.out.println("Inter venceu mais");
        } else if (inter < gremio) {
            System.out.println("Gremio venceu mais");
        } else {
            System.out.println("Nao houve vencedor");
        }
    }
}
