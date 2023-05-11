package org.example.appspringjpalesson.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.CustomLog;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false) // ctrl + probel
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false,unique = true) // notnul bo`lsin va unikey bo`sin
    private String phoneNumber;
}
