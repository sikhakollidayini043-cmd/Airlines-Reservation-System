package com.airlines.util;

import java.io.*;

public class FileHandler {

    public static void saveObject(Object obj, String fileName) {

        try (ObjectOutputStream out =
                new ObjectOutputStream(
                        new FileOutputStream(fileName))) {

            out.writeObject(obj);
            System.out.println("Data saved successfully!");

        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }
    }

    public static Object loadObject(String fileName) {

        try (ObjectInputStream in =
                new ObjectInputStream(
                        new FileInputStream(fileName))) {

            return in.readObject();

        } catch (FileNotFoundException e) {
            return null;

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("File Error: " + e.getMessage());
            return null;
        }
    }
}