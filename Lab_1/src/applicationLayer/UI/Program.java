/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package applicationLayer.UI;

import applicationLayer.Utilities.DataInput;
import bussinessLayer.ProductService.ProductService;
import bussinessLayer.ProductService.IProductService;
import bussinessLayer.ReportService.IReportService;
import bussinessLayer.ReportService.ReportService;
import bussinessLayer.WarehouseService.IWarehouseService;
import bussinessLayer.WarehouseService.WarehouseService;

/**
 *
 * @author trand
 */
public class Program {

    public static void main(String[] args) {
        int choice;
        String productInputFile = "Product.txt";
        String warehouseInputFile = "Warehouse.txt";

        try {
            IProductService productService = new ProductService(productInputFile);
            IWarehouseService warehouseService = new WarehouseService(warehouseInputFile);
            IReportService repService = new ReportService(productInputFile, warehouseInputFile);
            do {
                System.out.println("**********Main Menu**********");
                System.out.println("1.Product Management");
                System.out.println("2.Warehouse Management");
                System.out.println("3.Report");
                System.out.println("4.Exit");
                choice = DataInput.getChoice("Select:", 1, 4);
                switch (choice) {
                    case 1 -> {
                        ProductMenu proMenu = new ProductMenu(productService);
                        proMenu.processMenuForProduct();
                    }
                    case 2 -> {
                        WarehouseMenu wareMenu = new WarehouseMenu(warehouseService);
                        wareMenu.processMenuForProduct();
                    }
                    case 3 -> {
                        ReportMenu repMenu = new ReportMenu(repService);
                        repMenu.processMenuForReport();
                    }
                    case 4 -> {
                        System.out.println("See ya!");
                        System.exit(0);
                    }
                }
            } while (true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
    //sua chuc nang show product co them cot status neu so luong >=x (x nhap tu ban phim ) thi status = available nguoc laij not available