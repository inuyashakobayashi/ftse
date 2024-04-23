package de.ostfalia.bootablejarstarter.service;

import de.ostfalia.bootablejarstarter.entity.Address;
import de.ostfalia.bootablejarstarter.entity.Customer;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class CustomerService {
    @PersistenceContext
    EntityManager em;
    //@Inject AddressService addressService;
    public Customer findCustomerById(Integer id){
        return em.find(Customer.class,id);
    }

//    public Long checkIfRelateWithAddress(Integer id){
//        Address address = addressService.findeAddressById(id);
//        Query query = em.createQuery("select count (c) from Customer c where c.address=:address");
//        query.setParameter("address",address);
//        Long count = (Long) query.getSingleResult();
//        return count;
//    }
}
