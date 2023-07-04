package com.example.content.serviceImp;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Component

public class Converter {

    private final ModelMapper modelMapper;


    public Converter() {
        log.info("inside converter constructos");
        modelMapper = new  ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        log.info(" exit converter constructor");
    }

    public <S,T> List<T> toList(List<S> source, Class<T> targetClass){
        return source
                .stream()
                .map(element->modelMapper.map(element,targetClass))
                .collect(Collectors.toList());
    }

    public <S,T> T convert(S source, Class<T> targetClass){
        return modelMapper.map(source,targetClass);
    }


    public <S,T> void update(S source, T target){
        modelMapper.map(source,target);
    }
}
