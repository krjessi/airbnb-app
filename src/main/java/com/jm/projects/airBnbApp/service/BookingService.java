package com.jm.projects.airBnbApp.service;

import com.jm.projects.airBnbApp.dto.BookingDto;
import com.jm.projects.airBnbApp.dto.BookingRequest;

public interface BookingService {

    BookingDto initialiseBooking(BookingRequest bookingRequest);
}
