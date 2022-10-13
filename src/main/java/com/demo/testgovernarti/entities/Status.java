package com.demo.testgovernarti.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "status")
@Getter
@Setter
public class Status {
    @Id
    private Long id;
    private String status;

    public Status( ) {

    }
    public Status(Long id, String status) {
        this.id = id;
        this.status = status;
    }
}
