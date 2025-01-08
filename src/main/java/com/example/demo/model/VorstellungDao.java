package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.Date;
import java.sql.Time;
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

    
    public List<VorstellungDTO> getVorstellungenByDatum(Date datum) {
        // TODO: Aufgabe 4c) 
        return null;
    }

     
    public List<VorstellungDTO> getVorstellungenByUhrzeit(Time uhrzeit) {
        // TODO: Aufgabe 4c)
        return null;
    }

    // Vorher Klassen Date und Time. Geändert auf LocalDate und LocalTime, da in Controller LocalDate und LocalTime übergeben wurde.
    public List<VorstellungDTO> getVorstellungenByDatumAndUhrzeit(LocalDate datum, LocalTime uhrzeit) {
        // TODO: Aufgabe 4c) 
        return null;
    }
    
    public void saveVorstellung(VorstellungDTO vorstellung) {
        // TODO: Aufgabe 4e) speichere eine neue Vorstellung
        return;
    }

}

