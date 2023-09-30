/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package applicationLayer.UI;

import applicationLayer.Utilities.DataInput;
import bussinessLayer.ProductService.IProductService;

/**
 *
 * @author trand
 */
public class ProductMenu {

    IProductService service;

    public ProductMenu(IProductService service) {
        this.service = service;
    }

    public void processMenuForProduct() {
        boolean stop = true;
        try {
            do {
                System.out.println("**********Product Management**********");
                System.out.println("1.Add product");
                System.out.println("2.Update product");
                System.out.println("3.Delete product");
                System.out.println("4.Show all product");
                System.out.println("5.Export to file");
                System.out.println("6.Back to main menu");
                int choice = DataInput.getChoice("Select:", 1, 6);
                switch (choice) {
                    case 1 -> {
                        service.add();
                    }
                    case 2 -> {
                        service.update();
                    }
                    case 3 -> {
                        service.delete();
                    }
                    case 4 -> {
                        service.printAll();
                    }
                    case 5 -> {
                        service.export();
                    }
                    case 6 -> {
                        stop = false;
                    }
                }
            } while (stop);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
