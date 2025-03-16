import java.util.Scanner;

public class main {
    static boolean Bot;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String number;

        String YELLOW = "\033[33m";
        String RESET = "\033[0m";
//        String RED = "\033[31m";
//        String BLUE = "\033[34m";

        System.out.println("\033[31m███    ███\033[34m ██   ██    ");
        System.out.println("\033[31m████  ████\033[34m ██   ██    ");
        System.out.println("\033[31m██ ████ ██\033[34m ███████    ");
        System.out.println("\033[31m██  ██  ██\033[34m ██   ██    ");
        System.out.println("\033[31m██      ██\033[34m ██   ██    \033[0m");





        while (true) {
            System.out.println(YELLOW + "💥🔥 Soldier! Get ready for battle! Welcome to the game! 🎖️🔫" + RESET);
//            System.out.println("Welcome to Battle Ship");
            System.out.println("Select the following options to play:");
            System.out.println("1. Two-player game");
            System.out.println("2. Play with AI");
            System.out.println("3. Exit");
            number = input.nextLine();
            switch (number) {
                case "1":
                    Bot = false;
                    Game.Start();

                    break;
                case "2":
                    Bot = true;
                    Game.Start();
                    break;
                case "3":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Input . Please try again .");
            }

        }
    }
}
