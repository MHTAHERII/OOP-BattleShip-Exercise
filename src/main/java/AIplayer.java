import java.util.Random;

public class AIplayer {
    public static String makeMove() {
        Random rand = new Random();
        return "" + (char) ('A' + rand.nextInt(10)) + rand.nextInt(10);
    }
}

