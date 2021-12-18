//Author:Pierce Kinghorn 12091381
//Date: 7/10/2020
package EBusiness;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class VehicleEJB {

    // Attributes             
    @PersistenceContext(unitName = "EBusinessPU")
    private EntityManager em;

    //Public Methods   
    
    //Vehicle Methods
    public List<Vehicle> findVehicles() {
        TypedQuery<Vehicle> query = em.createNamedQuery("findAllVehicles", Vehicle.class);
        return query.getResultList();
    }
    
    public Vehicle selectVehicle(String id){
        TypedQuery<Vehicle> query = em.createNamedQuery("findVehicleByRef", Vehicle.class);
        query.setParameter("ReferenceId",id);
        return query.getSingleResult();
    }    
    
    //Used Methods
    public Used createUsed(Used usedVehicle) {
        em.persist(usedVehicle);
        return usedVehicle;
    }
    
    public List<Used> findUsed() {
        TypedQuery<Used> query = em.createNamedQuery("findAllUsed", Used.class);
        return query.getResultList();
    }
    
    public List<Used> findUsedByRef(String ref) {
        TypedQuery<Used> query = em.createNamedQuery("findUsedByRef", Used.class);
        query.setParameter("ReferenceId",ref);
        return query.getResultList();
    }  
    
    //New Methods
    public New createNew(New newVehicle) {
        em.persist(newVehicle);
        return newVehicle;
    }
    
    public List<New> findNew() {
        TypedQuery<New> query = em.createNamedQuery("findAllNew", New.class);
        return query.getResultList();
    }
    
    public List<New> findNewByRef(String ref) {
        TypedQuery<New> query = em.createNamedQuery("findNewByRef", New.class);
        query.setParameter("ReferenceId",ref);
        return query.getResultList();
    }  
}//End Class