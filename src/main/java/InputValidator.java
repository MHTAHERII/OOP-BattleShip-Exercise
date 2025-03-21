import java.util.Scanner;

public class InputValidator {
    public static boolean validateInput(String input) {
        if (input.length() != 2) return false;
        char row = input.charAt(0);
        int cool;
        if (!Character.isDigit(input.charAt(1))) return false;
        else {
            cool = input.charAt(1);
        }

        return (row >= 'A' && row <= 'Z') && (cool >= '0' && cool <= '9');
    }

    public static void playerTurn(char[][] opponentGrid, char[][] trackingGrid,Boolean Bot) {
        Scanner input = new Scanner(System.in);
        Boolean Hit = true;
        String choice ;
        while (Hit) {
            System.out.println("Enter your choice : ");
            if (Bot) { choice=AIplayer.makeMove();
            }else {
                choice=input.nextLine().toUpperCase();
            }

            if (validateInput(choice)) {
                int row = choice.charAt(0) - 'A';
                int col = choice.charAt(1) - '0';
                if (opponentGrid[row][col] == '*') {

                    System.out.println("HIT");
                    System.out.println("As a reward, you can make another choice :");
                    opponentGrid[row][col] = 'X';
                    trackingGrid[row][col] = 'O';
                    Board.display(trackingGrid);
                } else {
                    System.out.println("MISS");
                    trackingGrid[row][col] = 'M';
                    Hit = false;
                }

            } else {
                System.out.println("INVALID INPUT");
                Hit = false;
            }
        }
    }
}
