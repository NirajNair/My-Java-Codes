import java.util.Scanner;
import java.lang.String;

public class TicTacToe {

    private String[][] board = new String[3][3];
    static String turn = "X";
    static int move;

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        TicTacToe game = new TicTacToe();
        game.initializeBoard();

        do {
            System.out.println("Current board layout:");
            game.printBoard();
            int row;
            int col;

            do {
                System.out.println("Player " + turn + " will play first." );
                System.out.println("Enter row number:");
                row = userInput.nextInt() - 1;
                System.out.println("Enter column number:");
                col = userInput.nextInt() - 1;
            }
            while (!game.placeMark(row, col));

            game.changePlayer();
            move ++;
        }
        while (!game.checkWinner() && !game.boardFull() && move <9);

        if (!game.boardFull() && !game.checkWinner() && move == 9){
            System.out.println("This was tie.");
        }
        else {
            System.out.println("Current boards layout:");
            game.printBoard();
            game.changePlayer();
            System.out.println(turn + " Wins!");
        }
    }

    public void initializeBoard(){
        int move = 0;
        for (int i=0; i<3; i++){
            for (int j= 0; j<3; j++){
                board[i][j] = "-";
            }
        }
    }

    public void printBoard(){

        System.out.println("-------------");

        for (int i = 0; i<3; i++){
            System.out.print("| ");
            for (int j =0; j<3; j++){
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public void changePlayer(){
        if (turn == "X"){
            turn = "O";
        }
        else {
            turn = "X";
        }
    }

    public boolean checkWinner(){

            if (board[0][0] == board[0][1] && board[0][1] == board[0][2] )
                return true;
            else if (board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][2] != "-")
                return true;
            else if (board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][2] != "-")
                return true;
            else if (board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[2][0] != "-")
                return true;
            else if (board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[1][1] != "-")
                return true;
            else if (board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[1][2] != "-")
                return true;
            else if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[1][1] != "-")
                return true;
            else if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[1][1] != "-")
                return true;
            else
                return false;
        }


    public boolean placeMark(int row, int col){

        if (row>=0 && row<3){
            if (col>=0 && col<3){
                if (board[row][col] =="-" ){
                    board[row][col] = turn;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean boardFull(){
        for (int i =0; i<3; i++){
            for (int j =0; j<3; j++){
                if (board[i][j] != "-"){
                    return false;
                }

            }
        }
        return true;

    }

}