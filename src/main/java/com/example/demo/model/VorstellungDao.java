package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public class VorstellungDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public List<VorstellungDTO> getAllVorstellungen() {
        // TODO: Aufgabe 4c)
        // Viel einfachere Umsetzung wie in Propra2 besprochen durch Übergabe eine neuen Objekte von DataClassRowMapper.
        String sql = "SELECT * FROM vorstellung";
        return jdbcTemplate.query(sql, new DataClassRowMapper<>(VorstellungDTO.class));
    }

    // Änderung in LocalDate vorgenommen, um Parsing-Fehler zu beheben
    public List<VorstellungDTO> getVorstellungenByDatum(LocalDate datum) {
        // TODO: Aufgabe 4c)
        String sql = "SELECT * FROM vorstellung WHERE datum = ?";
        // datum hier übergeben // mit DataClassRowMapper Erzeugung wie in Propra2
        return jdbcTemplate.query(sql, new Object[]{datum}, new DataClassRowMapper<>(VorstellungDTO.class));
    }

    // Änderung in LocalTime vorgenommen, um Parsing-Fehler zu beheben
    public List<VorstellungDTO> getVorstellungenByUhrzeit(LocalTime uhrzeit) {
        // TODO: Aufgabe 4c)
        String sql = "SELECT * FROM vorstellung WHERE uhrzeit = ?";
        // uhzeit muss hier übergeben werden // mit DataClassRowMapper Erzeugung wie in Propra2
        return jdbcTemplate.query(sql, new Object[]{uhrzeit}, new DataClassRowMapper<>(VorstellungDTO.class));
    }

    // Vorher Klassen Date und Time. Geändert auf LocalDate und LocalTime, da in Controller LocalDate und LocalTime übergeben wurde.
    public List<VorstellungDTO> getVorstellungenByDatumAndUhrzeit(LocalDate datum, LocalTime uhrzeit) {
        // TODO: Aufgabe 4c)
        String sql = "SELECT * FROM vorstellung WHERE datum = ? AND uhrzeit = ?";
        // beides muss hier übergeben werden // mit DataClassRowMapper Erzeugung wie in Propra2
        return jdbcTemplate.query(sql, new Object[]{datum, uhrzeit}, new DataClassRowMapper<>(VorstellungDTO.class));

    }
    
    public void saveVorstellung(VorstellungDTO vorstellung) {
        // TODO: Aufgabe 4e) speichere eine neue Vorstellung
        String sql = "INSERT INTO vorstellung (vId, datum, uhrzeit, saalname, filmId) VALUES (?, ?, ?, ?, ?)";
        // Alle Werte des DTOs, die ursprünglich aus der Eingabe stammen in die Query übergeben und dann in die DB schreiben
        jdbcTemplate.update(sql, vorstellung.vId(), vorstellung.datum(), vorstellung.uhrzeit(), vorstellung.saalname(), vorstellung.filmId());
    }

}

