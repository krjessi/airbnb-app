package com.jm.projects.airBnbApp.repository;

import com.jm.projects.airBnbApp.entity.Hotel;
import com.jm.projects.airBnbApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByOwner(User user);
}
