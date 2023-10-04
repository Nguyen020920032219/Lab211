/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bussinessLayer.ReportService;

/**
 *
 * @author trand
 */
public interface IReportService {

    void showExpiredProduct() throws Exception;

    void showSellingProduct() throws Exception;

    void showRunOutProduct() throws Exception;

    void showImExRecipt() throws Exception;

}
