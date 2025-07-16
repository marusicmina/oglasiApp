package com.oglasi.repositories;

import com.oglasi.models.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OglasRepository extends JpaRepository<Oglas, Long> {
    
    List<Oglas> findByNazivContainingIgnoreCase(String naziv);
    List<Oglas> findByKategorija(Kategorija kategorija);

}
