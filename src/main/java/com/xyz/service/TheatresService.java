package com.xyz.service;

import com.xyz.entity.search.TheatreDTO;
import com.xyz.model.TheatresGet200Response;
import com.xyz.model.TheatresGet200ResponseTheatresInner;
import com.xyz.model.TheatresGet200ResponseTheatresInnerShowTimingsInner;
import com.xyz.repository.TheatreRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TheatresService {

    private final TheatreRepository theatreRepository;

    public TheatresGet200Response searchTheatres(String movie, LocalDate date, String city) {
        List<TheatreDTO> theatres = theatreRepository.searchTheatre(movie, date, city);
        TheatresGet200Response theatresGet200Response = new TheatresGet200Response();
        List<TheatresGet200ResponseTheatresInner> list = new ArrayList<>();
        for (TheatreDTO theatre : theatres) {
            TheatresGet200ResponseTheatresInner theatresInner = new TheatresGet200ResponseTheatresInner();
            theatresInner.city(theatre.getCity());
            TheatresGet200ResponseTheatresInnerShowTimingsInner showTimingsInner = new TheatresGet200ResponseTheatresInnerShowTimingsInner();
            showTimingsInner.setTime(theatre.getStartTime().toString());
            theatresInner.addShowTimingsItem(showTimingsInner);
            list.add(theatresInner);
        }
        theatresGet200Response.theatres(list);
        return theatresGet200Response;
    }
}
