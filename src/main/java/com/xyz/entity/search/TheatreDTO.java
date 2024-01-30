package com.xyz.entity.search;

import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TheatreDTO {

    private String city;
    private LocalTime startTime;
}
