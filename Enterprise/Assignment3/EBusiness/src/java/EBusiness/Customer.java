//Author:Pierce Kinghorn 12091381
//Date: 7/10/2020
package EBusiness;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

//Queries
@Entity
@NamedQueries ({
    @NamedQuery(name = "findAllCustomers", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "findCustomerByName", query = "SELECT c FROM Customer c WHERE c.Name= :Name"),
    @NamedQuery(name = "selectCustomerSize", query = "SELECT c FROM Customer c Where c.id= :id"), 
    @NamedQuery(name = "selectCustomer", query = "SELECT c FROM Customer c WHERE c.id= :id")
})
public class Customer implements Serializable {

    //Customer Values
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Name;
    private String Email;
    private String Phone;
    private String Address; 
    private int size;
    
    @OneToMany
    private List<Orders> orders;
    
    public Customer(){
        
    }
    //Constructor
    public Customer(Long id, String Name, String Email, String Phone, String Address){
        this.id = id;
        this.Name = Name;
        this.Email = Email;
        this.Phone = Phone;
        this.Address = Address; 
    }    

    //Get set methods
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhone() {
        return Phone;
    }

    public String getAddress() {
        return Address;
    }

    public List<Orders> getOrders() {
        return orders;
    }
    
    public int getSize(){
        return size;
    }
    
    public void setSize(int size){
        this.size = size;
    }
  
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Customer");
        sb.append("{id=").append(id);
        sb.append(", Name='").append(Name).append('\'');
        sb.append(", Email='").append(Email).append('\'');
        sb.append(", Phone='").append(Phone).append('\'');
        sb.append(", Address=").append(Address);
        sb.append('}');
        return sb.toString();
    }
    
}//End Class

