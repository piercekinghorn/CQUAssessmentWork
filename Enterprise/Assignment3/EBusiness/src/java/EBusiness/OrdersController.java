//Author:Pierce Kinghorn 12091381
//Date: 7/10/2020
package EBusiness;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;

@ManagedBean(name = "ordersController")
@SessionScoped
public class OrdersController {

    // Attributes             
    @EJB
    private OrdersEJB ordersEJB;
    private String ordersName;
    private Long orderid;
    private String selectedOrders;
    private Orders orders = new Orders();
    private Orders ordersDetails = new Orders();
    private List<Orders> ordersList = new ArrayList<Orders>();
    private List<Orders> searchResults = new ArrayList<Orders>();
    private Long custId; 
    private String refId;
    private Customer customer;
    private Vehicle vehicle;
    
    // Public Methods           
    public String doCreateOrders() {
        //Set order customer,vehicle values
        customer = ordersEJB.selectCustomer(custId);
        orders.setCustomer(customer);
        vehicle = ordersEJB.selectVehicle(refId);
        orders.setVehicle(vehicle);
        
        //Create order
        Integer quantity = orders.getQuantity();
        Integer price = quantity * orders.getVehicle().getPrice();
        orders.setTotalprice(price);
        orders = ordersEJB.createOrders(orders);
        
        //Manage Vehicle Stock
        Long orderid = orders.getId();
        ordersEJB.updateStock(orderid, quantity);
           
        //Set customer orders   
        Long cid = customer.getId();
        List<Orders> list = ordersEJB.findOrdersByCustomer(cid);
        int size = list.size();
        ordersEJB.setOrders(size, cid);
     
        //End session return page
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        ordersList = ordersEJB.findOrders();
        return "listOrders.xhtml";
    }
    
    public String viewOrdersList() {
        ordersList = ordersEJB.findOrders();
        return "listOrders.xhtml";
    }
      
    public String searchOrders() {
        searchResults = ordersEJB.findOrdersById(orderid);      
        return "searchOrdersResults.xhtml";
    }
    
    public String totalAll(){
        int count = ordersList.size();
        String scount = "Total : " + Integer.toString(count);
        return scount;
    }
    
    public String totalSearch(){
        int count = searchResults.size();
        String scount = "Total Orders: " + Integer.toString(count);
        return scount;
    }

    //Getters & Setters         
    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public List<Orders> getOrdersList() {
        ordersList = ordersEJB.findOrders();
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    public String getOrdersName() {
        return ordersName;
    }

    public void setOrdersName(String ordersName) {
        this.ordersName = ordersName;
    }

    public List<Orders> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(List<Orders> searchResults) {
        searchResults = ordersEJB.findOrdersById(orderid);
        this.searchResults = searchResults;
    }
        
    public Orders getOrdersDetails() {
        return ordersDetails;
    }

    public void setOrdersDetails(Orders ordersDetails) {
        this.ordersDetails = ordersDetails;
    }

    public String getSelectedOrders() {
        return selectedOrders;
    }

    public void setSelectedOrders(String selectedOrders) {
        this.selectedOrders = selectedOrders;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }
    
    public void deleteOrder(Long id){
        ordersEJB.deleteOrder(id);  
    } 

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }   
}//End Class