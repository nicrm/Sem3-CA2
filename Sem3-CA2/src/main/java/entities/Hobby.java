/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author Nicolai
 */
@Entity
public class Hobby implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @ManyToMany
    private List<Person> persons;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public Hobby(Long id, String name, String description, List<Person> persons) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.persons = persons;
    }
    
    public Hobby(String name, String description, List<Person> persons) {
        this.name = name;
        this.description = description;
        this.persons = persons;
    }
    
    public Hobby(){
        
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hobby)) {
            return false;
        }
        Hobby other = (Hobby) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.hobby[ id=" + id + " ]";
    }
    
}
