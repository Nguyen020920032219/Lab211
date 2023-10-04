/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package applicationLayer.UI;

import applicationLayer.Utilities.DataInput;
import bussinessLayer.ReportService.IReportService;

/**
 *
 * @author trand
 */
public class ReportMenu {

    IReportService service;

    public ReportMenu(IReportService service) {
        this.service = service;
    }

    public void processMenuForReport() {
        boolean stop = true;
        try {
            do {
                System.out.println("**********Report**********");
                System.out.println("1.Show expired product");
                System.out.println("2.Show selling product");
                System.out.println("3.Show product run out of stock");
                System.out.println("4.Show import/export recipt of product");
                System.out.println("5.Back to main menu");
                int choice = DataInput.getChoice("Select:", 1, 5);
                switch (choice) {
                    case 1 -> {
                        service.showExpiredProduct();
                    }
                    case 2 -> {
                        service.showSellingProduct();
                    }
                    case 3 -> {
                        service.showRunOutProduct();
                    }
                    case 4 -> {
                        service.showImExRecipt();
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
