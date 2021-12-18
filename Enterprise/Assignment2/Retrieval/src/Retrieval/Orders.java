//Author: Pierce Kinghorn 12091381
//Last Edited: 19/08/2020
package Retrieval;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries ({
    @NamedQuery(name = "findAllOrders", query = "SELECT o FROM Orders o"),
    @NamedQuery(name = "findAllOrdersID", query = "SELECT o FROM Orders o where o.id= :id"),
    @NamedQuery(name = "deleteOrder", query = "DELETE FROM Orders o where o.id= :id")
})
public class Orders implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    protected Date timeCreated = new Date();
    
    //Relationships
    @ManyToOne
    @JoinColumn(name="VEHICLEID", referencedColumnName = "ID")
    private Vehicle vehicle;
    
    @ManyToOne(cascade={
        CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="CUSTOMERID", referencedColumnName = "ID")
    private Customer customer;


    public Orders() {
    }

    //Constructor
    public Orders(Vehicle vehicle, Customer customer) {
        this.customer = customer;
        this.vehicle = vehicle;
    }

    //Get set methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    @Override
     public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Order");
        sb.append("{id=").append(id);
        sb.append(", customer=").append(customer);
        sb.append(", vehicle=").append(vehicle);
        sb.append('}');
        return sb.toString();
    }
}
