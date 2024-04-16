package de.ostfalia.bootablejarstarter.service;

import de.ostfalia.bootablejarstarter.entity.Address;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

@Stateless
public class AddressService {
    @PersistenceContext(unitName = "customer")
    EntityManager em;

    private static final int PAGE_SIZE = 10;
    public void save(Address address){
        em.persist(address);
    }

    public void update(Address address){
        em.merge(address);
    }

    public Address findeAddressById(Integer id){
        return em.find(Address.class,id);
    }

    public void delete(Address address){
        em.remove(address);
    }
    public List<Address> getAddressList(){
        TypedQuery<Address> query = em.createQuery("SELECT a from Address a", Address.class);
        return query.getResultList();
    }
public List<Address> getAddressListWithPage(Integer page){

    TypedQuery<Address> query = em.createQuery("SELECT a from Address a", Address.class);
    query.setFirstResult((page-1)*PAGE_SIZE);
    query.setMaxResults(PAGE_SIZE);
    return query.getResultList();
}

}
