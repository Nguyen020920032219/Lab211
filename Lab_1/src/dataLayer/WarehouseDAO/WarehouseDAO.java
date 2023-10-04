/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataLayer.WarehouseDAO;

import applicationLayer.Utilities.DataInput;
import bussinessLayer.entity.Product;
import bussinessLayer.entity.Warehouse;
import dataLayer.IFileManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author trand
 */
public class WarehouseDAO implements IWarehouseDAO {

    IFileManager<Warehouse> fileManager;
    List<Warehouse> warehouseList;

    public WarehouseDAO() {
    }

    public WarehouseDAO(IFileManager<Warehouse> fileManager) throws Exception {
        this.fileManager = fileManager;
        this.warehouseList = new ArrayList<>();
        loadDataFromFile();
    }

    @Override
    public void loadDataFromFile() throws Exception {
        List<String> warehouseData = fileManager.readDataFromFile();
        for (String w : warehouseData) {
            if (w.isEmpty()) {
                break;
            }
            List<Product> productList = new ArrayList<>();
            List<String> warehouse = Arrays.asList(w.replace('[', ' ').replace(']', ' ').trim().split(","));
            String typeReceipt = warehouse.get(0).trim();
            String codeReceipt = warehouse.get(1).trim();
            String timeReceipt = warehouse.get(2).trim();
            int a = 3, b = (warehouse.size() - 3) / 5;
            for (int i = 0; i < b; i++) {
                String pCode = warehouse.get(a).trim();
                String pName = warehouse.get(a + 1).trim();
                String pManu = warehouse.get(a + 2).trim();
                String pExpi = warehouse.get(a + 3).trim();
                int pQuantity = Integer.parseInt(warehouse.get(a + 4).trim());
                Product newProduct = new Product(pCode, pName, pManu, pExpi, pQuantity);
                productList.add(newProduct);
                a += 5;
            }
            Warehouse newReceipt = new Warehouse(typeReceipt, codeReceipt, timeReceipt, productList);
            warehouseList.add(newReceipt);
        }
    }

    @Override
    public void exportDataToFile() throws Exception {
        String[] data = new String[warehouseList.size()];
        int i = 0;
        for (Warehouse warehouse : warehouseList) {
            data[i] = warehouse.toString();
            i++;
        }
        fileManager.writeDataToFile(data);

    }

    public String getMaxCodeIE() {
        if (warehouseList.isEmpty()) {
            return "1000000";
        } else {
            int maxCode = Integer.parseInt(warehouseList.get(0).getCodeIE());
            for (Warehouse warehouse : warehouseList) {
                if (maxCode <= (Integer.parseInt(warehouse.getCodeIE()))) {
                    maxCode = Integer.parseInt(warehouse.getCodeIE());
                }
            }
            return String.valueOf(maxCode);
        }
    }

    public Product getProduct() throws Exception {
        String pCode = DataInput.getString("Enter product code to add:");
        String pName = DataInput.getString("Enter product name:");
        String pManu = DataInput.getDate(DataInput.getString("Enter product Manufacturing:"));
        String pExpi = DataInput.getDate(DataInput.getString("Enter product Expiration:"));
        int pQuantity = DataInput.getInteger("Enter product quantity:");
        return new Product(pCode, pName, pManu, pExpi, pQuantity);
    }

    @Override
    public void createImportReceipt() throws Exception {
        String typeIE = "Import receipt";
        String codeIE = DataInput.getCode(getMaxCodeIE());
        String timeIE = DataInput.getCurrentTime();
        List<Product> productList = new ArrayList<>();
        Product item = getProduct();
        productList.add(item);
        do {
            System.out.println("1.Continue to add\n2.Confirm and create receipt");
            int choice = DataInput.getInteger("Select:");
            if (choice == 1) {
                item = getProduct();
                productList.add(item);
            } else if (choice == 2) {
                break;
            }
        } while (true);
        Warehouse newReceipt = new Warehouse(typeIE, codeIE, timeIE, productList);
        if (warehouseList.add(newReceipt)) {
            System.out.println(">>>>>Create successfully.");
        } else {
            System.out.println(">>>>>Create failed.");
        }
    }

    @Override
    public void createExportReceipt() throws Exception {
        String typeIE = "Export receipt";
        String codeIE = DataInput.getCode(getMaxCodeIE());
        String timeIE = DataInput.getCurrentTime();
        List<Product> productList = new ArrayList<>();
        Product item = getProduct();
        productList.add(item);
        do {
            System.out.println("1.Continue to add\n2.Confirm and create receipt");
            int choice = DataInput.getInteger("Select:");
            if (choice == 1) {
                item = getProduct();
                productList.add(item);
            } else if (choice == 2) {
                break;
            }
        } while (true);
        Warehouse newReceipt = new Warehouse(typeIE, codeIE, timeIE, productList);
        if (warehouseList.add(newReceipt)) {
            System.out.println(">>>>>Create successfully.");
        } else {
            System.out.println(">>>>>Create failed.");
        }
    }

    @Override
    public void showAllReceipt() throws Exception {
        if (warehouseList.isEmpty()) {
            System.out.println(">>>>>Do not have any receipt.");
        } else {
            for (Warehouse warehouse : warehouseList) {
                System.out.print(warehouse.getTypeRecipt() + ", ");
                System.out.print(warehouse.getCodeIE() + ", ");
                System.out.println(warehouse.getTimeIE() + ", ");
                for (Product product : warehouse.getProducts()) {
                    System.out.println("            " + product);
                }
            }

        }
    }

    @Override
    public List<Warehouse> getList() throws Exception {
        return warehouseList;
    }
}
