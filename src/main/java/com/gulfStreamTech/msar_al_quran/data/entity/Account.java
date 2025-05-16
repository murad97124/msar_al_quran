package com.gulfStreamTech.msar_al_quran.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ACCOUNTS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FULL_NAME")
    private String fullName;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "MOBILE_NUMBER")
    private String mobileNumber;
    @Column(name = "BIRTHDATE")
    private String birthdate;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "PASSWORD")
    private String password;
}
