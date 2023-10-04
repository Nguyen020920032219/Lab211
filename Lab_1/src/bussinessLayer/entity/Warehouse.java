/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bussinessLayer.entity;

import java.util.List;

/**
 *
 * @author trand
 */
public class Warehouse {

    private String typeRecipt;
    private String codeIE;
    private String timeIE;
    private List<Product> products;

    public Warehouse() {

    }

    public Warehouse(String typeRecipt, String codeIE, String timeIE, List<Product> products) {
        this.typeRecipt = typeRecipt;
        this.codeIE = codeIE;
        this.timeIE = timeIE;
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getTypeRecipt() {
        return typeRecipt;
    }

    public void setTypeRecipt(String typeRecipt) {
        this.typeRecipt = typeRecipt;
    }

    public String getCodeIE() {
        return codeIE;
    }

    public void setCodeIE(String codeIE) {
        this.codeIE = codeIE;
    }

    public String getTimeIE() {
        return timeIE;
    }

    public void setTimeIE(String timeIE) {
        this.timeIE = timeIE;
    }

    @Override
    public String toString() {
        return typeRecipt + ", " + codeIE + ", " + timeIE + ", " + products;
    }

}
