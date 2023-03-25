package com.yash.hotelservice.service;

import com.yash.hotelservice.domain.Hotels;
import com.yash.hotelservice.exception.ResourceNotFoundException;
import com.yash.hotelservice.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository repository;

    @Override
    public Hotels addHotel(Hotels hotel) {
        hotel.setHotelId(UUID.randomUUID().toString());
        return repository.save(hotel);
    }

    @Override
    public Hotels getHotelsById(String hotelId) {
        return repository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("Hotel not found :" + hotelId));
    }

    @Override
    public List<Hotels> getHotelsList() {
        return repository.findAll();
    }
}
