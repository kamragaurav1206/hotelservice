package com.yash.hotelservice.repositories;

import com.yash.hotelservice.domain.Hotels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotels,String> {
}
