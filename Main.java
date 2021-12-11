import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int size = 10;
        boolean turn = true;
        int win = 0;

        int[][] game = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                game[i][j] = 0;
            }
        }

        Scanner input = new Scanner(System.in);
        render(game);
        while (win == 0) {
            int row = -1;
            while (row > size || row < 1) {
                System.out.print("Enter a row : ");
                row = input.nextInt();
            }
            for (int i = size-1; i >= 0; i--) {
                if (game[i][row-1] == 0) {
                    game[i][row-1] = turn ? 1 : 2;
                    turn = !turn;
                    break;
                }
            }
            render(game);
            win = win(game);
        }
        System.out.println("Game Over");
        System.out.println("Player " + (win == 1 ? "X" : "O") + " wins");
    }

    private static void render(int[][] game) {
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game.length; j++) {
                System.out.print(game[i][j] == 0 ? "| " : game[i][j] == 1 ? "X " : "O ");
            }
            System.out.println();
        }
        for (int i = 0; i < game.length; i++) {
            System.out.print(i+1 + " ");
        }
        System.out.println();
    }

    private static int win(int[][] game) {
//        check row
        for (int i = 0; i < game.length; i++) {
            for (int j = 3; j < game.length; j++) {
                for (int k = 1; k < 3; k++) {
                    if (game[i][j - 3] == k && game[i][j - 2] == k && game[i][j - 1] == k && game[i][j] == k) {
                        return k;
                    }
                }
            }
        }
//        check column
        for (int i = 0; i < game.length; i++) {
            for (int j = 3; j < game.length; j++) {
                for (int k = 1; k < 3; k++) {
                    if (game[j-3][i] == k && game[j-2][i] == k && game[j-1][i] == k && game[j][i] == k) {
                        return k;
                    }
                }
            }
        }
//        check diagonal
        for (int i = 3; i < game.length; i++) {
            for (int j = 3; j < game.length; j++) {
                for (int k = 1; k < 3; k++) {
                    if (game[i-3][j-3] == k && game[i-2][j-2] == k && game[i-1][j-1] == k && game[i][j] == k) {
                        return k;
                    }
                }
            }
        }
        for (int i = 3; i < game.length; i++) {
            for (int j = 3; j < game.length; j++) {
                for (int k = 1; k < 3; k++) {
                    if (game[i-3][j] == k && game[i-2][j-1] == k && game[i-1][j-2] == k && game[i][j-3] == k) {
                        return k;
                    }
                }
            }
        }
        return 0;
    }
}