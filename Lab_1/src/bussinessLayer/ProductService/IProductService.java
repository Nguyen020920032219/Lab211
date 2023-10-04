/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bussinessLayer.ProductService;

import bussinessLayer.entity.Product;
import java.util.List;

/**
 *
 * @author trand
 */
public interface IProductService {

    void add() throws Exception;

    void printAll() throws Exception;

    void update() throws Exception;

    void delete() throws Exception;

    void export() throws Exception;
}
