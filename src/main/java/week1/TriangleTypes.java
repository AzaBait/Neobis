package week1;

import java.util.Arrays;
import java.util.Scanner;

public class TriangleTypes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 3 doubles > 0");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double arr[] = {a,b,c};
        Arrays.sort(arr);
        a = arr[2];
        b = arr[1];
        c = arr[0];
        double squareA = a * a;
        double squareB = b * b;
        double squareC = c * c;
        if (a >= b + c){
            System.out.println("NAO FORMA TRIANGULO");
        }else {
            if (squareA == squareB + squareC) {
                System.out.println("TRIANGULO RETANGULO");
            }
            if (squareA > squareB + squareC) {
                System.out.println("TRIANGULO OBTUSANGULO");
            }
            if (squareA < squareB + squareC) {
                System.out.println("TRIANGULO ACUTANGULO");
            }
            if (a == b && a == c && c == b) {
                System.out.println("TRIANGULO EQUILATERO");
            } else if ((a == b && a != c) || (b == c && b != a) || (a == c && a != b)) {
                System.out.println("TRIANGULO ISOSCELES");
            }
        }



    }
}
