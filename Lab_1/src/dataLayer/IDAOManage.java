/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dataLayer;

import dataLayer.ProductDAO.IProductDAO;
import dataLayer.WarehouseDAO.IWarehouseDAO;

/**
 *
 * @author trand
 */
public interface IDAOManage {

    IProductDAO productDAO() throws Exception;

    IWarehouseDAO warehouseDAO() throws Exception;
}
