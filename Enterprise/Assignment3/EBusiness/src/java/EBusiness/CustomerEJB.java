//Author:Pierce Kinghorn 12091381
//Date: 7/10/2020
package EBusiness;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class CustomerEJB {

    // Attributes             
    @PersistenceContext(unitName = "EBusinessPU")
    private EntityManager em;

    // Public Methods           
    public List<Customer> findCustomers() {
        TypedQuery<Customer> query = em.createNamedQuery("findAllCustomers", Customer.class);
        return query.getResultList();
    }
    
    public List<Customer> findCustomerByName(String name) {
        TypedQuery<Customer> query = em.createNamedQuery("findCustomerByName", Customer.class);
        query.setParameter("Name",name);
        return query.getResultList();
    }
    
    public Customer selectCustomer(Long id){
        TypedQuery<Customer> query = em.createNamedQuery("selectCustomer", Customer.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    public Customer createCustomer(Customer customer) {
        em.persist(customer);
        return customer;
    }
    
    public List<Orders> findOrdersByCustomer(Long id) {
        TypedQuery<Orders> query = em.createNamedQuery("findOrdersByCustomer", Orders.class);
        query.setParameter("id",id);
        return query.getResultList();
    }
}//End Class