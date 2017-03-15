/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Nicolai
 */
@Entity
public class Phone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int number;
    private String description;
    
    @ManyToOne
    private InfoEntity infoEntity;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "entities.Phone[ id=" + id + " ]";
    }

    public int getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    public Phone(Long id, int number, String description) {
        this.id = id;
        this.number = number;
        this.description = description;
        
    }

    public Phone() {
    }
    
}
