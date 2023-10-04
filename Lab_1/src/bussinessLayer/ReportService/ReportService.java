/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bussinessLayer.ReportService;

import applicationLayer.Utilities.DataInput;
import bussinessLayer.entity.Product;
import bussinessLayer.entity.Warehouse;
import dataLayer.DAOManage;
import dataLayer.IDAOManage;
import dataLayer.ProductDAO.IProductDAO;
import dataLayer.WarehouseDAO.IWarehouseDAO;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 *
 * @author trand
 */
public class ReportService implements IReportService {

    IProductDAO productAction;
    IWarehouseDAO warehouseAction;
    IDAOManage productDAOManage;
    IDAOManage warehouseDAOManage;

    public ReportService(String productData, String warehouseData) throws Exception {
        this.productDAOManage = new DAOManage(productData);
        this.warehouseDAOManage = new DAOManage(warehouseData);
        this.productAction = productDAOManage.productDAO();
        this.warehouseAction = warehouseDAOManage.warehouseDAO();
    }

    @Override
    public void showExpiredProduct() throws Exception {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            for (Product product : productAction.getList()) {
                Date manu = sdf.parse(product.getManufacturing());
                Date expi = sdf.parse(product.getExpiration());
                if (manu.after(expi)) {
                    System.out.println(product);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void showSellingProduct() throws Exception {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            for (Product product : productAction.getList()) {
                Date manu = sdf.parse(product.getManufacturing());
                Date expi = sdf.parse(product.getExpiration());
                if ((manu.before(expi) || manu.equals(expi)) && product.getQuantity() > 0) {
                    System.out.println(product);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void showRunOutProduct() throws Exception {
        try {
            productAction.getList().sort((product1, product2) -> product1.getQuantity() - product2.getQuantity());
            for (Product product : productAction.getList()) {
                if (product.getQuantity() <= 3) {
                    System.out.println(product);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void showImExRecipt() throws Exception {
        String code = DataInput.getString("Enter product code:");
        List<Product> productList = productAction.getList();
        List<Warehouse> warehouseList = warehouseAction.getList();
        String[] codeList = new String[productList.size()];
        for (int i = 0; i < productList.size(); i++) {
            codeList[i] = productList.get(i).getCode();
        }
        if (!Arrays.toString(codeList).contains(code)) {
            System.out.println(">>>>>Product does not exist.");
        } else {
            for (Warehouse warehouse : warehouseList) {
                for (Product product : warehouse.getProducts()) {
                    if (product.getCode().equalsIgnoreCase(code)) {
                        System.out.println(warehouse);
                    }
                }

            }
        }
    }
    //Sort theo date
//    @Override
//    public void showRunOutProduct() throws Exception {
//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//            Collections.sort(productAction.getList(), new Comparator<Product>() {
//                @Override
//                public int compare(Product o1, Product o2) {
//                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//                    try {
//                        return (sdf.parse(o1.getManufacturing())).compareTo(sdf.parse(o2.getManufacturing()));
//                    } catch (ParseException ex) {
//                        Logger.getLogger(ReportService.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    return 0;
//                }
//            });
//            for (Product product : productAction.getList()) {
//                if (product.getQuantity() <= 3) {
//                    System.out.println(product);
//                }
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
    
    //Sort theo name
//    @Override
//    public void showRunOutProduct() throws Exception {
//        try {
//            productAction.getList().sort((product1, product2) -> product1.getName().compareToIgnoreCase(product2.getName()));
//            for (Product product : productAction.getList()) {
//                if (product.getQuantity() <= 3) {
//                    System.out.println(product);
//                }
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
}
