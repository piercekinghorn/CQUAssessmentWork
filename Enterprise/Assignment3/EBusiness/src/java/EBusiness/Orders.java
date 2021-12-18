//Author:Pierce Kinghorn 12091381
//Date: 7/10/2020
package EBusiness;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "orders")
@NamedQueries ({
    @NamedQuery(name = "findAllOrders", query = "SELECT o FROM Orders o"),
    @NamedQuery(name = "findOrdersByID", query = "SELECT o FROM Orders o Where o.id= :id"),
    @NamedQuery(name = "findOrdersByCustomer", query = "SELECT o FROM Orders o Where o.customer.id = :id"),
    @NamedQuery(name = "deleteOrder", query = "DELETE FROM Orders o Where o.id= :id"), 
    @NamedQuery(name = "setOrders", query = "UPDATE Customer c Set c.size = :size Where c.id= :id"),
    @NamedQuery(name = "updateVehicleStock", query = "UPDATE Vehicle v SET v.CarNo = :stock Where v.id = :id")
})
public class Orders implements Serializable {
         
    //Order Attributes
    @Id
    @GeneratedValue
    private Long id;
       
    @Column(nullable = false)
    protected Integer quantity = 1;
    
    @Column(nullable = false)
    protected Integer totalprice = 1;
    
    @Column(nullable = false)
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

    //Constructore
    public Orders() {
    }

    //Get set methods
    public Long getId() {
        return this.id;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }      

    public Integer getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Integer totalprice) {
        this.totalprice = totalprice;
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
}//End Class