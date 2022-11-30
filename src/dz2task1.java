/*
    Распарсить файл с логами из заданий, выполненных на семинаре,
    найти записи уровня INFO/DEBUG.
*/

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class dz2task1 {
    public static void main(String[] args) throws IOException {

        System.out.println("Количество строк в файле:");
        int count = countStrings();
        System.out.println(count + "\n");

        System.out.println("Содержание исходного файла:");
        String[] arrayLines = ReadWrite(count);
        System.out.println("\n");

        System.out.println("Лог WARNING:");
        CheckInfo(arrayLines);

    }

    static int countStrings() throws IOException {
        FileReader inFile = new FileReader("log.txt");
        Scanner file = new Scanner(inFile);

        int count = 0;
        while (file.hasNextLine()) {
            file.nextLine();
            count = count + 1;
        }
        file.close();
        return count;
    }

    static String[] ReadWrite(int count) throws IOException {
        FileReader inFile = new FileReader("log.txt");
        Scanner file = new Scanner(inFile);

        String arrayLines[] = new String[count];
        int i = 0;

        while (file.hasNextLine()) {
            String temp = file.nextLine();
            arrayLines[i] = temp;
            System.out.println(arrayLines[i]);
            i++;
        }
        file.close();
        return arrayLines;
    }

    static void CheckInfo(String[] array) {
        for (int i = 1; i < array.length; i++) {
            String temp = array[i];
            if (temp.contains("WARNING")) {
                System.out.println(array[i - 1]);
                System.out.println(array[i]);
            }
        }
    }
}