/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dataLayer.WarehouseDAO;

import bussinessLayer.entity.Warehouse;
import java.util.List;

/**
 *
 * @author trand
 */
public interface IWarehouseDAO {

    void createImportReceipt() throws Exception;

    void createExportReceipt() throws Exception;

    void showAllReceipt() throws Exception;

    void loadDataFromFile() throws Exception;

    void exportDataToFile() throws Exception;

    List<Warehouse> getList() throws Exception;
}
