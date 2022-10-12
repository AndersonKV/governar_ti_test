package com.demo.testgovernarti.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "constructors")
public class Constructors {
    @Id
    private Long id;
    private String constructor_ref;
    private String name;
    private String nationality;
    private String url;

    public Constructors() {
    }

    public Constructors(Long id, String constructor_ref, String name, String nationality, String url) {
        this.id = id;
        this.constructor_ref = constructor_ref;
        this.name = name;
        this.nationality = nationality;
        this.url = url;
    }

    @Override
    public String toString() {
        return "constructors [id=" + this.getId() + ", constructor_ref=" + this.getConstructor_ref() + ", name=" + this.getName() + ", nationality=" + this.getNationality() + ", url=" + this.getUrl() + "]";
    }

}
