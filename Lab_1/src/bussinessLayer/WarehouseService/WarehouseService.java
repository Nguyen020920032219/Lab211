/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bussinessLayer.WarehouseService;

import dataLayer.DAOManage;
import dataLayer.IDAOManage;
import dataLayer.WarehouseDAO.IWarehouseDAO;

/**
 *
 * @author trand
 */
public class WarehouseService implements IWarehouseService {

    IWarehouseDAO warehouseAction;
    IDAOManage warehouseDAOManage;

    public WarehouseService() {
    }

    public WarehouseService(String inputDataFile) throws Exception {
        this.warehouseDAOManage = new DAOManage(inputDataFile);
        this.warehouseAction = warehouseDAOManage.warehouseDAO();
    }

    @Override
    public void createImportReceipt() throws Exception {
        warehouseAction.createImportReceipt();
    }

    @Override
    public void createExportReceipt() throws Exception {
        warehouseAction.createExportReceipt();
    }

    @Override
    public void export() throws Exception {
        warehouseAction.exportDataToFile();
    }

    @Override
    public void printALlReceipt() throws Exception {
        warehouseAction.showAllReceipt();
    }
}
