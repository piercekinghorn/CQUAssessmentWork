//Author:Pierce Kinghorn 12091381
//Date: 7/10/2020
package EBusiness;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries ({
    @NamedQuery(name = "findAllUsed", query = "SELECT u FROM Used u"),
    @NamedQuery(name = "findUsedByRef", query = "SELECT u FROM Used u WHERE u.refId= :ReferenceId"),
    @NamedQuery(name = "selectUsed", query = "SELECT u FROM Used u WHERE u.refId= :ReferenceId")
})
public class Used extends Vehicle{

    //Used attibutes
    private int Odometer;
    private String RegoNo;
    private int RegoExp;
    private String ServiceHist;
    private String CarHist;
    private String VIN;
    
    public Used(){
       
    }
    
    //Constructor
    public Used(Long id, String refId, String Make, String Model, String DriveType, String Colour, String Transmission,
            String Engine, String FuelType, int Doors, int Seats, int Price, int CarNo, int Odometer, String RegoNo,
            int RegoExp, String ServiceHist, String CarHist, String VIN){
        super(id, refId, Make, Model, DriveType, Colour, Transmission, Engine, FuelType, Doors, Seats, Price, CarNo);
        
        this.Odometer = Odometer;
        this.RegoNo = RegoNo;
        this.RegoExp = RegoExp;
        this.ServiceHist = ServiceHist;
        this.CarHist = CarHist;
        this.VIN = VIN;
        
        
    }

    //Get Set Methods
    public void setOdometer(int Odometer) {
        this.Odometer = Odometer;
    }

    public void setRegoNo(String RegoNo) {
        this.RegoNo = RegoNo;
    }

    public void setRegoExp(int RegoExp) {
        this.RegoExp = RegoExp;
    }

    public void setServiceHist(String ServiceHist) {
        this.ServiceHist = ServiceHist;
    }

    public void setCarHist(String CarHist) {
        this.CarHist = CarHist;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public int getOdometer() {
        return Odometer;
    }

    public String getRegoNo() {
        return RegoNo;
    }

    public int getRegoExp() {
        return RegoExp;
    }

    public String getServiceHist() {
        return ServiceHist;
    }

    public String getCarHist() {
        return CarHist;
    }

    public String getVIN() {
        return VIN;
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
        sb.append(", Odometer='").append(Odometer).append('\'');
        sb.append(", RegoNo='").append(RegoNo).append('\'');
        sb.append(", RegoExp='").append(RegoExp).append('\'');
        sb.append(", ServiceHist='").append(ServiceHist).append('\'');
        sb.append(", CarHist='").append(CarHist).append('\'');                                                
        sb.append(", VIN=").append(VIN);
        sb.append('}');
        return sb.toString(); 
    }

    
}
