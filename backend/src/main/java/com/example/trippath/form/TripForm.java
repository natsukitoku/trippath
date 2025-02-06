package com.example.trippath.form;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TripForm {
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
}
