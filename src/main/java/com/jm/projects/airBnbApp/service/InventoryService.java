package com.jm.projects.airBnbApp.service;

import com.jm.projects.airBnbApp.dto.HotelDto;
import com.jm.projects.airBnbApp.dto.HotelSearchRequest;
import com.jm.projects.airBnbApp.entity.Room;
import org.springframework.data.domain.Page;

public interface InventoryService {

    void initializeRoomForAYear(Room room);

    void deleteAllInventories(Room room);


    Page<HotelDto> searchHotels(HotelSearchRequest hotelSearchRequest);
}
