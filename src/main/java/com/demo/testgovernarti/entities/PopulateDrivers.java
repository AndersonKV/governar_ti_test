package com.demo.testgovernarti.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "populate_drivers")
public class PopulateDrivers {
    @Id
    private Long id;
    private Long driver_id;
    private String name;
    private String family_name;
    private String date;
    private String[] constructors;
}
