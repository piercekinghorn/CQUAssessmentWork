//Author: Pierce Kinghorn 12091381
//Date: 6/10/2020
package EBusiness;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class OrdersEJB {

    // Attributes             
    @PersistenceContext(unitName = "EBusinessPU")
    private EntityManager em;

    // Public Methods           
    public List<Orders> findOrders() {
        TypedQuery<Orders> query = em.createNamedQuery("findAllOrders", Orders.class);
        return query.getResultList();
    }
    
    public List<Orders> findOrdersById(Long id) {
        TypedQuery<Orders> query = em.createNamedQuery("findOrdersByID", Orders.class);
        query.setParameter("id",id);
        return query.getResultList();
    }
           
    public Customer selectCustomer(Long id){
        TypedQuery<Customer> query = em.createNamedQuery("selectCustomer", Customer.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }
    
    public Vehicle selectVehicle(String id){
        TypedQuery<Vehicle> query = em.createNamedQuery("findVehicleByRef", Vehicle.class);
        query.setParameter("ReferenceId",id);
        return query.getSingleResult();
    }

    public Orders createOrders(Orders orders) {
        em.persist(orders);
        return orders;
    }
    
    public void deleteOrder(Long id){
        //Retrieve Order
        TypedQuery<Orders> query = em.createNamedQuery("findOrdersByID", Orders.class);
        query.setParameter("id", id);
        Orders order = query.getSingleResult();
        
        //Set Variables
        Integer carNo = order.getVehicle().getCarNo();
        Integer quantity = order.getQuantity();
        Long carId = order.getVehicle().getId();
        Integer carUpdate = carNo + quantity;
        Long custId = order.getCustomer().getId();
        Integer custUpdate; 
           
        //Update Vehicle Stock
        TypedQuery<Orders> query2 = em.createNamedQuery("updateVehicleStock", Orders.class);
        query2.setParameter("stock", carUpdate);
        query2.setParameter("id", carId);
        query2.executeUpdate();
        
        //Retrieve and set Order Size
        TypedQuery<Customer> query3 = em.createNamedQuery("selectCustomerSize", Customer.class);
        query3.setParameter("id", custId);
        Customer customer = query3.getSingleResult();
        int size = customer.getSize();
        custUpdate = size - 1;
        
        //Update Order Size
        TypedQuery<Orders> query4 = em.createNamedQuery("setOrders", Orders.class);
        query4.setParameter("size", custUpdate);
        query4.setParameter("id", custId);
        query4.executeUpdate(); 
             
        //Delete Order Entry
        TypedQuery<Orders> query5 = em.createNamedQuery("deleteOrder", Orders.class);
        query5.setParameter("id", id);
        query5.executeUpdate();         
    }

    public void updateStock(Long id, Integer stock){
        //Retrieve Order
        TypedQuery<Orders> query = em.createNamedQuery("findOrdersByID", Orders.class);
        query.setParameter("id", id);
        Orders order = query.getSingleResult();
        
        //Set Variables
        Integer carNo = order.getVehicle().getCarNo();
        Integer update = carNo - stock;
        Long carId = order.getVehicle().getId();
        
        //Update Vehicle Stock
        TypedQuery<Orders> query2 = em.createNamedQuery("updateVehicleStock", Orders.class);
        query2.setParameter("stock", update);
        query2.setParameter("id", carId);
        query2.executeUpdate();
    }
    
    public void setOrders(int size, long id){
        TypedQuery<Orders> query = em.createNamedQuery("setOrders", Orders.class);
        query.setParameter("size", size);
        query.setParameter("id", id);
        query.executeUpdate();       
    }
    
    public List<Orders> findOrdersByCustomer(Long id) {
        TypedQuery<Orders> query = em.createNamedQuery("findOrdersByCustomer", Orders.class);
        query.setParameter("id",id);
        return query.getResultList();
    }
}