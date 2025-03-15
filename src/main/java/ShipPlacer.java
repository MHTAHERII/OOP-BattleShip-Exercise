import java.util.Random;

public class ShipPlacer {

    public static void placeShipsRandomly(char[][] grid) {
        placeShip(grid, 5);
        placeShip(grid, 4);
        placeShip(grid, 3);
        placeShip(grid, 2);
    }

    public static void placeShip(char[][] grid, int size) {
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
    public static boolean canPlaceShip(char[][] grid, int row, int col ,int size, boolean horizontal) {
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

}
