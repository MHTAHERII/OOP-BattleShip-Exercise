public class GameOver {
    public static boolean isGameOver(char[][] grid1, char[][] grid2) {
        return allShipsSunk(grid1) || allShipsSunk(grid2);
    }

    public static boolean allShipsSunk(char[][] grid) {
        for (int i = 0; i < Board.GRID_SIZE; i++) {
            for (int j = 0; j < Board.GRID_SIZE; j++) {
                if (grid[i][j] == '*') {
                    return false;
                }
            }
        }
        return true;
    }
}
