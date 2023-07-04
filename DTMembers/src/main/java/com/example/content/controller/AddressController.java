package com.example.content.controller;

import com.example.content.dto.AddressDTO;
import com.example.content.entity.Address;
import com.example.content.repository.AddressRepository;
import com.example.content.service.AddressService;
import com.example.content.serviceImp.AddressServiceImp;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("address")
public class AddressController {


   AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/all")
    public List<AddressDTO> getAll(){

        return addressService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<AddressDTO> getAddress(@PathVariable("id") Integer id){

        return addressService.getAddress(id);
    }

    @PostMapping
    public AddressDTO add(@RequestBody AddressDTO addressDTo){//should we add address alone?
        return addressService.add(addressDTo);
    }
    @PostMapping("/addall")
    public List<AddressDTO> addAll(  @RequestBody List<AddressDTO> address){//should we add address alone?
        return addressService.addAll(address);
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id")Integer id){
        addressService.delete(id);
    }

    @PutMapping("/update/")  @Transactional
    public AddressDTO update( @RequestBody AddressDTO addressDTO){

       return addressService.update(addressDTO);
    }
}
