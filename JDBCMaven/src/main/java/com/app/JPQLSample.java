package com.app;

import com.app.model.Device;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by denys on 6/27/2017.
 */
public class JPQLSample {

    public static void main(String[] args) {
        createDevice(100);
        List<Device> devices=readAllDevices();
        for(Device d: devices){
            System.out.println(d);
        }
        System.out.println("----------------");
        long count = readAllDevicesCount();
        System.out.println(count);

        System.out.println("----------------");
        long priceSum = readSumOfPriceOfAllDevices();
        System.out.println(priceSum);
        System.out.println("----------------");
        devices=readAllDevicesByModel("Model5");
        for(Device d: devices){
            System.out.println(d);
        }
        System.out.println("-------Pagination---------");
        //show 20 items on1 page
        /*
        1-20
        20-40
        */
        //limit
        //rownum
        devices=readAllDevicesForPaging(4, 120);
        for(Device d: devices){
            System.out.println(d);
        }
    }

    private static List<Device> readAllDevicesForPaging(int pageNumber, int amountOfRecords){
        EntityManagerFactory factory =  Persistence.createEntityManagerFactory("unit1");
        EntityManager em=factory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Device> typedQuery = em.createNamedQuery("Device.findAll", Device.class);
        typedQuery.setFirstResult(pageNumber*amountOfRecords);
        typedQuery.setMaxResults(amountOfRecords);
        List<Device> devices=typedQuery.getResultList();

        em.getTransaction().commit();
        return devices;
    }

    private static List<Device> readAllDevicesByModel(String model){
        EntityManagerFactory factory =  Persistence.createEntityManagerFactory("unit1");
        EntityManager em=factory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Device> typedQuery = em.createNamedQuery("Device.findByModel", Device.class);
        typedQuery.setParameter("model", model);
        List<Device> devices=typedQuery.getResultList();
        em.getTransaction().commit();
        return devices;
    }


    private static long readSumOfPriceOfAllDevices(){
        EntityManagerFactory factory =  Persistence.createEntityManagerFactory("unit1");
        EntityManager em=factory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Long> typedQuery = em.createNamedQuery("Device.totalSum", Long.class);
        Long count=typedQuery.getSingleResult();
        em.getTransaction().commit();
        return count;
    }

    private static long readAllDevicesCount(){
        EntityManagerFactory factory =  Persistence.createEntityManagerFactory("unit1");
        EntityManager em=factory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Long> typedQuery = em.createNamedQuery("Device.findCountAll", Long.class);
        Long count=typedQuery.getSingleResult();
        em.getTransaction().commit();
        return count;
    }

    private static List<Device> readAllDevices(){
        EntityManagerFactory factory =  Persistence.createEntityManagerFactory("unit1");
        EntityManager em=factory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Device> typedQuery = em.createNamedQuery("Device.findAll", Device.class);
        List<Device> devices=typedQuery.getResultList();
        em.getTransaction().commit();
        return devices;
    }

    private static void createDevice(int n){
        EntityManagerFactory factory =  Persistence.createEntityManagerFactory("unit1");
        EntityManager em=factory.createEntityManager();
        em.getTransaction().begin();
        for(int i=0;i<n;i++){
            Device d = new Device();
            d.setManufacture("Manufacture"+i);
            d.setPrice(i+10);
            d.setModel("Model"+i);
            em.persist(d);
        }
        em.getTransaction().commit();
    }
}
