package com.example.schoolmanagementsoftware.Controller;


import com.example.schoolmanagementsoftware.DTO.AddressDTO;
import com.example.schoolmanagementsoftware.Repository.AddressRepository;
import com.example.schoolmanagementsoftware.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/add-address")
    public ResponseEntity addAddressToTeacher(@Valid @RequestBody AddressDTO dto) {
        addressService.addAddressToTeacher(dto);
        return ResponseEntity.status(200).body("done add address to teacher");
    }

    @PutMapping("/update-address/{id}")
    public ResponseEntity upadteAddressForUser(@PathVariable Integer id, @Valid @RequestBody AddressDTO dto) {

        addressService.updateAddressForTeacher(id, dto);
        return ResponseEntity.status(200).body("done update address");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddressForTeacher(@PathVariable Integer id) {
        addressService.deleteAddressForTeacher(id);
        return ResponseEntity.status(200).body("done delete");
    }

}
