import java.util.Scanner;

public class Game {
    private static Boolean Bot ;
    public  Game(Boolean Bot) {
        this.Bot = Bot;
    }

    public static Boolean getBot() {
        return Bot;
    }

    public static void Start() {
        Scanner input = new Scanner(System.in);
        System.out.println(" player 1 Please enter your name: ");
        String name1 = input.nextLine();
        Player player1 = new Player(name1);
        String name2;
        Player player2;
        if (!getBot())
        {
            System.out.println(" player 2 Please enter your name: ");
             name2 = input.nextLine();
              player2 = new Player(name2);
        }
        else
        {
            player2 = new Player("Bot");
        }
        Board board1 = new Board();
        Board board2 = new Board();
        boolean player1turn = true;
        System.out.println("Do you want your ships to be randomly selected or do you want to select them yourself?\n1. Random\n2. My choice");
        String choice = input.nextLine();

        switch (choice) {
            case "1":
                ShipPlacer.placeShipsRandomly(board1.Grid);
                ShipPlacer.placeShipsRandomly(board2.Grid);
                break;
            case "2":
                ShipPlacer.placeShips(board1.Grid, player1.getName());
                if (!getBot()) {
                    ShipPlacer.placeShips(board2.Grid,player2.getName());
                } else {
                    ShipPlacer.placeShipsRandomly(board2.Grid);
                }
                break;
            default:
                System.out.println("Invalid choice. Try again");


        }


        while (!GameOver.isGameOver(board1.Grid, board2.Grid)) {
            if (player1turn) {
                System.out.println(player1.getName()+"'s turn:");
                Board.display(board1.trackingGrid);
                InputValidator.playerTurn(board2.Grid, board1.trackingGrid,false);
            } else {
                System.out.println(player2.getName()+"'s turn:");
                Board.display(board2.trackingGrid);
                InputValidator.playerTurn(board1.Grid, board2.trackingGrid,getBot());
            }
            player1turn = !player1turn;
        }
        if (GameOver.allShipsSunk(board1.Grid)) {
            System.out.println(player1.getName()+"is win.");
        }
        else
        {
            System.out.println(player2.getName()+"is win.");
        }
        System.out.println("Game over.");

    }

}
