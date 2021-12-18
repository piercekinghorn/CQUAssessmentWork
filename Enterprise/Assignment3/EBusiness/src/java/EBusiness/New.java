//Author:Pierce Kinghorn 12091381
//Date: 7/10/2020
package EBusiness;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries ({
    @NamedQuery(name = "findAllNew", query = "SELECT n FROM New n"),
    @NamedQuery(name = "findNewByRef", query = "SELECT n FROM New n WHERE n.refId= :ReferenceId"),
    @NamedQuery(name = "selectNew", query = "SELECT n FROM New n WHERE n.refId= :ReferenceId")
})


public class New extends Vehicle{

    //New values
    private int Warranty;
    private int ExtWarranty;
    private String RSA;

    public New(){
       
    }
    
    //Constructor
    public New(Long id, String refId, String Make, String Model, String DriveType, String Colour, String Transmission,
            String Engine, String FuelType, int Doors, int Seats, int Price, int CarNo, int Warranty,
            int ExtWarranty, String RSA){
        super(id, refId, Make, Model, DriveType, Colour, Transmission, Engine, FuelType, Doors, Seats, Price, CarNo);

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
        sb.append("{Reference Number=").append(refId);
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
}//End Class
