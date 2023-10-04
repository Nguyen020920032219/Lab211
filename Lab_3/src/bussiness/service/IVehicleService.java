/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bussiness.service;

import bussiness.entity.Vehicle;
import java.util.List;

/**
 *
 * @author trand
 */
public interface IVehicleService {

    void addNewVehicle(Vehicle vehicle) throws Exception;

    List<Vehicle> getList() throws Exception;

    public void saveVehicle() throws Exception;
}
