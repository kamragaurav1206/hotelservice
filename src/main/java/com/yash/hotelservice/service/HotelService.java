package com.yash.hotelservice.service;

import com.yash.hotelservice.domain.Hotels;

import java.util.List;

public interface HotelService {
    public Hotels addHotel(Hotels hotel);
    public Hotels getHotelsById(String hotelId);
    public List<Hotels> getHotelsList();
}
