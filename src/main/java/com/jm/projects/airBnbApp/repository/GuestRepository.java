package com.jm.projects.airBnbApp.repository;

import com.jm.projects.airBnbApp.entity.Guest;
import com.jm.projects.airBnbApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    List<Guest> findByUser(User user);
}