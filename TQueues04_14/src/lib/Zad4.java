package lib;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Zad4 {
    public static void main(String[] args) {
        Stack st = new Stack();
        String filePath = "D:\\CodeProjects\\DataStructures\\DataStructuresJava\\TQueues04_14\\src\\lib\\open_data_sites_2022_11_21.csv";

        try (Scanner scanner = new Scanner(new FileInputStream(filePath))) {
            Queue<String[]> queue = new LinkedList<>();
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(",");
                queue.add(fields);
            }

            // Wyświetlenie informacji o krajach i stronach internetowych w odwrotnej kolejności niż w pliku
            while (!queue.isEmpty()) {
                String[] fields = queue.poll();
                String region = fields[0];
                String country = fields[1];

                st.push(country+" "+region);

            }

            while(!st.isEmpty()){
                System.out.println(st.pop());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
