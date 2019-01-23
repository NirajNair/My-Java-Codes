package spiral_axb;

import java.util.Scanner;

public class spiral_axb {

    private static int[][] spiral;

    public static void main(String[] args){

        int n = 1;
        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        System.out.println("Enter no. of rows:");
        int a = input1.nextInt();
        System.out.println("Enter no. of cols:");
        int b = input2.nextInt();

        spiral = new int[a][b];

        int minRow=0;
        int maxRow=a-1;
        int minCol=0;
        int maxCol=b-1;

        while(n < a*b){

            if (checkFinished()) break;
            for(int i=maxRow; i>=minRow; i--){
                spiral[i][minCol]=n;
                n++;
                System.out.println("up");
                printTable();
            }

            if (checkFinished()) break;
            for (int i=minCol+1; i<=maxCol; i++){
                spiral[minRow][i]=n;
                n++;
                System.out.println("right");
                printTable();
            }

            if (checkFinished()) break;
            for (int i=minRow+1; i<=maxRow; i++){
                spiral[i][maxCol]=n;
                n++;
                System.out.println("down");
                printTable();
            }

            if (checkFinished()) break;
            for (int i = maxCol-1; i>=minCol+1; i--){
                spiral[maxRow][i]=n;
                n++;
                System.out.println("left");
                printTable();
            }

            minCol++;
            minRow++;
            maxCol--;
            maxRow--;


        }
        printTable();

    }
    public static void printTable(){
        for (int i=0; i<spiral.length; i++){
            for (int j =0; j<spiral[i].length; j++){
                System.out.print(spiral[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("------------------------------");
    }

    public static boolean checkFinished(){
        for (int i=0; i<spiral.length; i++){
            for (int j =0; j<spiral[i].length; j++){
                if (spiral[i][j] == 0)
                    return false;
            }
        }
        return true;
    }
}
