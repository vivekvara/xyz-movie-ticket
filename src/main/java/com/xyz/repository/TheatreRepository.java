package com.xyz.repository;

import com.xyz.entity.movie.Theatre;
import com.xyz.entity.search.TheatreDTO;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long> {

    @Query(
        "SELECT new com.xyz.entity.search.TheatreDTO(city.name, show.startTime) FROM Show show, TheatreHall hall, Movie movie, Theatre theatre, City city WHERE"
            + " show.theatreHall.id = hall.id AND hall.theatre.id = theatre.id AND show.movie.id = movie.id"
            + " AND city.name = :city AND movie.title = :name AND show.createdOn = :date")
    List<TheatreDTO> searchTheatre(@Param("name") String movie, @Param("date") LocalDate date,
        @Param("city") String city);

}
