package com.example.demo.model;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

public record VorstellungDTO(@JsonProperty("vId") int vId,
                             @JsonProperty("datum") @DateTimeFormat(pattern = "dd.MM.YYYY") LocalDate datum,
                             @JsonProperty("uhrzeit") LocalTime uhrzeit,
                             @JsonProperty("saalname") String saalname,
                             @JsonProperty("filmId") int filmId) {}
