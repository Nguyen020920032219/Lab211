/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

/**
 *
 * @author trand
 */
public class FileManager implements IFileManager {

    String fileName;

    public FileManager(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<String> readDataFromFile() throws Exception {
        return Files.readAllLines(new File(fileName).toPath(), StandardCharsets.UTF_8);
    }

    @Override
    public void writeDataToFile(String[] data) throws Exception {
        PrintWriter pw = new PrintWriter(fileName);
        for (String string : data) {
            pw.println(string);
        }
        pw.flush();
        pw.close();
    }

}
