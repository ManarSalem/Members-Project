package com.example.content.serviceImp;

import com.example.content.dto.AddressDTO;
import com.example.content.entity.Address;
import com.example.content.repository.AddressRepository;
import com.example.content.service.AddressService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Service
public class AddressServiceImp implements AddressService {


    AddressRepository addressRepository;

      Converter converter;

      @Autowired
    public AddressServiceImp(AddressRepository addressRepository, Converter converter) {
        this.addressRepository = addressRepository;
        this.converter = converter;
    }


    public List<AddressDTO> getAll(){

        return converter.toList(addressRepository.findAll(), AddressDTO.class);
    }


    public Optional<AddressDTO> getAddress( Integer id){

        return Optional.ofNullable(converter
                .convert(addressRepository.findById(id), AddressDTO.class));
    }


    public AddressDTO add(AddressDTO addressDTO){//should we add address alone?
         Address address= converter.convert(addressDTO,Address.class);

        return converter.convert(addressRepository.save(address), AddressDTO.class) ;
    }

    public List<AddressDTO> addAll(   List<AddressDTO> addressDTO){//should we add address alone?
          List<Address> addressEntity= converter.toList(addressDTO, Address.class);

        return converter.toList(addressRepository.saveAll(addressEntity), AddressDTO.class);
    }



    public void delete(Integer id){
        addressRepository.deleteById(id);
    }

    @Transactional
    public AddressDTO update(AddressDTO addressDTO){

         Address addressEntity= converter.convert(addressDTO, Address.class);
        Optional<Address> founded= addressRepository.findById(addressEntity.getId());
        if(founded.isPresent()){
            founded.get().setCity(addressEntity.getCity());
            return converter.convert(founded.get(), AddressDTO.class);
        }
        return null;
    }
}
