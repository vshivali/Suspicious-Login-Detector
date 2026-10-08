import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.HashMap;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("logins.txt");
        HashMap<String, Integer> detector = new HashMap<>();

        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            String ipAdd = parts[0];
            String testResult = parts[1];
            if (testResult.equals("failed")) {
                if (detector.containsKey(ipAdd)) {
                    detector.put(ipAdd, detector.get(ipAdd)+1);
                }
                else {
                    detector.put(ipAdd, 1);
                }
            }
            //System.out.println(ipAdd + " | " +testResult );

        }
        System.out.println(detector);
        for (String ip: detector.keySet()) {
            int count = detector.get(ip);

            if (count >= 5) {
                System.out.println("Suspicious login detected! IP Address "+ ip+ " has had " + count+ " failed login attempts.");
                System.out.println("Verify IP Address: " + ip);
            }
        }
        scanner.close();

    }

}
