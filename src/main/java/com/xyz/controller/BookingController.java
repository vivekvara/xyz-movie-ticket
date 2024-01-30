package com.xyz.controller;

import com.xyz.api.BookingsApi;
import com.xyz.model.BookingsPostRequest;
import com.xyz.service.BookingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class BookingController implements BookingsApi {

    private final BookingService bookingService;

    @Override
    public ResponseEntity<Void> bookingsPost(BookingsPostRequest bookingsPostRequest) {
        log.debug("Received Request {}", bookingsPostRequest);
        return null;
    }
}
