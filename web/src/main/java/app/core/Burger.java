package app.core;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Burger {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Boolean isVegetarian;
    private Integer numberOfPatties;
    private Integer unitPriceInHuf;


    public Burger() {
    }

    public Burger(String name, Boolean isVegetarian, Integer numberOfPatties, Integer unitPriceInHuf) {
        this.name = name;
        this.isVegetarian = isVegetarian;
        this.numberOfPatties = numberOfPatties;
        this.unitPriceInHuf = unitPriceInHuf;
    }

    public Burger(Long id, String name, Boolean isVegetarian, Integer numberOfPatties, Integer unitPriceInHuf) {
        this.id = id;
        this.name = name;
        this.isVegetarian = isVegetarian;
        this.numberOfPatties = numberOfPatties;
        this.unitPriceInHuf = unitPriceInHuf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(Boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    public Integer getNumberOfPatties() {
        return numberOfPatties;
    }

    public void setNumberOfPatties(Integer numberOfPatties) {
        this.numberOfPatties = numberOfPatties;
    }

    public Integer getUnitPriceInHuf() {
        return unitPriceInHuf;
    }

    public void setUnitPriceInHuf(Integer unitPriceInHuf) {
        this.unitPriceInHuf = unitPriceInHuf;
    }

}
