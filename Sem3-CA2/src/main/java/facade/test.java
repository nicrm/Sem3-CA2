/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author JonasSchack
 */
public class test {

    public static void main(String[] args) {
       PersonFacade fc = new PersonFacade(Persistence.createEntityManagerFactory("PU"));
       
       
       
    }
}
