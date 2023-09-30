/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package applicationLayer.UI;

import applicationLayer.Utilities.DataInput;
import bussinessLayer.WarehouseService.IWarehouseService;

/**
 *
 * @author trand
 */
public class WarehouseMenu {

    IWarehouseService service;

    public WarehouseMenu(IWarehouseService service) {
        this.service = service;
    }

    public void processMenuForProduct() {
        boolean stop = true;
        try {
            do {
                System.out.println("**********Warehouse Management**********");
                System.out.println("1.Create import receipt");
                System.out.println("2.Create export receipt");
                System.out.println("3.Print all receipt");
                System.out.println("4.Export to file");
                System.out.println("5.Back to main menu");
                int choice = DataInput.getChoice("Select:", 1, 5);
                switch (choice) {
                    case 1 -> {
                        service.createImportReceipt();
                    }
                    case 2 -> {
                        service.createExportReceipt();
                    }
                    case 3 -> {
                        service.printALlReceipt();
                    }
                    case 4 -> {
                        service.export();
                        System.out.println(">>>>>Export successfully.");
                    }
                    case 5 -> {
                        stop = false;
                    }
                }
            } while (stop);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
