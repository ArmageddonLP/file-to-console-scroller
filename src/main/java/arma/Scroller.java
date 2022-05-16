package arma;

public class Scroller {

    public static void print(String filename) {
        boolean running = true;
        String message = "Hello world!\nTesting 1 2 3\n";

        while (running) {
            for (char letter : message.toCharArray()) {
                System.out.print(letter);
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                    running = false;
                    break;
                }
            }
        }
    }

}
