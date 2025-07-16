package com.oglasi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.oglasi.models.Korisnik;
import com.oglasi.services.KorisnikService;

@RestController
@RequestMapping("/api/korisnici")
public class KorisnikController {

    @Autowired
    private KorisnikService korisnikService;

    @GetMapping
    public List<Korisnik> getAllKorisnici() {
        return korisnikService.getAllKorisnici();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Korisnik> getKorisnikById(@PathVariable Long id) {
        return korisnikService.getKorisnikById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Korisnik createKorisnik(@RequestBody Korisnik korisnik) {
        return korisnikService.saveKorisnik(korisnik);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Korisnik> updateKorisnik(@PathVariable Long id, @RequestBody Korisnik korisnik) {
        return korisnikService.getKorisnikById(id)
                .map(existing -> {
                    korisnik.setId(id);
                    Korisnik updated = korisnikService.saveKorisnik(korisnik);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKorisnik(@PathVariable Long id) {
        korisnikService.deleteKorisnik(id);
        return ResponseEntity.noContent().build();
    }
}
