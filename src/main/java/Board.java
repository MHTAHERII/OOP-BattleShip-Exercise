public class Board  {
    static final int GRID_SIZE = 10;
    public char[][] Grid;
    public char[][] trackingGrid;
     private  String Name;

    public String getName() {
        return Name;
    }

    public Board(String Name) {
        this.Name = Name;
        Grid = new char[GRID_SIZE][GRID_SIZE];
        trackingGrid = new char[GRID_SIZE][GRID_SIZE];
        initializeGrid(Grid);
        initializeGrid(trackingGrid);
    }

    private void initializeGrid(char[][] grid) {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = '~';
            }
        }
    }

    public static void display(char[][] grid) {
        System.out.print("  ");
        for (int i = 0; i < GRID_SIZE; i++) {
            System.out.print((i) + " ");
        }
        System.out.println();
        for (int i = 0; i < GRID_SIZE; i++) {
            System.out.print((char) (i + 'A') + " ");
            for (int j = 0; j < GRID_SIZE; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
