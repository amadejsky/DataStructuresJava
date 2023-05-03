package lib;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class OpenDataSites {

    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("D:\\CodeProjects\\DataStructures\\DataStructuresJava\\TQueues04_14\\src\\lib\\open_data_sites_2022_11_21.csv");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line = "";
        while ((line = br.readLine()) != null) {
            String[] fields = line.split(",");
            if (fields[2].equals("US State")) {
                System.out.println(fields[0] + " - " + fields[1]);
            }
        }

        br.close();
        fis.close();
    }
}
