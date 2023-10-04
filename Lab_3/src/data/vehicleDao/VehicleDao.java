/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.vehicleDao;

import bussiness.entity.Vehicle;
import data.FileManager;
import data.IFileManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author trand
 */
public class VehicleDao implements IVehicleDao {

    IFileManager fileManager;
    List<Vehicle> vehicleList = new ArrayList<>();

    public VehicleDao(String fileName) throws Exception {
        this.fileManager = new FileManager(fileName);
        loadDataFromFile();
    }

    @Override
    public void loadDataFromFile() throws Exception {
        List<String> vehicleData = fileManager.readDataFromFile();
        for (String string : vehicleData) {
            var vehicle = Arrays.asList(string.split(","));
            String id = vehicle.get(0).trim();
            String name = vehicle.get(1).trim();
            String color = vehicle.get(2).trim();
            int price = Integer.parseInt(vehicle.get(3).trim());
            String brand = vehicle.get(4).trim();
            String type = vehicle.get(5).trim();
            int year = Integer.parseInt(vehicle.get(6).trim());
            Vehicle newVehicle = new Vehicle(id, name, color, price, brand, type, year);
            vehicleList.add(newVehicle);
        }
    }

    @Override
    public void exportDataToFile() throws Exception {
        String[] data;
        data = new String[vehicleList.size()];
        int i = 0;
        for (Vehicle vehicle : vehicleList) {
            data[i] = vehicle.toString();
            i++;
        }
        fileManager.writeDataToFile(data);
    }

    @Override
    public void addNewVehicle(Vehicle vehicle) throws Exception {
        vehicleList.add(vehicle);
    }

    @Override
    public List<Vehicle> getList() throws Exception {
        if (vehicleList.isEmpty()) {
            throw new Exception(">>>>>Vehicle list is empty.");
        } else {
            return vehicleList;
        }
    }

}
