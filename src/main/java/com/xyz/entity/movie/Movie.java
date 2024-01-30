package com.xyz.entity.movie;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer durationInMins;

    @Column(nullable = false)
    private String language;

    @Column(nullable = false)
    private LocalDateTime releaseDate;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private String movieAddedBy;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Show> shows = new ArrayList<>();

    @Column(nullable = false)
    private LocalDateTime createdDate;

    @Column(nullable = false)
    private String createdBy;

    @Column
    private LocalDateTime updatedDate;

    @Column
    private String updatedBy;
}
