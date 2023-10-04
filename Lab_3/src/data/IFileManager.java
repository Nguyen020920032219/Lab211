/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package data;

import java.util.List;

/**
 *
 * @author trand
 */
public interface IFileManager {

    List<String> readDataFromFile() throws Exception;

    void writeDataToFile(String[] data) throws Exception;
}
