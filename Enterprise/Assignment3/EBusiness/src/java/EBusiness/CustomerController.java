//Author:Pierce Kinghorn 12091381
//Date: 7/10/2020
package EBusiness;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;

@ManagedBean(name = "customerController")
@SessionScoped
public class CustomerController {

    // Attributes             
    @EJB
    private CustomerEJB customerEJB;
    private String customerName;
    private String selectedCustomer;
    private Long customerId;
    private Customer customer = new Customer();
    private Customer customerDetails = new Customer();
    private List<Customer> customerList = new ArrayList<Customer>();
    private List<Customer> searchResults = new ArrayList<Customer>();
    private List<Orders> customerOrdersList = new ArrayList<Orders>();
   

    // Public Methods           
    public String doCreateCustomer() {
        customer = customerEJB.createCustomer(customer);
        setCustomerOrders(customerOrdersList);
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        customerList = customerEJB.findCustomers();
        return "listCustomers.xhtml";
    }
    
    public String viewCustomerList() {
        customerList = customerEJB.findCustomers();
        return "listCustomers.xhtml";
    }
    
    public String viewCustomerDetails(Long id){
        customerDetails = customerEJB.selectCustomer(id);
        customerOrdersList = customerEJB.findOrdersByCustomer(id);
        return "success";
    }
     
    public String searchCustomers() {
        searchResults = customerEJB.findCustomerByName(customerName);
        
        return "searchCustomerResults.xhtml";
    }
    
    public String totalAll(){
        int count = customerList.size();
        String scount = "Total Customers: " + Integer.toString(count);
        return scount;
    }
    
    public String totalSearch(){
        int count = searchResults.size();
        String scount = "Total Customers: " + Integer.toString(count);
        return scount;
    }
        
    //Getters & Setters         
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Customer> getCustomerList() {
        customerList = customerEJB.findCustomers();
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Customer> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(List<Customer> searchResults) {
        searchResults = customerEJB.findCustomerByName(customerName);
        this.searchResults = searchResults;
    }

    public Customer getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(Customer customerDetails) {
        this.customerDetails = customerDetails;
    }

    public String getSelectedCustomer() {
        return selectedCustomer;
    }

    public void setSelectedCustomer(String selectedCustomer) {
        this.selectedCustomer = selectedCustomer;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public List<Orders> getCustomerOrdersList() {
        return customerOrdersList;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setCustomerOrdersList(List<Orders> customerOrdersList) {
        this.customerOrdersList = customerOrdersList;
    }
    
    public void setCustomerOrders(List<Orders> orders){
        customer.setOrders(customerOrdersList);
    }

}//End Class