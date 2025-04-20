package com.tele.tareaclase4.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "regions")
public class Region {

    @Id
    @Column(name = "region_id")
    private Integer id;

    @Column(name = "region_name")
    private String name;
}
