//import scanner
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int size = 10;
        boolean turn = false;
        boolean win = false;
        int[][] game = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                game[i][j] = 0;
            }
        }
        Scanner input = new Scanner(System.in);
        while (win == false) {
            render(game);
//            win(game);
            System.out.print("Enter a row : ");
            int row = input.nextInt();
            for (int i = size-1; i >= 0; i--) {
                if (game[i][row-1] == 0) {
                    game[i][row-1] = turn ? 1 : 2;
                    turn = !turn;
                    break;
                }
            }
        }

    }

    private static void render(int[][] game) {
        for (int i = 0; i < game.length; i++) {
            System.out.print(i+1 + " ");
        }
        System.out.println();
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game.length; j++) {
                System.out.print(game[i][j] == 0 ? "| " : game[i][j] == 1 ? "X " : "O ");
            }
            System.out.println();
        }
    }

//    private static boolean win(int[][] game) {
//        for (int i = 0; i < game.length; i++) {
//            for (int j = 3; j < game.length; j++) {
//                if (game[i][j] == 1) {
//
//                }
//            }
//            }
//        return false;
//    }
}