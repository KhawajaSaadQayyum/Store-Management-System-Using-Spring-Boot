package com.StoreManagement.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "StoreManagement")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;
    @Column(name ="name")
    private String name;
    @Column(name ="email")
    private String email;
    @Column(name ="contactNumber")
    private String contactNumber;
    @Column(name ="Amount")
    private String totalAmount;

}
