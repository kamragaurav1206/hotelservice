package com.yash.hotelservice.controller;

import com.yash.hotelservice.domain.Hotels;
import com.yash.hotelservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotels> addHotel(@RequestBody @Valid Hotels hotels){
        Hotels hotels1 = hotelService.addHotel(hotels);
        return new ResponseEntity(hotels1, HttpStatus.CREATED);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotels> getHotelById(@PathVariable String hotelId){
        return ResponseEntity.ok(hotelService.getHotelsById(hotelId));
    }

    @GetMapping
    public ResponseEntity<List<Hotels>> getAllHotels(){
        return ResponseEntity.ok(hotelService.getHotelsList());
    }
}
