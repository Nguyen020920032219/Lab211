/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataLayer;

import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

/**
 *
 * @author trand
 * @param <T>
 */
public class FileManager<T> implements IFileManager<T> {

    private String fileName;

    public FileManager() {
    }

    public FileManager(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<String> readDataFromFile() throws Exception {
        List<String> result;
        result = Files.readAllLines(new File(fileName).toPath(), StandardCharsets.UTF_8);
        return result;
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
