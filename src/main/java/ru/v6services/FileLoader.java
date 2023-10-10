package ru.v6services;

import java.io.*;
import java.util.Map;

public class FileLoader {

    public static String readFile(String srcPath) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(srcPath))) {
            while (reader.ready()) {
                String line = reader.readLine();
                builder.append(line).append("\n");
            }
            return builder.toString().trim();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean writeToFile(Map<String, Integer> map, String outPath) {
        if (map == null) {
            return false;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outPath))) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                for (int i = 0; i < entry.getValue(); i++) {
                    writer.write(entry.getKey() + " " + entry.getValue());
                    writer.newLine();
                }
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}