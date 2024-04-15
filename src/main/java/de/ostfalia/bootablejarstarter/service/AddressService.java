package de.ostfalia.bootablejarstarter.service;

import de.ostfalia.bootablejarstarter.entity.Address;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@Stateless
public class AddressService {
    @PersistenceContext
    EntityManager em;

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
}
