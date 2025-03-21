import java.util.Random;
import java.util.Scanner;

public class ShipPlacer {

    public static void placeShipsRandomly(char[][] grid) {
        placeShipRandom(grid, 5);
        placeShipRandom(grid, 4);
        placeShipRandom(grid, 3);
        placeShipRandom(grid, 2);
    }

    public static void placeShips(char[][] grid, String player) {
        placeShip(grid, 5, player);
        placeShip(grid, 4, player);
        placeShip(grid, 3, player);
        placeShip(grid, 2, player);
    }
    public static void placeShipRandom(char[][] grid, int size) {
        Random rand = new Random();
        boolean placeshipFound = false;
        while (!placeshipFound) {
            int x = rand.nextInt(Board.GRID_SIZE);
            int y = rand.nextInt(Board.GRID_SIZE);
            boolean horizontal = rand.nextBoolean();
            if (canPlaceShip(grid, x, y, size, horizontal)) {
                for (int i = 0; i < size; i++) {
                    if (horizontal) {
                        grid[x][y + i] = '*';
                    } else {
                        grid[x + i][y] = '*';
                    }
                }
                placeshipFound = true;
            }
        }
    }

    public static boolean canPlaceShip(char[][] grid, int row, int col, int size, boolean horizontal) {
        if (horizontal) {
            if (col + size > Board.GRID_SIZE) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (grid[row][col + i] == '*') {
                    return false;
                }
            }
        } else {
            if (row + size > Board.GRID_SIZE) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (grid[row + i][col] == '*') {
                    return false;
                }
            }

        }
        return true;

    }


    public static void placeShip(char[][] grid, int Size, String player) {
        Scanner input = new Scanner(System.in);
        String choice = "";
        String result;
        boolean horizontal = false;

        boolean placeshipFound = false;
        while (!placeshipFound) {
            Board.display(grid);
            System.out.println( player+" Enter the coordinates (row, column) of the tip of your desired ship, size" + Size + ".:");
            choice = input.nextLine().toUpperCase();
            if (InputValidator.validateInput(choice)) {
                while (true) {
                    System.out.println("Is it horizontal?(y/n)");
                    result = input.nextLine();
                    if (result.equals("y") || result.equals("Y")) {
                        horizontal = true;
                        break;
                    } else if (result.equals("n") || result.equals("N")) {
                        horizontal = false;
                        break;
                    } else {
                        System.out.println("Invalid choice. Please try again.");
                    }

                }
                int x = choice.charAt(0) - 'A';
                int y = choice.charAt(1) - '0';

                if (canPlaceShip(grid, x, y, Size, horizontal)) {
                    for (int i = 0; i < Size; i++) {
                        if (horizontal) {
                            grid[x][y + i] = '*';
                        } else {
                            grid[x + i][y] = '*';
                        }
                    }
                    placeshipFound = true;
                } else {
                    System.out.println("Invalid choice. Please try again.");

                }
            } else {
                System.out.println("Invalid choice. Please try again.");
            }

        }
    }
}