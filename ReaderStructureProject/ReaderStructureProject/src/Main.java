import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Path filePath = Paths.get("D:\\CodeProjects\\DataStructures\\DataStructuresJava\\ReaderStructureProject\\ReaderStructureProject\\src\\lorem.txt");
        Map<String, Integer> wordCo = new TreeMap<>();

        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase()
                        .replaceAll("\\p{Punct}", "")
                        .split("\\s+");
                for (String w : words) {
                    wordCo.put(w, wordCo.getOrDefault(w, 0) + 1);
                }
            }
        }

        for (Map.Entry<String, Integer> entry : wordCo.entrySet()) {
            System.out.printf("%s %d%n", entry.getKey(), entry.getValue());
        }
    }
}
