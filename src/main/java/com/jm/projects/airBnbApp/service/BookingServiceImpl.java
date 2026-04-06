package com.jm.projects.airBnbApp.service;

import com.jm.projects.airBnbApp.dto.BookingDto;
import com.jm.projects.airBnbApp.dto.BookingRequest;
import com.jm.projects.airBnbApp.entity.*;
import com.jm.projects.airBnbApp.entity.enums.BookingStatus;
import com.jm.projects.airBnbApp.exception.ResourceNotFoundException;
import com.jm.projects.airBnbApp.repository.BookingRepository;
import com.jm.projects.airBnbApp.repository.HotelRepository;
import com.jm.projects.airBnbApp.repository.InventoryRepository;
import com.jm.projects.airBnbApp.repository.RoomRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;
    private final InventoryRepository inventoryRepository;

    @Override
    @Transactional
    public BookingDto initialiseBooking(BookingRequest bookingRequest) {
        log.info("initialising booking for hotel: {}, room: {}, date {}-{}", bookingRequest.getHotelId(),
                bookingRequest.getRoomId(), bookingRequest.getCheckInDate(), bookingRequest
                        .getCheckOutDate());
        Hotel hotel = hotelRepository.findById(bookingRequest.getHotelId()).orElseThrow(() ->
                new ResourceNotFoundException("Hotel not found with id: " + bookingRequest.getHotelId()));

        Room room = roomRepository.findById(bookingRequest.getRoomId()).orElseThrow(() ->
                new ResourceNotFoundException("Room not found with id: " + bookingRequest.getRoomId()));

        List<Inventory> inventoryList = inventoryRepository.findAndLockAvailableInventory(room.getId(),
                bookingRequest.getCheckInDate(), bookingRequest.getCheckOutDate(), bookingRequest.getRoomsCount());

        long daysCount = ChronoUnit.DAYS.between(bookingRequest.getCheckInDate(), bookingRequest.getCheckOutDate());

        if(inventoryList.size() != daysCount){
            throw new IllegalStateException("Room is not available anymore");
        }

        // Reserve the room / update the booked count of inventories
        for (Inventory inventory: inventoryList){
            inventory.setBookedCount(inventory.getBookedCount() + bookingRequest.getRoomsCount());

            inventoryRepository.saveAll(inventoryList);
        }

        // Create the booking
        User user = new User();
        user.setId(1L); //TODO: REMOVE DUMMY USER

        //TODO: calculate dynamic amount

        Booking booking = Booking.builder()
                .bookingStatus(BookingStatus.RESERVED)
                .hotel(hotel)
                .room(room)
                .checkInDate(bookingRequest.getCheckInDate())
                .checkOutDate(bookingRequest.getCheckOutDate())
                .user(user)
                .roomCount(bookingRequest.getRoomsCount())

                .build();
    }
}
