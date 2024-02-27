package com.example.evenmentsgcrm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "events")

public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate eventDate;

    private LocalTime startTime;

    private LocalTime endTime;

    private double latitude; // Latitude de l'emplacement de l'événement

    private double longitude; // Longitude de l'emplacement de l'événement

}