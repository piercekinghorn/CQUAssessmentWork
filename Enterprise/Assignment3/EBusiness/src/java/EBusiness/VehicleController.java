//Author:Pierce Kinghorn 12091381
//Date: 7/10/2020
package EBusiness;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;

@ManagedBean(name = "vehicleController")
@SessionScoped
public class VehicleController {

    //Attributes             
    @EJB
    private VehicleEJB vehicleEJB;
    

    //Vehicle Attibutes
    private Vehicle vehicle = new Vehicle();
    private List<Vehicle> vehicleList = new ArrayList<Vehicle>();
    private List<Vehicle> searchResults = new ArrayList<Vehicle>();
    
    //New Attibutes
    private String newRef;
    private New newVehicle  = new New();
    private New newDetails = new New();
    private List<New> newList = new ArrayList<New>();
    private List<New> newResults = new ArrayList<New>();

    //Used Attibutes
    private String usedRef;
    private Used usedVehicle  = new Used();
    private Used usedDetails = new Used();
    private List<Used> usedList = new ArrayList<Used>();
    private List<Used> usedResults = new ArrayList<Used>();
    
    //Determines if the vehicle is new or used and performs the required method
    public String vehicleDetails(String refid) {
        vehicle = vehicleEJB.selectVehicle(refid);
        String vid = vehicle.getRefId();
        char type = Character.valueOf(vid.charAt(0));
       
        if(type == 'N')
        {
            newDetails(refid); 
            return "searchNewSuccess";
        }
        else
        {
            usedDetails(refid);   
            return "searchUsedSuccess";
        }   
    }
        
    public String viewVehicleList() {
        vehicleList = vehicleEJB.findVehicles();
        return "listVehicles.xhtml";
    }
    
    public String viewVehicleDetails(String refId){
        vehicle = vehicleEJB.selectVehicle(refId);
        return "success";
    }

    //Getters & Setters         
    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public List<Vehicle> getVehicleList() {
        vehicleList = vehicleEJB.findVehicles();
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public List<Vehicle> getSearchResults() {
        return searchResults;
    }
           
    public String totalSearch(){
        int count = searchResults.size();
        String scount = "Total Vehicles: " + Integer.toString(count);
        return scount;
    }

    //New Methods
    public New getNewDetails() {
        return newDetails;
    }

    public void setNewDetails(New newDetails) {
        this.newDetails = newDetails;
    }

    public void setNewResults(List<New> newResults) {
        newResults = vehicleEJB.findNewByRef(newRef);
        this.newResults = newResults;
    }

    public List<New> getNewResults() {
        return newResults;
    }
    
    public void setNewVehicle(New newVehicle) {
        this.newVehicle = newVehicle;
    }

    public void setNewList(List<New> newList) {
        this.newList = newList;
    }
    
    public New getNewVehicle() {
        return newVehicle;
    }

    public List<New> getNewList() {
        newList = vehicleEJB.findNew();
        return newList;
    }
    
    public String totalNew(){
        int count = newList.size();
        String scount = "Total Vehicles: " + Integer.toString(count);
        return scount;
    }
    
    public String totalNewSearch(){
        int count = newResults.size();
        String scount = "Total Vehicles: " + Integer.toString(count);
        return scount;
    }
    
    public String getNewRef() {
        return newRef;
    }

    public void setNewRef(String newRef) {
        this.newRef = newRef;
    }
    
    public String newDetails(String refId){
        newResults = vehicleEJB.findNewByRef(refId);
        return "searchNewSuccess";
    }
    
    public String searchNew() {
        newResults = vehicleEJB.findNewByRef(newRef);
        return "searchNewResults.xhtml";
    }
    
    public String doCreateNew() {
        String nid = newVehicle.getRefId();
        nid = "N" + nid;
        newVehicle.setRefId(nid);
        newVehicle = vehicleEJB.createNew(newVehicle);
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        newList = vehicleEJB.findNew();
        return "listNew.xhtml";
    }
    
    //Used Methods   
    public Used getUsedDetails() {
        return usedDetails;
    }

    public void setUsedDetails(Used usedDetails) {
        this.usedDetails = usedDetails;
    }

    public void setUsedResults(List<Used> usedResults) {
        usedResults = vehicleEJB.findUsedByRef(usedRef);
        this.usedResults = usedResults;
    }

    public List<Used> getUsedResults() {
        return usedResults;
    }
    
    public void setUsedVehicle(Used usedVehicle) {
        this.usedVehicle = usedVehicle;
    }

    public void setUsedList(List<Used> usedList) {
        this.usedList = usedList;
    }
    
    public Used getUsedVehicle() {
        return usedVehicle;
    }

    public List<Used> getUsedList() {
        usedList = vehicleEJB.findUsed();
        return usedList;
    }
    
    public String totalUsed(){
        int count = usedList.size();
        String scount = "Total Vehicles: " + Integer.toString(count);
        return scount;
    }
    
    public String totalUsedSearch(){
        int count = usedResults.size();
        String scount = "Total Vehicles: " + Integer.toString(count);
        return scount;
    }
    
    public String getUsedRef() {
        return usedRef;
    }

    public void setUsedRef(String usedRef) {
        this.usedRef = usedRef;
    }
    
    public String usedDetails(String refId){
        usedResults = vehicleEJB.findUsedByRef(refId);
        return "searchUsedSuccess";
    }
    
    public String searchUsed() {
        usedResults = vehicleEJB.findUsedByRef(usedRef);
        return "searchUsedResults.xhtml";
    }
    
    public String doCreateUsed() {
        String uid = usedVehicle.getRefId();
        uid = "U" + uid;
        usedVehicle.setRefId(uid);
        usedVehicle = vehicleEJB.createUsed(usedVehicle);
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        usedList = vehicleEJB.findUsed();
        return "listUsed.xhtml";
    }        
}//End Class