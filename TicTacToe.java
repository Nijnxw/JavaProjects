package tictactoe;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        String divider = "---------";
        System.out.println("Enter cells: " + input);
        System.out.println(divider);
        System.out.println("| " + input.charAt(0) + " " + input.charAt(1) + " " + input.charAt(2) + " |");
        System.out.println("| " + input.charAt(3) + " " + input.charAt(4) + " " + input.charAt(5) + " |");
        System.out.println("| " + input.charAt(6) + " " + input.charAt(7) + " " + input.charAt(8) + " |");
        System.out.println(divider);

        char[][] grid = new char[3][3];
        int index = 0;
        int numX = 0;
        int numO = 0;
        int blank = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char ele = input.charAt(index);
                grid[i][j] = ele;
                index++;
                if (ele == 'X') {
                    numX++;
                } else if (ele == 'O') {
                    numO++;
                } else {
                    blank++;
                }
            }
        }

        int diff = numX - numO;
        if (diff > 1 || diff < -1) {
            System.out.println("Impossible");
            return;
        }

        boolean winX = false;
        boolean winO = false;
        for (int i = 0; i < 3; i++) {
            String r = "";
            String c = "";
            for (int j = 0; j < 3; j++) {
                r += grid[i][j];
                c += grid[j][i];
            }

            if (r.equals("XXX")) {
                winX = true;
            }
            if (r.equals("OOO")) {
                winO = true;
            }
            if (c.equals("XXX")) {
                winX = true;
            }
            if (c.equals("OOO")) {
                winO = true;
            }
        }

        String diagonal1 = "" + grid[0][0] + grid[1][1] + grid[2][2];
        String diagonal2 = "" + grid[0][2] + grid[1][1] + grid[2][0];

        if (diagonal1.equals("XXX")) {
            winX = true;
        }
        if (diagonal1.equals("OOO")) {
            winO = true;
        }
        if (diagonal2.equals("XXX")) {
            winX = true;
        }
        if (diagonal2.equals("OOO")) {
            winO = true;
        }

        if (winX && winO) {
            System.out.println("Impossible");
        } else if (winX) {
            System.out.println("X wins");
        } else if (winO) {
            System.out.println("O wins");
        } else if (blank == 0) {
            System.out.println("Draw");
        } else {
            System.out.println("Game not finished");
        }


    }
}