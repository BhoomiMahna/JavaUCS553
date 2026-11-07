
import java.io.*;

public class LogAnalyzer {
    public static void main(String[] args) {

        int totalEntries = 0;
        int errorCount = 0;
        int warningCount = 0;

        try {
            BufferedReader br = new BufferedReader(
                new FileReader("application.log")
            );

            BufferedWriter bw = new BufferedWriter(
                new FileWriter("filtered.log")
            );

            String line;

            while ((line = br.readLine()) != null) {

                totalEntries++;

                if (line.contains("ERROR")) {
                    errorCount++;
                    bw.write(line);
                    bw.newLine();
                }

                else if (line.contains("WARNING")) {
                    warningCount++;
                    bw.write(line);
                    bw.newLine();
                }
            }

            br.close();
            bw.close();

            System.out.println("Total Log Entries: " + totalEntries);
            System.out.println("ERROR Count: " + errorCount);
            System.out.println("WARNING Count: " + warningCount);

            System.out.println("Filtered logs saved successfully!");

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
