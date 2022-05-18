package arma;

import java.io.BufferedReader;
import java.io.FileReader;

public class Scroller {

    public static void print(String filename) {
        boolean running = true;
        while (running) {
            running = readLineByLine(filename);
        }
    }

    private static boolean printLetterByLetter(String message) {
        for (char letter : message.toCharArray()) {
            System.out.print(letter);
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        System.out.println();
        return true;
    }

    private static boolean readLineByLine(String filename) {
        try (BufferedReader reader = new BufferedReader(
                new FileReader(filename))) {
            String message = reader.readLine();
            boolean running = true;
            while (message != null && running) {
                if (printLetterByLetter(message)) {
                    message = reader.readLine();
                } else {
                    running = false;
                }
            }
            return running;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
