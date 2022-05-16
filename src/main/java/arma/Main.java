package arma;

import java.io.*;
import java.awt.GraphicsEnvironment;
import java.util.Properties;

public class Main {
    static Process process;
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
            System.out.println(filename);
            String jarCommand = "java -jar " + filename +
                    prop.getProperty("artifactId") + "-" +
                    prop.getProperty("version") + "-" +
                    prop.getProperty("descriptorRef") + ".jar";
            process = Runtime.getRuntime().exec(new String[]{"cmd","/c","start","cmd","/k", jarCommand});
        }else{
            Scroller.print("");
            process.destroy();
        }
    }
}
