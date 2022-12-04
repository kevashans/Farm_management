import java.util.Random;

public class Utility {
    public static int getRandom(int bottom, int upper) {
        Random rand = new Random();

        return rand.nextInt(bottom,upper);
    }
}
