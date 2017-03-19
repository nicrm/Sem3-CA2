/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import Interface.IFacade;
import static entities.Address_.city;
import entities.CityInfo;
import entities.InfoEntity;
import entities.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author Peter Henriksen
 */
public class PersonFacade implements IFacade {

    EntityManagerFactory emf;

    public PersonFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public PersonFacade() {

    }

    @Override
    public Person getPerson(int ID) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person p = em.find(Person.class, ID);
        em.getTransaction().commit();

        if (p != null) {
            em.close();
            return p;

        } else {
            return null;
        }

    }

    public Person addPerson(Person person) {

        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return person;
    }

    @Override
    public List<Person> getAllPersons() {
        EntityManager em = emf.createEntityManager();
        List<Person> people = null;
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT e FROM Person e");
            people = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            em.close();
        }
        return people;

    }

    public List<Person> getPersonsFromZipcode(int zipcode) {
        EntityManager em = emf.createEntityManager();
        List<Person> people = null;
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT e FROM Person e WHERE e.address.city = :city").setParameter("city", city);
            people = query.getResultList();
            em.getTransaction().commit();

        } finally {
            em.close();
        }
        try {
            em.getTransaction().begin();
            CityInfo city = getCityInfo(zipcode);
            people = em.createQuery("SELECT p FROM Person p WHERE p.address.city = :city", Person.class).setParameter("city", city).getResultList();
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        return people;

    }

    @Override
    public CityInfo getCityInfo(int Zipcode) {
        EntityManager em = emf.createEntityManager();
        CityInfo cityinfo = null;
        try {
            cityinfo = em.createQuery("SELECT c FROM CityInfo c WHERE c.Zipcode = :Zipcode", CityInfo.class).setParameter("Zipcode", Zipcode).getResultList().get(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return cityinfo;
    }
    
    @Override
    public boolean deletePerson(long id){
    EntityManager em = emf.createEntityManager();
    Person p = null;
        try {
            em.getTransaction().begin();
            p = em.find(Person.class, id);
            em.remove(p);
            em.getTransaction().commit();
        } finally {
        em.close();
        }
        return true;
    }
    
    @Override
    public Person editPerson(Person person, long id){
    EntityManager em = emf.createEntityManager();
    Person p = null;
        try {
            em.getTransaction().begin();
            person.setId(id);
            em.merge(person);
            em.getTransaction().commit();
            p = em.find(Person.class, id);
        } finally {
        em.close();
        }
        return p;
    }
    
    
    @Override
    public InfoEntity addInfoEntity(InfoEntity infoEntity) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(infoEntity);
            em.getTransaction().commit();

            return infoEntity;
        } finally {
            em.close();
        }
    }
    @Override
    public InfoEntity editInfoEntity(InfoEntity infoEntity) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            InfoEntity entity = em.find(infoEntity.getClass(), infoEntity.getId());
            
            InfoEntity e = em.merge(infoEntity);
            em.getTransaction().commit();
            
            return e;
        } finally {
            em.close();
        }
    }

    @Override
    public InfoEntity deleteInfoEntity(int infoEntityId) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            InfoEntity entity = em.find(InfoEntity.class, infoEntityId);
            
            em.remove(entity);
            em.getTransaction().commit();
            
            return entity;
        } finally {
            em.close();
        }
    }

}

    