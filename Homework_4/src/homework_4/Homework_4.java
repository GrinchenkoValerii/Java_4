/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package homework_4;
import java.io.FileReader;
import java.util.Scanner;
import java.io.IOException;

/**
 *
 * @author valera
 */
public class Homework_4 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Работу выполнил Гринченко Валерий, РИБО-01-21, Вариант №1" + "\n");
        
        String Str = "";
        String Pyt = "";
        int s = 0;
        System.out.println("Введите символ или символы, какими разделить содержимое файлом в итоговом файле (' ', ', ' и тд):");
        String raz = scan.nextLine();
        
        System.out.println("\n");
        System.out.println("Введите количество файлов для склейки:");
        int kolvo = scan.nextInt();
        while (kolvo >= 1){
            kolvo = kolvo - 1;
            int Qw = 1;
            String str = "";
            s = s + 1;
            System.out.println("\n");
            System.out.println("Введите путь " + s + "-го файла:");
            String path = scan.next();
            if (Qw != 0){
                Qw = Qw - 1;
                Pyt = path;
            }
            
            try (FileReader reader = new FileReader(path)){
                int c;
                while ((c = reader.read()) != -1){
                    str = str + (char)c;
                }
                Str = Str + str + raz;
            }
            catch (IOException ex){
                System.out.println("При чтении из файла возникла ошибка: " + ex.getMessage());
            }
        }
        try {
            System.out.println("\n");
            Str = Str.substring(0, Str.length() - raz.length());
            Pyt = Pyt.substring(0, Pyt.lastIndexOf("\\")) + "\\Final.txt";
            FileUtils.writeStringToFile(Pyt, Str);
            System.out.println("Результат находится в файле по пути: " + Pyt);
        }
        catch (IOException ex){
            System.out.println("При записи в файл возникла ошибка: " + ex.getMessage());
        }
    }
}