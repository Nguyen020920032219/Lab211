/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package data.vehicleDao;

import bussiness.entity.Vehicle;
import java.util.List;

/**
 *
 * @author trand
 */
public interface IVehicleDao {

    void loadDataFromFile() throws Exception;

    void exportDataToFile() throws Exception;

    void addNewVehicle(Vehicle vehicle) throws Exception;

    List<Vehicle> getList() throws Exception;

}
