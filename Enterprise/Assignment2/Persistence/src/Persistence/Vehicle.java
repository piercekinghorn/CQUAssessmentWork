//Author: Pierce Kinghorn 12091381
//Last Edited: 19/08/2020
package Persistence;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedQueries ({
    @NamedQuery(name = "findVehicleByRef", query = "SELECT v FROM Vehicle v WHERE v.id= :ReferenceID"),
})
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicle implements Serializable{
    
    //Vehicle values
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected String Make;
    protected String Model;
    protected String DriveType;
    protected String Colour;
    protected String Transmission;
    protected String Engine;
    protected String FuelType;
    protected int Doors;
    protected int Seats;
    protected int Price;
    protected int CarNo;

    public Vehicle(){
    
    }
    
    //Constructor
    public Vehicle(String Make, String Model, String DriveType, String Colour,
            String Transmission, String Engine, String FuelType, int Doors, int Seats, int Price, int CarNo){
        this.Make = Make;
        this.Model = Model;
        this.DriveType = DriveType;
        this.Colour = Colour;
        this.Transmission = Transmission;
        this.Engine = Engine;
        this.FuelType = FuelType;
        this.Doors = Doors;
        this.Seats = Seats;
        this.Price = Price;
        this.CarNo = CarNo;
    }

    //Get set methods
    public void setId(Long id) {
        this.id = id;
    }

    public void setMake(String Make) {
        this.Make = Make;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public void setDriveType(String DriveType) {
        this.DriveType = DriveType;
    }

    public void setColour(String Colour) {
        this.Colour = Colour;
    }

    public void setTransmission(String Transmission) {
        this.Transmission = Transmission;
    }

    public void setEngine(String Engine) {
        this.Engine = Engine;
    }

    public void setFuelType(String FuelType) {
        this.FuelType = FuelType;
    }

    public void setDoors(int Doors) {
        this.Doors = Doors;
    }

    public void setSeats(int Seats) {
        this.Seats = Seats;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public void setCarNo(int CarNo) {
        this.CarNo = CarNo;
    }

    public Long getId() {
        return id;
    }

    public String getMake() {
        return Make;
    }

    public String getModel() {
        return Model;
    }

    public String getDriveType() {
        return DriveType;
    }

    public String getColour() {
        return Colour;
    }

    public String getTransmission() {
        return Transmission;
    }

    public String getEngine() {
        return Engine;
    }

    public String getFuelType() {
        return FuelType;
    }

    public int getDoors() {
        return Doors;
    }

    public int getSeats() {
        return Seats;
    }

    public int getPrice() {
        return Price;
    }

    public int getCarNo() {
        return CarNo;
    }
}
