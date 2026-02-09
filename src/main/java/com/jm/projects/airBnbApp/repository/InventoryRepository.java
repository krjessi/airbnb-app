package com.jm.projects.airBnbApp.repository;

import com.jm.projects.airBnbApp.entity.Inventory;
import com.jm.projects.airBnbApp.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    void deleteByDateAfterAndRoom(LocalDate date, Room room);
}
