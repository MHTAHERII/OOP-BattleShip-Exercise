import java.util.Scanner;

public class Game {
    public static void Start() {
        Scanner input = new Scanner(System.in);
        System.out.println(" player 1 Please enter your name: ");
        String name1 = input.nextLine();
        String name2;
        if (!main.Bot)
        {
            System.out.println(" player 2 Please enter your name: ");
             name2 = input.nextLine();
        }
        else
        {
            name2= "Bot";
        }
        Board board1 = new Board(name1);
        Board board2 = new Board(name2);
        boolean player1turn = true;
        System.out.println("Do you want your ships to be randomly selected or do you want to select them yourself?\n1. Random\n2. My choice");
        String choice = input.nextLine();

        switch (choice) {
            case "1":
                ShipPlacer.placeShipsRandomly(board1.Grid);
                ShipPlacer.placeShipsRandomly(board2.Grid);
                break;
            case "2":
                ShipPlacer.placeShips(board1.Grid,board1.getName());
                if (!main.Bot) {
                    ShipPlacer.placeShips(board2.Grid, board2.getName());
                } else {
                    ShipPlacer.placeShipsRandomly(board2.Grid);
                }
                break;
            default:
                System.out.println("Invalid choice. Try again");


        }


        while (!GameOver.isGameOver(board1.Grid, board2.Grid)) {
            if (player1turn) {
                System.out.println(board1.getName()+"'s turn:");
                Board.display(board1.trackingGrid);
                InputValidator.playerTurn(board2.Grid, board1.trackingGrid,false);
            } else {
                System.out.println(board2.getName()+"'s turn:");
                Board.display(board2.trackingGrid);
                InputValidator.playerTurn(board1.Grid, board2.trackingGrid,main.Bot);
            }
            player1turn = !player1turn;
        }
        if (GameOver.allShipsSunk(board1.Grid)) {
            System.out.println(board1.getName()+"is win.");
        }
        else
        {
            System.out.println(board2.getName()+"is win.");
        }
        System.out.println("Game over.");

    }

}
