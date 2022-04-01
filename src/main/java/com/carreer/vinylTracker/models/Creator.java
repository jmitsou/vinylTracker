package com.carreer.vinylTracker.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Creator {

    @Id
    @GeneratedValue
    private Long id;
    private String Name;
    private String email;
    private String favBrand;

    public Creator() {
    }

    public Creator(String name, String email, String favBrand) {
        Name = name;
        this.email = email;
        this.favBrand = favBrand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFavBrand() {
        return favBrand;
    }

    public void setFavBrand(String favBrand) {
        this.favBrand = favBrand;
    }
}
