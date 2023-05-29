package com.example.schoolmanagementsoftware.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Teacher {

    //id , name , age , email , salary ( Add all required validation )
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name must be not empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;
    @NotNull(message = "age must be not empty")
    @Column(columnDefinition = "int default 0")
    private Integer age;
    @NotEmpty(message = "email must be not empty")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;
    @PositiveOrZero(message = "salary must be 0 or more")
    @Column(columnDefinition = "decimal default 0")
    private double salary;


    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;


    @OneToMany(cascade = CascadeType.DETACH, mappedBy = "teacher")
    private Set<Course> course;


}
