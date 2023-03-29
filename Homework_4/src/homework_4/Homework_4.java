/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package homework_4;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.io.IOException;

/**
 *
 * @author valera
 */
public class Homework_4 {
    
    public static void main(String[] args) throws FileNotFoundException, IOException{
        Scanner scan = new Scanner(System.in);
        System.out.println("Работу выполнил Гринченко Валерий, РИБО-01-21, Вариант №1" + "\n");

        int countOfFiles;
        System.out.println("Введите количество файлов для склейки:");
        countOfFiles = scan.nextInt();
        
        File[] fileArray = new File[countOfFiles];
        String path;
        File file;
        for (int i=0; i < fileArray.length; i++) {
            while (true) {
                System.out.println("\n");
                System.out.println("Введите путь " + (i+1) + "-го файла:");
                path = scan.next();
                file = new File(path);
                fileArray[i] = file;
                break;
            }
        }

        FileInputStream fis;
        byte[][] contentArray = new byte[countOfFiles][];
        byte[] fileContent;
        int countOfBytes = 0;
        for (int j=0; j < contentArray.length; j++) {
            fis = new FileInputStream(fileArray[j]);
            fileContent = new byte[fis.available()];
            countOfBytes = countOfBytes + fis.available();
            fis.read(fileContent);
            fis.close();
            contentArray[j] = fileContent;
        }

        File resultFile = new File(fileArray[0].getParent() + "\\Final.txt");
        byte[] resultArray = new byte[countOfBytes];
        int a = 0;
        for (int i=0; i < contentArray.length; i++) {
            for (int j=0; j < contentArray[i].length; j++) {
                resultArray[a] = contentArray[i][j];
                a++;
            }
        }
        
        System.out.println("\n");
        FileOutputStream fos = new FileOutputStream(resultFile);
        fos.write(resultArray);
        fos.close();
        System.out.println("Результат находится в файле по пути: " + resultFile.getPath());
    }
}