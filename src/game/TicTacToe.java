package game;

import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private char userMark;

    public TicTacToe() {
        board = new char[3][3];
        userMark = 'o';
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void printBoard() {
        System.out.println("********************");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + board[i][j]);
            }
            System.out.println(" |");
        }

        System.out.println("********************");
    }

    public boolean isBoardFull() {
        boolean isFull = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    isFull = false;
                }
            }
        }

        return isFull;

    }

    public boolean checkForWin() {
        return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());
    }


        // Loop through rows and see if any are winners.

    private boolean checkRowsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2]) == true) {
                return true;
            }
        }
        return false;
    }





        // Loop through columns and see if any are winners.

    private boolean checkColumnsForWin() {

        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[0][i], board[1][i], board[2][i]) == true) {
                return true;
            }
        }
        return false;
    }





        // Check the two diagonals to see if either is a win. Return true if either wins.

    private boolean checkDiagonalsForWin() {
        return ((checkRowCol(board[0][0], board[1][1], board[2][2]) == true) || (checkRowCol(board[0][2], board[1][1], board[2][0]) == true));
    }


        // Check to see if all three values are the same (and not empty) indicating a win.

    private boolean checkRowCol(char c1, char c2, char c3) {
        return ((c1 != '-') && (c1 == c2) && (c2 == c3));
    }



    // Change player marks back and forth.

    public void changePlayer() {
        if (userMark == 'x') {
            userMark = 'o';
        }
        else {
            userMark= 'x';
        }
    }


        // Places a mark at the cell specified by row and col with the mark of the current player.

    public boolean placeMark(int row, int col) {

        // Make sure that row and column are in bounds of the board.
        Scanner scanner = new Scanner(System.in);
            if ((row >= 0) && (row < 3)) {
                if ((col >= 0) && (col < 3)) {
                    if (board[row][col] == '-') {
                        board[row][col] = userMark;
                        return true;
                    }else {
                        System.out.println("This place is taken, try again :)");
                        System.out.println("enter row:");
                        int r = scanner.nextInt();
                        System.out.println("enter column:");
                        int c = scanner.nextInt();
                        placeMark(r,c);
                    }
                }else{
                    System.out.println("Column number is outside the board. Try again :)");
                    System.out.println("enter column:");
                    int c = scanner.nextInt();
                    placeMark(row,c);
                }
            }else{
                System.out.println("Row number is outside the board. Try again :)");
                System.out.println("enter row:");
                int r = scanner.nextInt();
                placeMark(r,col);
            }

        return false;
    }

    public char getUserMark() {
        return userMark;
    }

    public void setUserMark(char userMark) {
        this.userMark = userMark;
    }
}
