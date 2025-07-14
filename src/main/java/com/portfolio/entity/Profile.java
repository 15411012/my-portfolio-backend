package com.portfolio.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "profileId")
@Data
@Entity
@Table(name = "profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;

    private String name;
    private String gender;
    private String currentCity;
    private String occupation;
    private String address;
    private String dob;
    private String contactNo;
    private String emailId;
    private String linkedln;

    @OneToOne
    @JoinColumn(name = "spouse_id")
    private Profile spouse;

    @JsonManagedReference
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Profile> children = new ArrayList<>();

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Profile parent;
}
