import java.net.*;
import java.io.*;

public class weather {
    public static void main(String[] args) {
        try {
            String urlString = "https://api.openweathermap.org/data/2.5/weather?q=Madurai&units=metric&appid=09d84fe61da2ad5e5f545ea7af6e2de7";
            URL url = new URL(urlString);
            BufferedReader br = new BufferedReader(
                new InputStreamReader(url.openStream())
            );
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        }
        catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}