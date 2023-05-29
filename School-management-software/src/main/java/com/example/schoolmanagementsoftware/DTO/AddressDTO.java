package com.example.schoolmanagementsoftware.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {
    private Integer teacher_id;
    private String street;
    private String area;
    private Integer buildingNumber;
}
