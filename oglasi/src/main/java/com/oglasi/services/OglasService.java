package com.oglasi.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oglasi.models.Kategorija;
import com.oglasi.models.Oglas;
import com.oglasi.repositories.OglasRepository;

@Service
public class OglasService {

    @Autowired
    private OglasRepository oglasRepository;

    public List<Oglas> getAllOglasi() {
        return oglasRepository.findAll();
    }

    public Optional<Oglas> getOglasById(Long id) {
        return oglasRepository.findById(id);
    }

    public Oglas saveOglas(Oglas oglas) {
        return oglasRepository.save(oglas);
    }

    public void deleteOglas(Long id) {
        oglasRepository.deleteById(id);
    }
    public List<Oglas> getOglasiByKategorija(Kategorija kategorija) {
        return oglasRepository.findByKategorija(kategorija);
    }

    public List<Oglas> pretraziPoNazivu(String naziv) {
        return oglasRepository.findByNazivContainingIgnoreCase(naziv);
    }

    public List<String> getKategorije(){
    	return Arrays.stream(Kategorija.values())
    			.map(Enum::name)
    			.collect(Collectors.toList());
    }
}
