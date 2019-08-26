package game;

import java.util.Scanner;

public class Main {

    public static void play() {
        Scanner scanner = new Scanner(System.in);
        TicTacToe game = new TicTacToe();
        System.out.println("Let's start a game :D");
        do {
            game.changePlayer();
            System.out.println("Player: " + game.getUserMark());
            System.out.println("enter row:");
            int putRow = scanner.nextInt();
            System.out.println("enter column:");
            int putCol = scanner.nextInt();

            game.placeMark(putRow, putCol);
            game.printBoard();

        } while (!game.checkForWin() && !game.isBoardFull());
        if (game.checkForWin()) {
            System.out.println("We have a winner! Congrats!");
           // System.exit(0);
        } else if (game.isBoardFull()) {

            System.out.println("Appears we have a draw!");

           // System.exit(0);

        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        play();
        System.out.println("Do you want play again? [Y/N}");
        String playAgain = scanner.nextLine();
        if (playAgain.equalsIgnoreCase("Y")) {
            play();
        } else if (playAgain.equalsIgnoreCase("N")) {
            System.out.println("Thanks for the game!");
        } else {
            System.out.println("Bad decision :'(");
        }
    }
}
