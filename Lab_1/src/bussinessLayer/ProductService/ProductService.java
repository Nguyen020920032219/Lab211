/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bussinessLayer.ProductService;

import dataLayer.DAOManage;
import dataLayer.IDAOManage;
import dataLayer.ProductDAO.IProductDAO;

/**
 *
 * @author trand
 */
public class ProductService implements IProductService {

    IProductDAO productAction;
    IDAOManage productDAOManage;

    public ProductService() {
    }

    public ProductService(String inputDataFile) throws Exception {
        this.productDAOManage = new DAOManage(inputDataFile);
        this.productAction = productDAOManage.productDAO();
    }

    @Override
    public void printAll() throws Exception {
        productAction.printAll();
    }

    @Override
    public void update() throws Exception {
        productAction.update();
    }

    @Override
    public void delete() throws Exception {
        productAction.delete();
    }

    @Override
    public void add() throws Exception {
        productAction.add();
    }

    @Override
    public void export() throws Exception {
        productAction.exportDataToFile();
    }
}
