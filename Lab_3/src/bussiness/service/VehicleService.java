/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bussiness.service;

import bussiness.entity.Vehicle;
import data.vehicleDao.IVehicleDao;
import data.vehicleDao.VehicleDao;
import java.util.List;

/**
 *
 * @author trand
 */
public class VehicleService implements IVehicleService {

    IVehicleDao vehicleAction;

    public VehicleService(String fileName) throws Exception {
        this.vehicleAction = new VehicleDao(fileName);
    }

    @Override
    public void addNewVehicle(Vehicle vehicle) throws Exception {
        vehicleAction.addNewVehicle(vehicle);
    }

    @Override
    public List<Vehicle> getList() throws Exception {
        return vehicleAction.getList();
    }

    @Override
    public void saveVehicle() throws Exception {
        vehicleAction.exportDataToFile();
    }

}
