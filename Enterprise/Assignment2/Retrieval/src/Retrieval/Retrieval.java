package Retrieval;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.NoResultException;
import java.io.*;

public class Retrieval {

    public static void main(String[] args) {
        
        //Create Reader
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String selection = null;
	boolean status=true;
        
        //Create Entity Manager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Constants.RETRIEVE_UNIT);
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        while(status){
            
            //Start query selection
            System.out.println();
            System.out.println("-----Select a query-----");
            System.out.println("Query Vehicles.........1");
            System.out.println("Query Customers........2");
            System.out.println("Query Orders...........3");
            System.out.println("------------------------");
            
            try {
                
                selection = input.readLine();
                if (selection.equalsIgnoreCase("1") || 
                        selection.equalsIgnoreCase("2") || 
                        selection.equalsIgnoreCase("3")) {
                    if (selection.equalsIgnoreCase("1")) {
                        System.out.print("Enter Vehicle Reference Number ");
	 		int ref = Integer.parseInt(input.readLine());
                        System.out.println();
                        tx.begin();
                            TypedQuery<Vehicle> query = em.createNamedQuery("findVehicleByRef", Vehicle.class);
                            query.setParameter("ReferenceID", ref);
                            Vehicle vehicle = query.getSingleResult();
                        tx.commit();
                        if (vehicle instanceof New) {
                           System.out.println("New Vehicle"); 
                        } else {
                           System.out.println("Used Vehicle");  
                        }
                        
                        System.out.println("Reference Number: "+vehicle.getId());
                        System.out.println("Make: "+vehicle.getMake());
                        System.out.println("Model: "+vehicle.getModel());
                        System.out.println("Drive Type: "+vehicle.getDriveType());
                        System.out.println("Colour: "+vehicle.getColour());
                        System.out.println("Transmission: "+vehicle.getTransmission());
                        System.out.println("Engine: "+vehicle.getEngine());
                        System.out.println("Fuel Type: "+vehicle.getFuelType());
                        System.out.println("Number of Doors: "+vehicle.getDoors());
                        System.out.println("Number of Seats: "+vehicle.getSeats());
                        System.out.println("Price: "+vehicle.getPrice());
                        System.out.println("Number of Cars: "+vehicle.getCarNo());    
                       
                        if (vehicle instanceof New) {
                            System.out.println("Warranty: "+((New)vehicle).getWarranty());
                            System.out.println("Extended Warranty: "+((New)vehicle).getExtWarranty());
                            System.out.println("Road Side Assistance: "+((New)vehicle).getRSA());
                        } else {
                            System.out.println("Odometer: "+((Used)vehicle).getOdometer());
                            System.out.println("Registration Number: "+((Used)vehicle).getRegoNo());
                            System.out.println("Registration Expiry: "+((Used)vehicle).getRegoExp());
                            System.out.println("Service History: "+((Used)vehicle).getServiceHist());
                            System.out.println("Car History: "+((Used)vehicle).getCarHist());
                            System.out.println("VIN: "+((Used)vehicle).getVIN());   
                        }
                    } else if (selection.equalsIgnoreCase("2") || selection.equalsIgnoreCase("3")) {
                        System.out.print("Enter Customer Name: ");
	 		String name= input.readLine();
                        System.out.println();
                        tx.begin();
                            TypedQuery<Customer> query = em.createNamedQuery("findCustomerByName", Customer.class);
                            query.setParameter("Name", name);
                            Customer customer = query.getSingleResult();
                        tx.commit();
                        if (selection.equalsIgnoreCase("2")) {
                            System.out.println("Name: "+customer.getName());
                            System.out.println("Email: "+customer.getEmail());
                            System.out.println("Phone: "+customer.getPhone());
                            System.out.println("Address: "+customer.getAddress());
                            System.out.println();
                        } else {
                            int length = customer.getOrders().size();
                            for (int i=0; i<length; i++) {
                            System.out.println();
                            System.out.println("Order ID: "+customer.getOrders().get(i).getId());
                            System.out.print("Customer: "+customer.getOrders().get(i).getCustomer().getName());
                            System.out.println();
                            System.out.println("Vehicle: "+customer.getOrders().get(i).getVehicle().getModel() +" "+ customer.getOrders().get(i).getVehicle().getMake());
                            }
                        }
                    }
                } else{
                    status=false; 
                }
            //Error Catching
            } catch (IOException e){
                System.out.println("IO: " + e.getMessage());
                System.exit(1);
            } catch (NoResultException ne) {
                System.out.println("No Results Found"); 
                tx.rollback();
            }   
        }
        //End Transactions
        em.close();
        emf.close();
    } 
}
