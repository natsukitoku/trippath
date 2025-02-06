package com.example.trippath.form;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class DestinationForm {
    private Integer tripId;
    private String name;
    private Integer categoryId;
    private String address;
    private String description;
    private float lat;
    private float lon;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}