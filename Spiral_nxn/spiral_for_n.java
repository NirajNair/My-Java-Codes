package spiral_n;

import java.util.Scanner;

public class spiral_for_n {


    private static int[][] spiral;





    public static void main(String[] main){
        System.out.println("Enter a value n:");
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        int x =1;
        int minRow = 0;
        int maxRow = n-1;
        int minCol = 0;
        int maxCol = n-1;

        spiral = new int[n][n];

        while (x <= n*n)

        {
            for (int i = maxRow; i >= minRow; i--) {
                spiral[i][minCol] = x;
                x++;
                System.out.println("\nUp");
                printTable();
            }
            for (int i = minCol+1; i <= maxCol; i++) {
                spiral[minRow][i] = x;
                x++;
                System.out.println("\nRight");
                printTable();
            }
            for (int i = minRow+1; i <= maxRow; i++) {
                spiral[i][maxCol] = x;
                x++;
                System.out.println("\nDown");
                printTable();
            }
            for (int i = maxCol -1; i >= minCol+1; i--) {
                spiral[maxRow][i] = x;
                x++;
                System.out.println("\nLeft");
                printTable();
            }
//            for (int i = maxRow - 1; i > minRow; i--) {
//                spiral[i][minCol+1] = x;
//                x++;
//                System.out.println("\nDon't know");
//                printTable();
//            }


            minCol++;
            minRow++;
            maxCol--;
            maxRow--;
        }

        //for (int i =0; i<spiral.length; i++){
        //    for (int j= 0; j<spiral.length; j++){
        //        System.out.print(spiral[i][j] + " ");
        //    }
        //    System.out.println();
        //}
    }

    public static void printTable() {
        for (int i =0; i<spiral.length; i++){
            for (int j= 0; j<spiral.length; j++){
                System.out.print(spiral[i][j] + " ");
            }
            System.out.println();
        }
    }
}
