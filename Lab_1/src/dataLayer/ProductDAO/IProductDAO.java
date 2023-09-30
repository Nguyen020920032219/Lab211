/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dataLayer.ProductDAO;

import bussinessLayer.entity.Product;
import java.util.List;

/**
 *
 * @author trand
 */
public interface IProductDAO {

    void add() throws Exception;

    List<Product> getList() throws Exception;

    void printAll() throws Exception;

    void update() throws Exception;

    void delete() throws Exception;

    Product find() throws Exception;

    void loadDataFromFile() throws Exception;

    void exportDataToFile() throws Exception;
}
