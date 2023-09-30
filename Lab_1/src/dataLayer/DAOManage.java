/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataLayer;

import dataLayer.ProductDAO.IProductDAO;
import dataLayer.ProductDAO.ProductDAO;
import dataLayer.WarehouseDAO.IWarehouseDAO;
import dataLayer.WarehouseDAO.WarehouseDAO;

/**
 *
 * @author trand
 */
public class DAOManage implements IDAOManage {

    IFileManager fileManager;

    public DAOManage() {
    }

    public DAOManage(String inputDataFile) {
        this.fileManager = new FileManager(inputDataFile);
    }

    @Override
    public IProductDAO productDAO() throws Exception {
        return new ProductDAO(fileManager);
    }

    @Override
    public IWarehouseDAO warehouseDAO() throws Exception {

        return new WarehouseDAO(fileManager);

    }
}
