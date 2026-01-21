import java.util.Random;

public class SkyesUtils {
    public static void disp(String text, boolean question) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            sleep(0.05);
        }
        if (!question) {
            System.out.println();
        }
    }
    
    public static void progressBar(int length) {
        clear();
        System.out.print("<");
        sleep(0.05);
        for (int i = 0; i < length - 2; i++) {
            System.out.print("#");
            sleep(0.05);
        }
        System.out.println(">");
        sleep(2);
    }
    
    public static void sleep(double seconds) {
        int time = (int)(seconds * 1000);
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.out.println("ERR: Thread interruped");
            System.exit(1);
        }
    }
    
    public static void clear() {
        try {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        } catch (Exception e) {
            System.out.println("ERR: Couldn't clear terminal, ANSI codes not supported");
            System.exit(1);
        }
    }
    
    public static int rand(int min, int max) {
        Random random = new Random();
        int output = random.nextInt((max - min) + 1) + min;
        return output;
    }
}