package week1;


import java.util.Scanner;

public class ColumnInDimensionalArray {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        double [][] arr = new double[3][3];
        int l = sc.nextInt();
        String s = sc.next();
        double sum = 0;
        if (l >= 0 && l <= 2){
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++){
                    arr[i][j] = sc.nextDouble();
                    if (l == j){
                        sum += arr[i][j];
                    }
                }
            }
            if ("S".equals(s)){
                System.out.printf("%.1f\n", sum);
            } else if ("M".equals(s)) {
                System.out.printf("%.1f\n", (sum / 3));
            }
        }
    }
}
