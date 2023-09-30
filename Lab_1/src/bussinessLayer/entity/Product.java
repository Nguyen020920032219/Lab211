/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bussinessLayer.entity;

/**
 *
 * @author trand
 */
public class Product {

    private String code;
    private String name;
    private String manufacturing;
    private String expiration;
    private int quantity;

    public Product(String code, String name, String manufacturing, String expiration, int quantity) {
        this.code = code;
        this.name = name;
        this.manufacturing = manufacturing;
        this.expiration = expiration;
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturing() {
        return manufacturing;
    }

    public void setManufacturing(String manufacturing) {
        this.manufacturing = manufacturing;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return code + ", " + name + ", " + manufacturing + ", " + expiration + ", " + quantity;
    }
}
