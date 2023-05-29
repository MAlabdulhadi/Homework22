package com.example.schoolmanagementsoftware.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity

public class Address {
    //area , street , buildingNumber ( Add all required validation )
    @Id
    private Integer id;
    @NotEmpty(message = "street must be not empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String street;
    @NotEmpty(message = "area must be not empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String area;
    @NotNull(message = "building number must be not empty")
    @Column(columnDefinition = "int default 0")
    private Integer buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;


}
