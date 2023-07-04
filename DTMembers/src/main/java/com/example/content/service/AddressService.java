package com.example.content.service;

import com.example.content.dto.AddressDTO;
import com.example.content.entity.Address;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface AddressService {

     List<AddressDTO> getAll();

    Optional<AddressDTO> getAddress( Integer id);

     AddressDTO add(AddressDTO addressDTO);
   List<AddressDTO> addAll(   List<AddressDTO> addressDTO);


    void delete(Integer id);

    AddressDTO update(  AddressDTO addressDTO);
}


