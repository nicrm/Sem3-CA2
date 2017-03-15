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

/**
 *
 * @author Nicolai
 */
@Entity
public class Company extends InfoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private String description;
    private int cvr;
    private int NumEmployees;
    private int MarketValue;

    
    public Company() {
    }

    public Company(String name, String description, int cvr, int NumEmployees, int MarketValue, String email) {
        super(email);
        this.name = name;
        this.description = description;
        this.cvr = cvr;
        this.NumEmployees = NumEmployees;
        this.MarketValue = MarketValue;
    }

    public Company(String name, String description, int cvr, int NumEmployees, int MarketValue) {
        this.name = name;
        this.description = description;
        this.cvr = cvr;
        this.NumEmployees = NumEmployees;
        this.MarketValue = MarketValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCvr() {
        return cvr;
    }

    public void setCvr(int cvr) {
        this.cvr = cvr;
    }

    public int getNumEmployees() {
        return NumEmployees;
    }

    public void setNumEmployees(int NumEmployees) {
        this.NumEmployees = NumEmployees;
    }

    public int getMarketValue() {
        return MarketValue;
    }

    public void setMarketValue(int MarketValue) {
        this.MarketValue = MarketValue;
    }
    
}
