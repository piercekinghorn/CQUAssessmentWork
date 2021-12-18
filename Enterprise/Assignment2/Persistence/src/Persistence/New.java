//Author: Pierce Kinghorn 12091381
//Last Edited: 22/08/2020
package Persistence;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "findAllUsed", query = "SELECT u FROM Used u")
public class New extends Vehicle{

    //New values
    private int Warranty;
    private int ExtWarranty;
    private String RSA;

    public New(){
       
    }
    
    //Constructor
    public New(String Make, String Model, String DriveType, String Colour, String Transmission,
            String Engine, String FuelType, int Doors, int Seats, int Price, int CarNo, int Warranty,
            int ExtWarranty, String RSA){
        super(Make, Model, DriveType, Colour, Transmission, Engine, FuelType, Doors, Seats, Price, CarNo);

        this.Warranty = Warranty;
        this.ExtWarranty = ExtWarranty;
        this.RSA = RSA;
        
    }

    //Get set methods
    public void setWarranty(int Warranty) {
        this.Warranty = Warranty;
    }

    public void setExtWarranty(int ExtWarranty) {
        this.ExtWarranty = ExtWarranty;
    }

    public void setRSA(String RSA) {
        this.RSA = RSA;
    }

    public int getWarranty() {
        return Warranty;
    }

    public int getExtWarranty() {
        return ExtWarranty;
    }

    public String getRSA() {
        return RSA;
    }
        
    @Override
    public String toString(){
        final StringBuilder sb = new StringBuilder();
        sb.append("Used");
        sb.append("{Reference Number=").append(id);
        sb.append(", Make='").append(Make).append('\'');
        sb.append(", Model=").append(Model);
        sb.append(", DriveType=").append(DriveType);
        sb.append(", Colour='").append(Colour).append('\'');
        sb.append(", Transmission='").append(Transmission);
        sb.append(", Engine='").append(Engine).append('\'');
        sb.append(", FuelType='").append(FuelType).append('\'');
        sb.append(", Doors='").append(Doors).append('\'');
        sb.append(", Seats='").append(Seats).append('\'');
        sb.append(", Price='").append(Price).append('\'');
        sb.append(", CarNo='").append(CarNo).append('\'');
        sb.append(", Warranty='").append(Warranty).append('\'');
        sb.append(", ExtWarranty='").append(ExtWarranty).append('\'');                                              
        sb.append(", RSA=").append(RSA);
        sb.append('}');
        return sb.toString(); 
    }

    
}
