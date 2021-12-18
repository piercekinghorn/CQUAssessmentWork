//Author: Pierce Kinghorn 12091381
//Last Edited: 19/08/2020
package Retrieval;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

//Queries
@Entity
@NamedQueries ({
    @NamedQuery(name = "findAllCustomers", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "findCustomerByName", query = "SELECT c FROM Customer c WHERE c.Name= :Name")
})
public class Customer implements Serializable {

    //Customer Values
    @Id
    @GeneratedValue
    private Long id;
    private String Name;
    private String Email;
    private String Phone;
    private String Address;
    @OneToMany
    private List<Orders> orders=new ArrayList<Orders>();
    
    public Customer(){
        
    }
    //Constructor
    public Customer(String Name, String Email, String Phone, String Address){
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
}
