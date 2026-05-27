package com.jm.projects.airBnbApp.service;

import com.jm.projects.airBnbApp.dto.HotelPriceResponseDto;
import com.jm.projects.airBnbApp.dto.HotelSearchRequest;
import com.jm.projects.airBnbApp.dto.InventoryDto;
import com.jm.projects.airBnbApp.dto.UpdateInventoryRequestDto;
import com.jm.projects.airBnbApp.entity.Room;
import org.springframework.data.domain.Page;

import java.util.List;

public interface InventoryService {

    void initializeRoomForAYear(Room room);

    void deleteAllInventories(Room room);

    Page<HotelPriceResponseDto> searchHotels(HotelSearchRequest hotelSearchRequest);

    List<InventoryDto> getAllInventoryByRoom(Long roomId);

    void updateInventory(Long roomId, UpdateInventoryRequestDto updateInventoryRequestDto);
}
