/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.ui;

import application.utilities.DataInput;
import bussiness.entity.Vehicle;
import bussiness.service.IVehicleService;
import bussiness.service.VehicleService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trand
 */
public class Program {

    static IVehicleService service;

    public static void main(String[] args) {
        try {
            service = new VehicleService("Vehicle.txt");
            do {
                System.out.println("**********Vehicle Management**********");
                System.out.println("1.Add new vehicle");
                System.out.println("2.Check exist vehicle");
                System.out.println("3.Update vehicle");
                System.out.println("4.Delete vehicle");
                System.out.println("5.Search vehicle");
                System.out.println("6.Display all vehicle");
                System.out.println("7.Save all vehicle to file");
                System.out.println("8.Print all vehicle from file");
                System.out.println("9.Exit");
                int choice = DataInput.getChoice("Select:", 1, 9);
                switch (choice) {
                    case 1 -> {
                        addNewVehicle();
                    }
                    case 2 -> {
                        checkExistVehicle();
                    }
                    case 3 -> {
                        updateVehicle();
                    }
                    case 4 -> {
                        deleteVehicle();
                    }
                    case 5 -> {
                        searchVehicle();
                    }
                    case 6 -> {
                        displayAllVehicle();
                    }
                    case 7 -> {
                        saveAllVehicleToFile();
                    }
                    case 8 -> {
                        printAllVehicleFromFile();
                    }
                    case 9 -> {
                        System.out.println("See ya!");
                        System.exit(0);
                    }
                }
            } while (true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

//Thêm phương tiện vào List <=> case 1
    public static void addNewVehicle() throws Exception {
        Vehicle vehicle = getVehicle();
        if (vehicle == null) {
            System.out.println(">>>>>Add vehicle failed.");
        } else {
            service.addNewVehicle(vehicle);
            System.out.println(">>>>>Add vehicle successfully.");
        }
        do {
            System.out.println("1.Continue to add");
            System.out.println("0.Confirm and back to main menu");
            int choice = DataInput.getChoice("Select:", 0, 1);
            if (choice == 1) {
                vehicle = getVehicle();
                if (vehicle == null) {
                    System.out.println(">>>>>Add vehicle fail.");
                } else {
                    service.addNewVehicle(vehicle);
                    System.out.println(">>>>>Add vehicle successfully.");
                }
            } else {
                break;
            }
        } while (true);
    }

//Kiểm tra phương tiện có tồn tại hay không <=> case2 
    private static void checkExistVehicle() throws Exception {
        IVehicleService service_2 = new VehicleService("Vehicle.txt");
        String id = DataInput.getString("Enter id:");
        for (Vehicle vehicle : service_2.getList()) {
            if (vehicle.getId().equalsIgnoreCase(id)) {
                System.out.println(">>>>>Existed vehicle.");
            } else {
                System.out.println(">>>>>No vehicle found!");
            }
        }
    }

//Sửa đổi thông tin phương tiện <=> case 3
    private static void updateVehicle() throws Exception {
        Vehicle vehicle = searchVehicleByID();
        if (vehicle == null) {
            System.out.println(">>>>>Vehicle does not exist, update failed.");
        } else {
            String name = DataInput.getString("Enter new name:");
            if (name.isBlank()) {
                name = vehicle.getName();
            }
            String color = DataInput.getString("Enter new color:");
            if (color.isBlank()) {
                color = vehicle.getColor();
            }
            long price;
            do {
                String sprice = DataInput.getString("Enter new price:");
                if (sprice.isBlank()) {
                    price = vehicle.getPrice();
                    break;
                } else {
                    if (sprice.matches("\\d{1,100}")) {
                        price = Long.parseLong(sprice.trim());
                        break;
                    } else {
                        System.out.println(">>>>>Price invalid, the corect is long.");
                    }
                }
            } while (true);
            String brand = DataInput.getString("Enter new brand:");
            if (brand.isBlank()) {
                brand = vehicle.getBrand();
            }
            String type = DataInput.getString("Enter new type:");
            if (type.isBlank()) {
                type = vehicle.getType();
            }
            int year;
            do {
                String syear = DataInput.getString("Enter new year:");
                if (syear.isBlank()) {
                    year = vehicle.getYear();
                    break;
                } else {
                    if ((syear.matches("\\d{1,10}")) && ((Integer.parseInt(syear.trim())) >= 1)) {
                        year = Integer.parseInt(syear.trim());
                        break;
                    } else {
                        System.out.println(">>>>>Year invalid, the corect is integer>=1.");
                    }
                }
            } while (true);
            vehicle.setName(name);
            vehicle.setColor(color);
            vehicle.setBrand(brand);
            vehicle.setType(type);
            vehicle.setPrice(price);
            vehicle.setYear(year);
            System.out.println(">>>>>Update successfully.");
        }
    }

//Xóa phương tiện <=> case 4
    private static void deleteVehicle() throws Exception {
        Vehicle vehicle = searchVehicleByID();
        if (vehicle == null) {
            System.out.println(">>>>>Vehicle does not exist, delete failed.");
        } else {
            System.out.println("Do you want to delete?");
            System.out.println("1.Yes           0.No");
            int choice = DataInput.getChoice("Select:", 0, 1);
            if (choice == 1) {
                service.getList().remove(vehicle);
                System.out.println(">>>>>Delete successfully.");
            } else {
                System.out.println(">>>>>Vehicle not deleted.");
            }
        }
    }

//Tìm kiếm phương tiện <=> case 5
    private static void searchVehicle() throws Exception {
        System.out.println("*****Search Vehicle*****");
        System.out.println("1.Search vehicle by name");
        System.out.println("2.Search vehicle by id");
        int choice = DataInput.getChoice("Select:", 1, 2);
        if (choice == 1) {
            List<String> ids = searchVehicleByName();
            if (ids.isEmpty()) {
                System.out.println(">>>>>Don't have any vehicle with name contain inputed string.");
            } else {
                for (String id : ids) {
                    for (Vehicle vehicle : service.getList()) {
                        if (vehicle.getId().equalsIgnoreCase(id)) {
                            System.out.println(vehicle);
                        }
                    }
                }
            }
        } else if (choice == 2) {
            Vehicle vehicle = searchVehicleByID();
            if (vehicle == null) {
                System.out.println(">>>>>Vehicle does not exist.");
            } else {
                System.out.println(vehicle);
            }
        }
    }

//In ra phuong tiện <=> case 6
    private static void displayAllVehicle() throws Exception {
        try {
            System.out.println("*****Display Vehicle*****");
            System.out.println("1.Display all vehicle");
            System.out.println("2.Display vehicle by price");
            int choice = DataInput.getChoice("Select:", 1, 2);
            if (choice == 1) {
                for (Vehicle vehicle : service.getList()) {
                    System.out.println(vehicle);
                }
            } else if (choice == 2) {
                List<String> ids = searchVehicleByPrice();
                if (ids.isEmpty()) {
                    System.out.println(">>>>>Don't have any vehicle with price less than inputed price.");
                } else {
                    for (String id : ids) {
                        for (Vehicle vehicle : service.getList()) {
                            if (vehicle.getId().equalsIgnoreCase(id)) {
                                System.out.println(vehicle);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

//Lưu thông tin vào file <=> case 7
    private static void saveAllVehicleToFile() throws Exception {
        service.saveVehicle();
        System.out.println(">>>>>Save to file successfully.");
    }

//In thông tin phương tiện có trong file <=> case 8
    private static void printAllVehicleFromFile() throws Exception {
        try {
            IVehicleService service_3 = new VehicleService("Vehicle.txt");
            System.out.println("*****Print Vehicle");
            System.out.println("1.Print all vehicle");
            System.out.println("2.Print vehicle by year");
            int choice = DataInput.getChoice("Select:", 1, 2);
            if (choice == 1) {
                for (Vehicle vehicle : service_3.getList()) {
                    System.out.println(vehicle);
                }
            } else if (choice == 2) {
                List<String> ids = searchVehicleByYear();
                if (ids.isEmpty()) {
                    System.out.println(">>>>>Don't have any vehicle with year greater equal than inputed year.");
                } else {
                    for (String id : ids) {
                        for (Vehicle vehicle : service.getList()) {
                            if (vehicle.getId().equalsIgnoreCase(id)) {
                                System.out.println(vehicle);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static Vehicle getVehicle() throws Exception {
        String id = DataInput.getString("Enter id:");
        for (Vehicle vehicle : service.getList()) {
            if (vehicle.getId().equalsIgnoreCase(id)) {
                System.out.println(">>>>>Vehicle code existed.");
                return null;
            }
        }
        String name = DataInput.getString("Enter name:");
        String color = DataInput.getString("Enter color:");
        String brand = DataInput.getString("Enter brand:");
        String type = DataInput.getString("Enter type:");
        int price = -1, year = -1;
        try {
            price = DataInput.getInteger("Enter price:");
            year = DataInput.getYear("Enter year:");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (price == -1 || year == -1) {
            return null;
        } else {
            return new Vehicle(id, name, color, price, brand, type, year);
        }
    }

    private static Vehicle searchVehicleByID() throws Exception {
        String id = DataInput.getString("Enter id to search:");
        for (Vehicle vehicle : service.getList()) {
            if (vehicle.getId().equalsIgnoreCase(id)) {
                return vehicle;
            }
        }
        return null;
    }

    private static List<String> searchVehicleByName() throws Exception {
        String name = DataInput.getString("Enter name to search:");
        List<String> codes = new ArrayList<>();
        service.getList().sort((o1, o2) -> o2.getName().compareTo(o1.getName()));
        for (Vehicle vehicle : service.getList()) {
            if (vehicle.getName().contains(name)) {
                codes.add(vehicle.getId());
            }
        }
        return codes;
    }

    private static List<String> searchVehicleByPrice() throws Exception {
        long price = DataInput.getLong("Enter price to search:");
        List<String> codes = new ArrayList<>();
        service.getList().sort((o1, o2) -> {
            if (o2.getPrice() - o1.getPrice() > 0) {
                return 1;
            } else if (o2.getPrice() - o1.getPrice() < 0) {
                return -1;
            }
            return 0;
        });
        for (Vehicle vehicle : service.getList()) {
            if (vehicle.getPrice() < price) {
                codes.add(vehicle.getId());
            }
        }
        return codes;
    }

    private static List<String> searchVehicleByYear() throws Exception {
        int year = DataInput.getYear("Enter year to search:");
        List<String> codes = new ArrayList<>();
        IVehicleService service_4 = new VehicleService("Vehicle.txt");
        service_4.getList().sort((o1, o2) -> o2.getYear() - o1.getYear());
        for (Vehicle vehicle : service_4.getList()) {
            if (vehicle.getYear() >= year) {
                codes.add(vehicle.getId());
            }
        }
        return codes;
    }

}
