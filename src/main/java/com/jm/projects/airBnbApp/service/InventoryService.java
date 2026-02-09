package com.jm.projects.airBnbApp.service;

import com.jm.projects.airBnbApp.entity.Room;

import java.time.LocalDate;

public interface InventoryService {

    void initializeRoomForAYear(Room room);

    void deleteFutureInventories(Room room);


}
