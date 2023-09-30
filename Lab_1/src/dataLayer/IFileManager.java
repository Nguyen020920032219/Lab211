/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dataLayer;

import java.util.List;

/**
 *
 * @author trand
 * @param <T>
 */
public interface IFileManager<T> {

    List<String> readDataFromFile() throws Exception;

    void writeDataToFile(String[] data) throws Exception;
}
