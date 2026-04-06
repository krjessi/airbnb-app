package com.jm.projects.airBnbApp.service;

import com.jm.projects.airBnbApp.dto.HotelDto;
import com.jm.projects.airBnbApp.dto.HotelInfoDto;
import com.jm.projects.airBnbApp.entity.Hotel;

public interface HotelService {
    HotelDto createNewHotel(HotelDto hotelDto);

    HotelDto getHotelById(Long id);

    HotelDto updateHotelById(Long id, HotelDto hotelDto);

    void deleteHotelById(Long id);

    void activateHotel(Long hotelId);

    HotelInfoDto getHotelInfoById(Long hotelId);
}
