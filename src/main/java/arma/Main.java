package arma;

import java.awt.*;
import java.io.Console;
import java.io.IOException;
import java.util.Properties;

public class Main {
    static String filename = "./code.txt";
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        prop.load(Main.class.getResourceAsStream("/main.properties"));
        Console console = System.console();
        if(console == null && !GraphicsEnvironment.isHeadless()){
            StringBuilder filename = new StringBuilder(Main.class.getProtectionDomain().getCodeSource().getLocation().toString().substring(6));
            String[] filenameParts = filename.toString().split("\\\\");
            filename = new StringBuilder();
            for (int i = 0; i < filenameParts.length-1; i++) {
                filename.append(filenameParts[i]);
            }
            String jarCommand = "java -jar " + filename +
                    prop.getProperty("artifactId") + "-" +
                    prop.getProperty("version") + "-" +
                    prop.getProperty("descriptorRef") + ".jar";
            Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"color f0 && "+jarCommand+"\"");
        } else {
            Scroller.print(filename);
        }
    }
}
