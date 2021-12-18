//Author: Pierce Kinghorn 12091381
//Last Edited: 19/08/2020
package Persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
//import javax.persistence.Query;
//import javax.persistence.TypedQuery;
//import java.util.Date;
//import java.util.List;
//import java.util.ArrayList;

public class Persist {

    public static void main(String[] args) {
        
        //Create New Cars
        New new1= new New();
        new1.setMake("Holden");
        new1.setModel("Whopper");
        new1.setDriveType("4x4");
        new1.setColour("Black");
        new1.setTransmission("Manual");
        new1.setEngine("V12");
        new1.setFuelType("Diesal");
        new1.setDoors(4);
        new1.setSeats(5);
        new1.setPrice(1000000);
        new1.setCarNo(20);
        new1.setWarranty(3);
        new1.setExtWarranty(5);
        new1.setRSA("Road Side Assistance+");
        
        New new2= new New();
        new2.setMake("Toyota");
        new2.setModel("Ridge");
        new2.setDriveType("4x4");
        new2.setColour("Silver");
        new2.setTransmission("Automatic");
        new2.setEngine("V4");
        new2.setFuelType("Diesal");
        new2.setDoors(2);
        new2.setSeats(2);
        new2.setPrice(850000);
        new2.setCarNo(10);
        new2.setWarranty(3);
        new2.setExtWarranty(5);
        new2.setRSA("Road Side Assistance");
        
        //Create Used Cars
        Used used1= new Used();
        used1.setMake("Holden");
        used1.setModel("Traveller");
        used1.setDriveType("4x4");
        used1.setColour("Black");
        used1.setTransmission("Manual");
        used1.setEngine("V12");
        used1.setFuelType("Diesal");
        used1.setDoors(4);
        used1.setSeats(5);
        used1.setPrice(1000000);
        used1.setCarNo(20);
        used1.setOdometer(10);
        used1.setRegoNo("ASD16FZ");
        used1.setRegoExp(2025);
        used1.setServiceHist("None");
        used1.setCarHist("None");
        used1.setVIN("VIN1234");
        
        Used used2= new Used();
        used2.setMake("Toyota");
        used2.setModel("Dirt Back");
        used2.setDriveType("Front Wheel");
        used2.setColour("White");
        used2.setTransmission("Manual");
        used2.setEngine("V8");
        used2.setFuelType("Diesal");
        used2.setDoors(3);
        used2.setSeats(4);
        used2.setPrice(1000000);
        used2.setCarNo(15);
        used2.setOdometer(10);
        used2.setRegoNo("89BC8AA");
        used2.setRegoExp(2025);
        used2.setServiceHist("Repaired Brakes");
        used2.setCarHist("Crash");
        used2.setVIN("VIN4321");
        
        //Create Customers
        Customer customer1= new Customer();
        customer1.setName("Joe Mith");
        customer1.setEmail("john@gmail.com");
        customer1.setPhone("042468128");
        customer1.setAddress("24 Street Road");
        
        Customer customer2= new Customer();
        customer2.setName("Smith John");
        customer2.setEmail("smith@gmail.com");
        customer2.setPhone("047912375");
        customer2.setAddress("63 James Street");
        
        //Create Orders
        Orders order1= new Orders();
        order1.setCustomer(customer1);
        order1.setVehicle(used2);
        customer1.getOrders().add(order1);
        
        Orders order2= new Orders();
        order2.setCustomer(customer1);
        order2.setVehicle(new1);
        customer1.getOrders().add(order2);

        Orders order3= new Orders();
        order3.setCustomer(customer2);
        order3.setVehicle(new2);
        customer2.getOrders().add(order3);
        
        Orders order4= new Orders();
        order4.setCustomer(customer2);
        order4.setVehicle(used1);
        customer2.getOrders().add(order2);
        
        //Create Entity Manager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Constants.PERSIST_UNIT);
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //Start Transaction
        tx.begin();
        
        //Persist Used Cars
        System.out.println("----------------------------------------");
        System.out.println("New Cars");
        
        em.persist(new1);
        System.out.println();
	System.out.println("Reference Number: "+new1.getId());
	System.out.println("Make: "+new1.getMake());
	System.out.println("Model: "+new1.getModel());
	System.out.println("Drive Type: "+new1.getDriveType());
	System.out.println("Colour: "+new1.getColour());
        System.out.println("Transmission: "+new1.getTransmission());
        System.out.println("Engine: "+new1.getEngine());
        System.out.println("Fuel Type: "+new1.getFuelType());
        System.out.println("Number of Doors: "+new1.getDoors());
        System.out.println("Number of Seats: "+new1.getSeats());
        System.out.println("Price: "+new1.getPrice());
        System.out.println("Number of Cars: "+new1.getCarNo());
        System.out.println("Warranty: "+new1.getWarranty());
        System.out.println("Extended Warranty: "+new1.getExtWarranty());
        System.out.println("Road Side Assistance: "+new1.getRSA());
        
        em.persist(new2);
        System.out.println();
	System.out.println("Reference Number: "+new2.getId());
	System.out.println("Make: "+new2.getMake());
	System.out.println("Model: "+new2.getModel());
	System.out.println("Drive Type: "+new2.getDriveType());
	System.out.println("Colour: "+new2.getColour());
        System.out.println("Transmission: "+new2.getTransmission());
        System.out.println("Engine: "+new2.getEngine());
        System.out.println("Fuel Type: "+new2.getFuelType());
        System.out.println("Number of Doors: "+new2.getDoors());
        System.out.println("Number of Seats: "+new2.getSeats());
        System.out.println("Price: "+new2.getPrice());
        System.out.println("Number of Cars: "+new2.getCarNo());
        System.out.println("Warranty: "+new2.getWarranty());
        System.out.println("Extended Warranty: "+new2.getExtWarranty());
        System.out.println("Road Side Assistance: "+new2.getRSA());
        
        //Persist Used Cars
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("Used Cars");
        
        em.persist(used1);
        System.out.println();
	System.out.println("Reference Number: "+used1.getId());
	System.out.println("Make: "+used1.getMake());
	System.out.println("Model: "+used1.getModel());
	System.out.println("Drive Type: "+used1.getDriveType());
	System.out.println("Colour: "+used1.getColour());
        System.out.println("Transmission: "+used1.getTransmission());
        System.out.println("Engine: "+used1.getEngine());
        System.out.println("Fuel Type: "+used1.getFuelType());
        System.out.println("Number of Doors: "+used1.getDoors());
        System.out.println("Number of Seats: "+used1.getSeats());
        System.out.println("Price: "+used1.getPrice());
        System.out.println("Number of Cars: "+used1.getCarNo());
        System.out.println("Odometer: "+used1.getOdometer());
        System.out.println("Registration Number: "+used1.getRegoNo());
        System.out.println("Registration Expiry: "+used1.getRegoExp());
        System.out.println("Service History: "+used1.getServiceHist());
        System.out.println("Car History: "+used1.getCarHist());
        System.out.println("VIN: "+used1.getVIN());
        
        em.persist(used2);
        System.out.println();
	System.out.println("Reference Number: "+used2.getId());
	System.out.println("Make: "+used2.getMake());
	System.out.println("Model: "+used2.getModel());
	System.out.println("Drive Type: "+used2.getDriveType());
	System.out.println("Colour: "+used2.getColour());
        System.out.println("Transmission: "+used2.getTransmission());
        System.out.println("Engine: "+used2.getEngine());
        System.out.println("Fuel Type: "+used2.getFuelType());
        System.out.println("Number of Doors: "+used2.getDoors());
        System.out.println("Number of Seats: "+used2.getSeats());
        System.out.println("Price: "+used2.getPrice());
        System.out.println("Number of Cars: "+used2.getCarNo());
        System.out.println("Odometer: "+used2.getOdometer());
        System.out.println("Registration Number: "+used2.getRegoNo());
        System.out.println("Registration Expiry: "+used2.getRegoExp());
        System.out.println("Service History: "+used2.getServiceHist());
        System.out.println("Car History: "+used2.getCarHist());
        System.out.println("VIN: "+used2.getVIN());
        
        //Persist Customers
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("Customers");
        
        em.persist(customer1);
        System.out.println();
        System.out.println("Name: "+customer1.getName());
        System.out.println("Email: "+customer1.getEmail());
        System.out.println("Phone: "+customer1.getPhone());
        System.out.println("Address: "+customer1.getAddress());
        
        em.persist(customer2);
        System.out.println();
        System.out.println("Name: "+customer2.getName());
        System.out.println("Email: "+customer2.getEmail());
        System.out.println("Phone: "+customer2.getPhone());
        System.out.println("Address: "+customer2.getAddress());
        
        //Persist Orders
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("Orders");
        
        em.persist(order1);
        System.out.println();
	System.out.println("Order ID: "+order1.getId());
	System.out.print("Customer: "+order1.getCustomer().getName());
        System.out.println();
	System.out.println("Vehicle: "+order1.getVehicle().getModel() +" "+ order1.getVehicle().getMake());
       
        em.persist(order2);
        System.out.println();
	System.out.println("Order ID: "+order2.getId());
	System.out.print("Customer: "+order2.getCustomer().getName());
        System.out.println();
	System.out.println("Vehicle: "+order2.getVehicle().getModel() +" "+ order2.getVehicle().getMake());
         
        em.persist(order3);
        System.out.println();
	System.out.println("Order ID: "+order3.getId());
	System.out.print("Customer: "+order3.getCustomer().getName());
        System.out.println();
	System.out.println("Vehicle: "+order3.getVehicle().getModel() +" "+ order3.getVehicle().getMake());

        em.persist(order4);
        System.out.println();
	System.out.println("Order ID: "+order4.getId());
	System.out.print("Customer: "+order4.getCustomer().getName());
        System.out.println();
	System.out.println("Vehicle: "+order4.getVehicle().getModel() +" "+ order4.getVehicle().getMake());
        System.out.println();
        
        //End Transaction
        tx.commit();
	em.close();
        emf.close();
    }
}
