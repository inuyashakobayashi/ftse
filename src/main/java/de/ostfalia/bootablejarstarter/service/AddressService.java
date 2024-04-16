package de.ostfalia.bootablejarstarter.service;

import de.ostfalia.bootablejarstarter.entity.Address;
import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<Map<String,Object>> getAddressListWithPage(Integer page){

        TypedQuery<Address> query = em.createQuery("SELECT a from Address a", Address.class);
        query.setFirstResult((page-1)*PAGE_SIZE);
        query.setMaxResults(PAGE_SIZE);
//    return query.getResultList();
        List<Address> results = query.getResultList();
        List<Map<String, Object>> simplifiedAddresses = new ArrayList<>();
        for (Address address : results) {
            Map<String, Object> addressMap = new HashMap<>();
            addressMap.put("address", address.getAddress());
            addressMap.put("city", address.getCity().getCity());
            addressMap.put("country", address.getCity().getCountry().getCountry());
            addressMap.put("district", address.getDistrict());
            addressMap.put("id", address.getAddressId());
            addressMap.put("phone", address.getPhone());
            addressMap.put("postalCode", address.getPostalCode());
            simplifiedAddresses.add(addressMap);



        }

        return simplifiedAddresses;
    }
    public int getPageNumber(){
        TypedQuery<Long> query = em.createQuery("select count (a) from Address a", Long.class);
        long totalRecords = query.getSingleResult();

        // 计算总页数，向上取整
        int totalPages = (int) Math.ceil(totalRecords / (double) PAGE_SIZE);
        return totalPages;

    }

}