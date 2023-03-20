/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package homework_4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author valera
 */
public class FileUtils {
    
    public static boolean checkWorkDirectory(String path){
        File workPath = new File(path);
        if (workPath.exists()){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static void writeStringToFile(String path, String str) throws IOException{
        FileWriter fw = new FileWriter(path);
        fw.write(str);
        fw.close();
    }
    
    public static byte[] readBytesFromFile(String path) throws FileNotFoundException, IOException{
        File file = new File(path);
        if (file.exists()){
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[fis.available()];
            fis.read(data);
            fis.close();
            return data;
        }
        else{
            return new byte[]{};
        }
    }
}