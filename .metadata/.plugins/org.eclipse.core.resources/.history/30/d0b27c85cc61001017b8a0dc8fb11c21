package com.oglasi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oglasi.models.Korisnik;
import com.oglasi.repositories.KorisnikRepository;

@Service
public class KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;

    public List<Korisnik> getAllKorisnici() {
        return korisnikRepository.findAll();
    }

    public Optional<Korisnik> getKorisnikById(Long id) {
        return korisnikRepository.findById(id);
    }

    public Korisnik saveKorisnik(Korisnik korisnik) {
        return korisnikRepository.save(korisnik);
    }

    public void deleteKorisnik(Long id) {
        korisnikRepository.deleteById(id);
    }
}
