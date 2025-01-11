package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

public record VorstellungDTO(@JsonProperty("vId") int vId,
                             // Änderung in LocalDate vorgenommen, um Parsing-Fehler zu beheben
                             @JsonProperty("datum") @DateTimeFormat(pattern = "dd.MM.YYYY") LocalDate datum,
                             // Änderung in LocalDate vorgenommen, um Parsing-Fehler zu beheben
                             @JsonProperty("uhrzeit") LocalTime uhrzeit,
                             @JsonProperty("saalname") String saalname,
                             @JsonProperty("filmId") int filmId) {}
