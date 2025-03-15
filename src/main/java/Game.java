import java.util.Scanner;

public class Game{
    public static void Start()
    {
        Scanner input = new Scanner(System.in);
        Board board1 = new Board();
        Board board2 = new Board();
        boolean player1turn= true;
        System.out.println("Do you want your ships to be randomly selected or do you want to select them yourself?\n1. Random\n2. My choice");
        String choice = input.nextLine();
        switch (choice) {
            case "1":ShipPlacer.placeShipsRandomly(board1.Grid);
                ShipPlacer.placeShipsRandomly(board2.Grid);
                break;
            case "2":
                break;
            default:
                System.out.println("Invalid choice. Try again");
        }


        while (!GameOver.isGameOver(board1.Grid,board2.Grid))
        {
            if (player1turn) {
                System.out.println("Player 1's turn:");
                Board.display(board1.trackingGrid);
                InputValidator.playerTurn(board2.Grid ,board1.trackingGrid);
            }
            else
            {
                System.out.println("Player 2's turn:");
                Board.display(board2.trackingGrid);
                InputValidator.playerTurn(board1.Grid,board2.trackingGrid);
            }
            player1turn=!player1turn;
        }
        System.out.println("Game Over");


    }
    public static void AIplay()
    {
        Scanner sc = new Scanner(System.in);

    }
}
