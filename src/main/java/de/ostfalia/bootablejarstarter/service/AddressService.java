package de.ostfalia.bootablejarstarter.service;

import de.ostfalia.bootablejarstarter.entity.Address;
import de.ostfalia.bootablejarstarter.entity.City;
import de.ostfalia.bootablejarstarter.entity.Country;
import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateless
public class AddressService {
    @PersistenceContext(unitName = "customer")
    EntityManager em;
    @Inject CustomerService customerService;

    private static final int PAGE_SIZE = 10;
    public void save(Address address){
        em.persist(address);
    }
    //TODO es fehlt noch die post api ich mache zuerst andere APi und danach mach ich den das
public void saveAddressDAO(List<Map<Object,String>> addressData){
    for (Map<Object, String> data : addressData) {
        Address address = new Address();
        address.setAddress(data.get("address"));
        address.setAddress2(data.get("address2"));
        // 如果您只想存储部分数据，可以按需获取
        //address.setCity(data.get("city"));
        //address.setCountry(data.get("country"));
        // 如果您有其他需要存储的字段，也可以在这里设置

        // 使用JPA的EntityManager将实体保存到数据库
        em.persist(address);
    }
}
    public void update(Address address){
        em.merge(address);
    }

    public Address findeAddressById(Integer id){
        return em.find(Address.class,id);
    }
public City findCityById(Integer id){
        return em.find(City.class,id);
}
public Country findCountryById(Integer id){
        return em.find(Country.class,id);
}
public List<Map<String,Object>> getAddressDataById(Integer id) {
    Address address = em.find(Address.class, id);
//    if (address ==null){
//        return Response.status(404).build();
//    }
    List<Map<String, Object>> addressData = new ArrayList<>();

        Map<String, Object> addressMap = new HashMap<>();
        addressMap.put("address", address.getAddress());
        addressMap.put("city", address.getCity().getCity());
        addressMap.put("country", address.getCity().getCountry().getCountry());
        addressMap.put("district", address.getDistrict());
        addressMap.put("id", address.getAddressId());
        addressMap.put("phone", address.getPhone());
        addressMap.put("postalCode", address.getPostalCode());

        addressMap.put("address2", address.getAddress2());
        addressData.add(addressMap);
    return addressData;
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
        query.setMaxResults(PAGE_SIZE);//hier verstehe ich nicht max soll 100
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

            addressMap.put("address2", address.getAddress2());
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
    public Long getCountOfAddress(){

        TypedQuery<Long> query= em.createQuery("select count (a) from Address a",Long.class);
         long count =query.getSingleResult();
         return count;
    }

    public Response deleteAddressById(Integer id){
        Address address = em.find(Address.class,id);
        if (address == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        //TODO: dann loeschen
        Query query = em.createQuery("SELECT COUNT(c) FROM Customer c WHERE c.address = :address");
        query.setParameter("address", address);
        Long count = (Long) query.getSingleResult();
        if (count > 0) {
            return Response.status(403).build();
        }
        this.delete(address);
        return Response.noContent().entity("Address deleted").build();

    }


}