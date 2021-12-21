package com.example.kommunevalgbackend.Restcontroller;

import com.example.kommunevalgbackend.Model.Kandidat;
import com.example.kommunevalgbackend.Model.Parti;
import com.example.kommunevalgbackend.Repository.KandidatRepository;
import com.example.kommunevalgbackend.Repository.PartiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class Restcontroller {

    @Autowired
    KandidatRepository kandidatRepository;
    @Autowired
    PartiRepository partiRepository;

    //Fetch Parti
    @GetMapping("/fetchPartier")
    public List<Parti> fetchPartier(){
        return partiRepository.findAll();
    }
    @GetMapping("/fetchParti/{partiId}")
    public Optional<Parti> fetchParti(@PathVariable int partiId){
        return partiRepository.findById(partiId);
    }

    // delete, edit/save
    @GetMapping("/deleteParti/{partiId}")
    public void deleteParti(@PathVariable int partiId){
        partiRepository.deleteById(partiId);
    }
    @PostMapping(value = "/saveParti", consumes = "application/json")
    public void saveParti(@RequestBody Parti parti){
        partiRepository.save(parti);
    }


    //**************************************************************************

    //Fetch Kandidat
    @GetMapping("/fetchKandidater/{partiId}")
    public List<Kandidat> fetchKandidater(@PathVariable int partiId){
        return kandidatRepository.fetchKandidaterByParti(partiId);
    }
    @GetMapping("/fetchKandidat/{kandidatId}")
    public Optional<Kandidat> fetchKandidat(@PathVariable int kandidatId) {
        return kandidatRepository.findById(kandidatId);
    }

    // Delete, Edit/save
    @GetMapping("/deleteKandidat/{kandidatId}")
    public void deleteKandidat(@PathVariable int kandidatId){
        Optional<Kandidat> kandidat = kandidatRepository.findById(kandidatId);
        kandidat.ifPresent(k -> partiRepository.decrementKandidatCount(k.getParti().getPartiId()));
        kandidatRepository.deleteById(kandidatId);
    }
    @PostMapping(value = "/updateKandidat",consumes = "application/json")
    public void updateKandidat(@RequestBody Kandidat kandidat){
        kandidatRepository.save(kandidat);
    }
    @PostMapping(value = "/saveKandidat",consumes = "application/json")
    public void saveKandidat(@RequestBody Kandidat kandidat){
        partiRepository.incrementKandidatCount(kandidat.getParti().getPartiId());
        kandidatRepository.save(kandidat);
    }

}
