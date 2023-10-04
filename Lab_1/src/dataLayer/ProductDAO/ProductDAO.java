/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataLayer.ProductDAO;

import applicationLayer.Utilities.DataInput;
import bussinessLayer.entity.Product;
import bussinessLayer.entity.Warehouse;
import dataLayer.DAOManage;
import dataLayer.IDAOManage;
import dataLayer.IFileManager;
import dataLayer.WarehouseDAO.IWarehouseDAO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author trand
 */
public class ProductDAO implements IProductDAO {

    IFileManager<Product> fileManager;
    List<Product> productList;
    IWarehouseDAO warehouseAction;
    IDAOManage warehouseDAOManage;

    public ProductDAO() {
        this.productList = new ArrayList<>();
    }

    public ProductDAO(IFileManager<Product> fileManager) throws Exception {
        this.productList = new ArrayList<>();
        this.fileManager = fileManager;
        this.warehouseDAOManage = new DAOManage("Warehouse.txt");
        this.warehouseAction = warehouseDAOManage.warehouseDAO();
        loadDataFromFile();
    }

    @Override
    public void loadDataFromFile() throws Exception {
        int quantity;
        String manufacturing, code, expiration, name;
        List<String> productData = fileManager.readDataFromFile();
        for (String p : productData) {
            List<String> product = Arrays.asList(p.split(","));
            code = product.get(0).trim();
            name = product.get(1).trim();
            manufacturing = product.get(2).trim();
            expiration = product.get(3).trim();
            quantity = Integer.parseInt(product.get(4).trim());
            Product newProduct = new Product(code, name, manufacturing, expiration, quantity);
            productList.add(newProduct);
        }
//        productList.sort(((o1, o2) -> o1.getQuantity() - o2.getQuantity()));
    }

    @Override
    public void exportDataToFile() throws Exception {
        String[] data;
        data = new String[productList.size()];
        int i = 0;
        for (Product product : productList) {
            data[i] = product.toString();
            i++;
        }
        fileManager.writeDataToFile(data);
        System.out.println(">>>>>Export successfully.");
    }

    @Override
    public List<Product> getList() throws Exception {
        if (productList.isEmpty()) {
            throw new Exception(">>>>>Product list ís empty.");
        }
        return productList;
    }

    @Override
    public void printAll() throws Exception {
        int quantity = DataInput.getInteger("Enter quantity:");
        if (productList.isEmpty()) {
            System.out.println(">>>>>Do not have any product, please add new.");
        } else {
            for (Product product : productList) {
                if (product.getQuantity() >= quantity) {
                    System.out.println(product + ", status= available");
                } else {
                    System.out.println(product+", status= not available");
                }
            }
        }
    }

    @Override
    public void update() throws Exception {
        try {
            Product fp = find();
            if (fp == null) {
                System.out.println(">>>>>>Update failed.");
                return;
            }
            for (Product product : productList) {
                if (product.getCode().equals(fp.getCode())) {
                    String name = DataInput.getString("Enter new name:");
                    if (name.isBlank()) {
                        name = product.getName();
                    }
                    String manufacturing = DataInput.getString("Enter new manufaturing:");
                    String newManufacturing;
                    if (manufacturing.isBlank()) {
                        newManufacturing = product.getManufacturing();
                    } else {
                        newManufacturing = DataInput.getDate(manufacturing);
                    }
                    String expiration = DataInput.getString("Enter new expiration:");
                    String newExpiration;
                    if (expiration.isBlank()) {
                        newExpiration = product.getExpiration();
                    } else {
                        newExpiration = DataInput.getDate(expiration);
                    }
                    String quantity = DataInput.getString("Enter new quantity:");
                    if (quantity.isBlank()) {
                        quantity = product.getQuantity() + "";
                    }
                    if (quantity.matches("\\d{1,10}")) {
                        product.setQuantity(Integer.parseInt(quantity.trim()));
                    } else {
                        System.out.println("Quantity invalid >>>>>Update failed.");
                    }
                    product.setName(name);
                    product.setManufacturing(newManufacturing);
                    product.setExpiration(newExpiration);
                    for (Warehouse warehouse : warehouseAction.getList()) {
                        List<Product> products = warehouse.getProducts();
                        for (Product product1 : products) {
                            if (product1.getCode().equalsIgnoreCase(fp.getCode())) {
                                product1.setName(name);
                                product1.setManufacturing(newManufacturing);
                                product1.setExpiration(newExpiration);
                            }
                        }
                    }
                    warehouseAction.exportDataToFile();
                }
            }
            System.out.println(">>>>>Update successfully.");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     *
     * @throws Exception
     */
    @Override
    public void delete() throws Exception {
        Product fp = find();
        if (fp == null) {
            System.out.println(">>>>>Delete failed.");
            return;
        }
        if (warehouseAction.getList().toString().contains(fp.getCode())) {
            System.out.println(">>>>>Product in receipt already, can not delete.");
            return;
        }
        System.out.println(">>>>>Do you want to delete:");
        System.out.println("1.YES");
        System.out.println("2.NO");
        int choice = DataInput.getInteger("Seclect:");
        if (choice == 1) {
            productList.remove(fp);
            System.out.println(">>>>>Delete successfully.");
        } else {
            System.out.println(">>>>>Your data not delete.");
        }
    }

    @Override
    public Product find() throws Exception {
        String code = DataInput.getString("Enter code:");
        for (Product product : productList) {
            if (product.getCode().equalsIgnoreCase(code)) {
                return product;
            }
        }
        System.out.print("Product dose not exist ");
        return null;
    }

    public void addProduct() {
        try {
            String code;
            code = DataInput.getString("Enter code:");
            for (Product product : productList) {
                if (product.getCode().equals(code)) {
                    System.out.println(">>>>>Product code is exist, please add again with another code.");
                    return;
                }
            }
            String name = DataInput.getString("Enter name:");
            String manufacturing = DataInput.getDate(DataInput.getString("Enter manufacturing:"));
            String expiration = DataInput.getDate(DataInput.getString("Enter expiration:"));
            int quantity = DataInput.getInteger("Enter quantity:");
            Product newProduct = new Product(code, name, manufacturing, expiration, quantity);
            productList.add(newProduct);
            System.out.println(">>>>>Add product successfully");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void add() throws Exception {
        boolean stop = true;
        addProduct();
        do {
            System.out.println("1.Continue to add");
            System.out.println("2.Back to product menu");
            int choice = DataInput.getInteger("Seclect:");
            if (choice == 2) {
                stop = false;
            } else {
                addProduct();
            }
        } while (stop);
    }

    //Xóa theo quantity:
//    @Override
//    public void delete() throws Exception {
//        String name = DataInput.getString("Enter name:");
//        do {
//            Product fp = find(name);
//            if (fp == null) {
//                break;
//            } else {
//                productList.remove(fp);
//            }
//        } while (true);
//    }
//
//    public Product find(String name) throws Exception {
//        for (Product product : productList) {
//            if (product.getName().equalsIgnoreCase(name)) {
//                return product;
//            }
//        }
//        return null;
//    }
    //set quantity theo name:
//    @Override
//    public void delete() throws Exception {
//        Scanner sc = new Scanner(System.in);
//        String name = sc.nextLine();
//        int quantity = sc.nextInt();
//        for (Product product : productList) {
//            if (product.getName().equalsIgnoreCase(name)) {
//                product.setQuantity(quantity);
//            } else {
//            }
//        }
//    }
}
