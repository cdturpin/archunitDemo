package com.keyholesoftware.archunit.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product", schema = "northwind")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;
    
    @Column(name = "breweryId", nullable = true, unique = true, updatable = false)
    private int breweryId;
    
    @Column(name = "styleId", nullable = true, unique = true, updatable = false)
    private int styleId;
    
    @Column(name = "name", nullable = false, unique = false, updatable = true)
    private String name;
    
    @Column(name = "abv", nullable = true, unique = false, updatable = true)
    private int abv;

    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

	public int getBreweryId() {
		return breweryId;
	}

	public int getStyleId() {
		return styleId;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getAbv() {
		return abv;
	}
	
	public void setAbv(int abv) {
		this.abv = abv;
	}
	
	@Override
	public String toString() {
		return "Crop [id=" + id + ", breweryId=" + breweryId + ", styleId=" + styleId + ", name=" + name + ", abv="
				+ abv + "]";
	}
}