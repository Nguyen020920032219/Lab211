/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bussinessLayer.WarehouseService;

/**
 *
 * @author trand
 */
public interface IWarehouseService {

    void createImportReceipt() throws Exception;

    void createExportReceipt() throws Exception;

    void printALlReceipt() throws Exception;

    void export() throws Exception;
}
