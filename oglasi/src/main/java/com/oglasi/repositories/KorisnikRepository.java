package com.oglasi.repositories;

import com.oglasi.models.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
    Korisnik findByKorisnickoIme(String korisnickoIme);
}
