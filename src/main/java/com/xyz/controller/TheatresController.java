package com.xyz.controller;

import com.xyz.api.TheatresApi;
import com.xyz.model.TheatresGet200Response;
import com.xyz.service.TheatresService;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class TheatresController implements TheatresApi {

    private final TheatresService theatresService;

    @Override
    public ResponseEntity<TheatresGet200Response> theatresGet(String movie, LocalDate date) {
        log.debug("Received Request {}, {}", movie, date);

        // City can be fetched from city context which was set by user once logged in
        String city = "New York";

        return ResponseEntity.ok(theatresService.searchTheatres(movie, date, city));
    }
}
