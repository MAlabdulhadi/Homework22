package com.example.schoolmanagementsoftware.Service;

import com.example.schoolmanagementsoftware.ApiException.ApiException;
import com.example.schoolmanagementsoftware.DTO.AddressDTO;
import com.example.schoolmanagementsoftware.Model.Address;
import com.example.schoolmanagementsoftware.Model.Teacher;
import com.example.schoolmanagementsoftware.Repository.AddressRepository;
import com.example.schoolmanagementsoftware.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public void addAddressToTeacher(AddressDTO dto) {
        Teacher teacher = teacherRepository.findTeacherById(dto.getTeacher_id());
        if (teacher == null) {
            throw new ApiException("do not have teacher by this id");
        }
        Address address = new Address(null, dto.getStreet(), dto.getArea(), dto.getBuildingNumber(), teacher);
        addressRepository.save(address);
    }

    public void updateAddressForTeacher(Integer id, AddressDTO dto) {
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher == null) {
            throw new ApiException("do not have teacher by this id");
        }
        Address address = teacher.getAddress();
        if (address == null) {
            throw new ApiException("this user do not have address");
        }
        address.setArea(dto.getArea());
        address.setStreet(dto.getStreet());
        address.setBuildingNumber(dto.getBuildingNumber());
        addressRepository.save(address);
    }

    public void deleteAddressForTeacher(Integer id) {
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher == null) {
            throw new ApiException("this user do not have address");
        }
        Address address = addressRepository.findAddressById(teacher.getId());
        if (address == null) {
            throw new ApiException("this user do not have address");
        }
        addressRepository.delete(address);

    }


}
